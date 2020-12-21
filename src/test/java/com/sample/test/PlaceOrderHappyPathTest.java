package com.sample.test;

import com.sample.helpers.PizzaOrderHelper;
import com.sample.model.OrderForm;
import com.sample.core.basetest.TestBase;
import com.sample.constants.PizzaToppings;
import com.sample.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class PlaceOrderHappyPathTest extends TestBase {

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

    @Test(description = "Check order functionality.")
    public void mandatoryFieldsValidationTest() {
        PizzaOrderHelper.fillOrderForm(pizzaOrderFormPage, order);

        pizzaOrderFormPage.clickPlaceOrderButton();

        Assert.assertTrue(pizzaOrderFormPage.isNotificationPopupAppears());

        List<String> expectedNotifications = Collections.singletonList(
                String.format("Thank you for your order! TOTAL: %s %s",
                        BigDecimal.valueOf(order.getPizzaType().getCost() * order.getQuantity()).stripTrailingZeros(),
                        order.getPizzaType().getDisplayName()));
        Assert.assertEquals(pizzaOrderFormPage.getNotifications(), expectedNotifications,
                "Notifications are not expected for the successfully placed order.");
    }

}
