package com.sample.model;

import com.sample.constants.PizzaToppings;
import com.sample.constants.PizzaTypes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderForm {
    private PizzaTypes pizzaType;
    private PizzaToppings pizzaTopping1;
    private PizzaToppings pizzaTopping2;
    private int quantity;
    private double cost;
    private String name;
    private String email;
    private String phone;
    private boolean isCreditCard;
    private boolean isCash;
}

