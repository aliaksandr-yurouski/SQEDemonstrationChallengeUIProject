package com.sample.test;

import com.sample.helpers.PizzaOrderHelper;
import com.sample.model.OrderForm;
import com.sample.core.basetest.TestBase;
import com.sample.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MandatoryFieldsValidationTest extends TestBase {

    @Test(description = "Check validation for mandatory fields Name and Phone.",
            dataProvider = "MandatoryFieldsTestDataProvider")
    public void mandatoryFieldsValidationTest(OrderForm order, List<String> expectedNotifications) {
        PizzaOrderHelper.fillOrderForm(pizzaOrderFormPage, order);
        pizzaOrderFormPage.clickPlaceOrderButton();

        Assert.assertTrue(pizzaOrderFormPage.isNotificationPopupAppears());
        Assert.assertEquals(pizzaOrderFormPage.getNotifications(), expectedNotifications);
    }

    @AfterMethod
    public void afterMethodTearDown() {
        pizzaOrderFormPage.closeDialog();
        pizzaOrderFormPage.clickResetButton();
    }

    @DataProvider(name = "MandatoryFieldsTestDataProvider")
    public Object[][] mandatoryFieldsTestDataProvider(){
        return new Object[][]
                {
                        { OrderForm.builder()
                                .pizzaType(PizzaTypes.LARGE_THREETOPPINGS)
                                .name("test")
                                .build(),
                                Collections.singletonList("Missing phone number") },
                        { OrderForm.builder()
                                .pizzaType(PizzaTypes.LARGE_THREETOPPINGS)
                                .phone("test")
                                .build(),
                                Collections.singletonList("Missing name") },
                        { OrderForm.builder()
                                .pizzaType(PizzaTypes.LARGE_THREETOPPINGS)
                                .build(),
                                Arrays.asList("Missing name", "Missing phone number") }
                };

    }

}
