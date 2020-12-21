package com.sample.core.basetest;

import static org.testng.Assert.fail;

import com.sample.core.config.Configuration;
import com.sample.pageobject.PizzaOrderFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    private Configuration config;
    protected WebDriver driver;
    protected String url;
    protected PizzaOrderFormPage pizzaOrderFormPage;

    @BeforeClass(alwaysRun = true)
    public void init(ITestContext context) throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializelDriver();
        navigateToSite();
        context.setAttribute("driver", driver);
        pizzaOrderFormPage = new PizzaOrderFormPage(driver);
    }

    private void navigateToSite() {
        driver.get(url);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver",
                        "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }


}
