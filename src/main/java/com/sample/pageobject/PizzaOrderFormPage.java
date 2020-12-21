package com.sample.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class PizzaOrderFormPage {

    @FindBy(tagName = "center")
    private WebElement header;

    @FindBy(id = "pizza1Pizza")
    private WebElement pizza1Dropdown;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
    private WebElement pizza1Toppings1Dropdown;

    @FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
    private WebElement pizza1Toppings2Dropdown;

    @FindBy(id = "pizza1Qty")
    private WebElement pizza1QuantityInput;

    @FindBy(id = "pizza1Cost")
    private WebElement pizza1CostTextField;

    @FindBy(id = "ccpayment")
    private WebElement radioCreditCard;

    @FindBy(id = "cashpayment")
    private WebElement radioCash;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "placeOrder")
    private WebElement placeOrderButton;

    @FindBy(id = "reset")
    private WebElement resetButton;

    @FindBy(id = "dialog")
    private WebElement dialogPopup;

    @FindBy(xpath = "//div[@id='dialog']/p")
    private WebElement dialogPopupNotification;

    @FindBy(xpath = "//button[@title='Close']")
    private WebElement closeDialogButton;

    public PizzaOrderFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectPizzaType(String pizzaType) {
        Select pizzaSelect = new Select(this.pizza1Dropdown);
        pizzaSelect.selectByValue(pizzaType);
    }

    public String getPizzaType() {
        Select pizzaSelect = new Select(this.pizza1Dropdown);
        return pizzaSelect.getFirstSelectedOption().getText();
    }

    public void selectFirstPizzaTopping(String pizzaType) {
        Select pizzaToppingSelect = new Select(this.pizza1Toppings1Dropdown);
        pizzaToppingSelect.selectByValue(pizzaType);
    }

    public String getFirstPizzaTopping() {
        Select pizzaToppingSelect = new Select(this.pizza1Toppings1Dropdown);
        return pizzaToppingSelect.getFirstSelectedOption().getText();
    }

    public void selectSecondPizzaTopping(String pizzaType) {
        Select pizzaToppingSelect = new Select(this.pizza1Toppings2Dropdown);
        pizzaToppingSelect.selectByValue(pizzaType);
    }

    public String getSecondPizzaTopping() {
        Select pizzaToppingSelect = new Select(this.pizza1Toppings2Dropdown);
        return pizzaToppingSelect.getFirstSelectedOption().getText();
    }

    public void setQuantity(String quantity) {
        this.pizza1QuantityInput.clear();
        this.pizza1QuantityInput.sendKeys(quantity);
        this.header.click(); // workaround to unfocus input field to make quantity field being calculated
    }

    public String getQuantity() {
        return this.pizza1QuantityInput.getAttribute("value");
    }

    public void selectRadioCreditCard() {
        this.radioCreditCard.click();
    }

    public void selectRadioCash() {
        this.radioCash.click();
    }

    public boolean isRadioCreditCardSelected() {
        return this.radioCreditCard.isSelected();
    }

    public boolean isRadioCashSelected() {
        return this.radioCash.isSelected();
    }

    public String getCost() {
        return this.pizza1CostTextField.getAttribute("value");
    }

    public void setEmail(String email) {
        this.emailInput.clear();
        this.emailInput.sendKeys(email);
    }

    public String getEmail() {
        return this.emailInput.getAttribute("value");
    }

    public void setName(String name) {
        this.nameInput.clear();
        this.nameInput.sendKeys(name);
    }

    public String getName() {
        return this.nameInput.getAttribute("value");
    }

    public void setPhone(String phone) {
        this.phoneInput.clear();
        this.phoneInput.sendKeys(phone);
    }

    public String getPhone() {
        return this.phoneInput.getAttribute("value");
    }

    public void clickPlaceOrderButton() {
        this.placeOrderButton.click();
    }

    public void clickResetButton() {
        this.resetButton.click();
    }

    public boolean isNotificationPopupAppears() {
        return this.dialogPopup.isDisplayed();
    }

    public List<String> getNotifications() {
        return Arrays.asList(this.dialogPopupNotification.getText().split("\n"));
    }

    public void closeDialog() {
        this.closeDialogButton.click();
    }
}
