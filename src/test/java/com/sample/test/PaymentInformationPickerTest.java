package com.sample.test;

import com.sample.core.basetest.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PaymentInformationPickerTest extends TestBase {

    @Test
    public void paymentInformationPickerTest() {
        SoftAssert softAssert = new SoftAssert();

        pizzaOrderFormPage.selectRadioCreditCard();
        softAssert.assertTrue(pizzaOrderFormPage.isRadioCreditCardSelected(),
                "Step one. Credit Card payment method is not selected");
        softAssert.assertFalse(pizzaOrderFormPage.isRadioCashSelected(),
                "Step one. Cash payment method is selected");

        pizzaOrderFormPage.selectRadioCash();
        softAssert.assertFalse(pizzaOrderFormPage.isRadioCreditCardSelected(),
                "Step two. Credit Card payment method is selected");
        softAssert.assertTrue(pizzaOrderFormPage.isRadioCashSelected(),
                "Step two. Cash payment method is not selected");

        softAssert.assertAll();
    }

}
