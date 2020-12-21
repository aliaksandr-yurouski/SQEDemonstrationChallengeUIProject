package com.sample.test;

import com.sample.core.basetest.TestBase;
import com.sample.constants.PizzaTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CorrectCostCalculationTest extends TestBase {

    private final PizzaTypes PIZZA_TYPE = PizzaTypes.SMALL_NOTOPPINGS;
    private final int QUANTITY = 2;

    @Test(description = "Check correct calculation of Cost field.")
    public void correctCostCalculationTest() {
        pizzaOrderFormPage.selectPizzaType(PIZZA_TYPE.getDisplayName());
        pizzaOrderFormPage.setQuantity(Integer.toString(QUANTITY));

        double expectedCost = PIZZA_TYPE.getCost() * QUANTITY;
        double actualCost = Double.parseDouble(pizzaOrderFormPage.getCost());
        Assert.assertEquals(expectedCost, actualCost,
                String.format("Actual value of cost are not as expected: %s instead of %s", actualCost, expectedCost));
    }

}
