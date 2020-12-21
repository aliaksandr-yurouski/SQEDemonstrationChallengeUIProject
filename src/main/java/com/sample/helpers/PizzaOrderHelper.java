package com.sample.helpers;

import com.sample.model.OrderForm;
import com.sample.pageobject.PizzaOrderFormPage;

import java.util.Optional;

public class PizzaOrderHelper {

    private PizzaOrderHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static void fillOrderForm(PizzaOrderFormPage page, OrderForm orderForm) {
        if (orderForm.getPizzaType() != null) page.selectPizzaType(orderForm.getPizzaType().getDisplayName());
        if (orderForm.getPizzaTopping1() != null) {
            page.selectFirstPizzaTopping(orderForm.getPizzaTopping1().getDisplayName());
        }
        if (orderForm.getPizzaTopping2() != null) {
            page.selectSecondPizzaTopping(orderForm.getPizzaTopping2().getDisplayName());
        }
        if (orderForm.getQuantity() != 0) page.setQuantity(String.valueOf(orderForm.getQuantity()));
        if (orderForm.getPhone() != null) page.setPhone(orderForm.getPhone());
        if (orderForm.getName() != null) page.setName(orderForm.getName());
        if (orderForm.getEmail() != null) page.setEmail(orderForm.getEmail());
        if (orderForm.isCreditCard()) {
            page.selectRadioCreditCard();
        }
        if (orderForm.isCash()) {
            page.selectRadioCash();
        }
    }

}
