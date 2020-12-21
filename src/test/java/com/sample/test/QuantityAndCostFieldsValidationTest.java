package com.sample.test;

import com.sample.core.basetest.TestBase;
import com.sample.constants.PizzaTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class QuantityAndCostFieldsValidationTest extends TestBase {

    private final PizzaTypes pizzaType = PizzaTypes.LARGE_THREETOPPINGS;
    private final int minValue = 0;
    private final int maxValue = 10000;

    @Test(description = "Check validation for 'Quantity' and 'Cost' fields.",
        dataProvider = "QuantityAndCostFieldsTestDataProvider")
    public void quantityAndCostFieldsValidationTest(String enteredQuantity, int expectedQuantity, int expectedCost) {
        SoftAssert softAssert = new SoftAssert();

        pizzaOrderFormPage.selectPizzaType(pizzaType.getDisplayName());
        pizzaOrderFormPage.setQuantity(enteredQuantity);

        softAssert.assertEquals(pizzaOrderFormPage.getQuantity(), String.valueOf(expectedQuantity),
                String.format("Value for the 'Quantity' field is not as expected entering '%s' quantity.", enteredQuantity));
        softAssert.assertEquals(pizzaOrderFormPage.getCost(), String.valueOf(expectedCost),
                String.format("Value for the 'Cost' field is not as expected entering '%s' quantity.", enteredQuantity));

        softAssert.assertAll();
    }

    @DataProvider(name = "QuantityAndCostFieldsTestDataProvider")
    public Object[][] quantityAndCostFieldsTestDataProvider(){
        return new Object[][]
                {
                        { "-1", minValue, minValue },
                        { "100000", maxValue, new Double(pizzaType.getCost() * maxValue).intValue() },
                        { "foo", minValue, minValue },
                        { "!@#$%&", minValue, minValue }
                };

    }
}
