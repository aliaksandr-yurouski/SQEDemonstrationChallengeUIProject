package com.sample.test;

import com.sample.helpers.PizzaOrderHelper;
import com.sample.model.OrderForm;
import com.sample.core.basetest.TestBase;
import com.sample.constants.PizzaToppings;
import com.sample.constants.PizzaTypes;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ResetOrderFormTest extends TestBase {

    private final OrderForm order = OrderForm.builder().pizzaType(PizzaTypes.LARE_NOTOPPINGS)
            .pizzaTopping1(PizzaToppings.EXTRACHEESE)
            .pizzaTopping2(PizzaToppings.ITALIANHAM)
            .quantity(2)
            .email("example@gmail.com")
            .name("test")
            .phone("+123456789012")
            .isCash(true)
            .isCreditCard(false)
            .build();

    @Test(description = "Check reset form functionality.")
    public void resetOrderFormTest() {
        SoftAssert softAssert = new SoftAssert();

        PizzaOrderHelper.fillOrderForm(pizzaOrderFormPage, order);
        pizzaOrderFormPage.clickResetButton();

        softAssert.assertEquals(pizzaOrderFormPage.getPizzaType(), "Choose Pizza",
                "Default value of 'Pizza 1' field is not expected after reset.");
        softAssert.assertEquals(pizzaOrderFormPage.getFirstPizzaTopping(), "Choose a Toppings 1",
                "Default value of 'Toppings 1' field is not expected after reset.");
        softAssert.assertEquals(pizzaOrderFormPage.getSecondPizzaTopping(), "Choose a Toppings 2",
                "Default value of 'Toppings2' field is not expected after reset.");
        softAssert.assertEquals(pizzaOrderFormPage.getQuantity(), "0",
                "Default value of 'Quantity' field is not expected after reset.");
        softAssert.assertEquals(pizzaOrderFormPage.getCost(), "0",
                "Default value of 'Cost' field is not expected after reset.");
        softAssert.assertTrue(pizzaOrderFormPage.getName().isEmpty(), "'Name' field is not empty after reset.");
        softAssert.assertTrue(pizzaOrderFormPage.getEmail().isEmpty(), "'Email' field is not empty after reset.");
        softAssert.assertTrue(pizzaOrderFormPage.getPhone().isEmpty(), "'Phone' field is not empty after reset.");
        softAssert.assertFalse(pizzaOrderFormPage.isRadioCreditCardSelected(),
                "'Credit card' radiobutton is in selected state after reset.");
        softAssert.assertFalse(pizzaOrderFormPage.isRadioCashSelected(),
                "'Cash on Pickup' radiobutton is in selected state after reset.");

        softAssert.assertAll();
    }

}
