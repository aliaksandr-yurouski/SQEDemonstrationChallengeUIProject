package com.sample.core.listener;

import com.sample.core.config.Configuration;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.sample.utils.ScreenshotUtils.attachScreenShot;

@Log4j
public class TestListener implements ITestListener {

    private final Configuration config = new Configuration();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("***** " + iTestResult.getName() + " test has started *****");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("***** " + iTestResult.getName() + " test has succeed *****");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("***** Error " + iTestResult.getName() + " test has failed *****");
        String methodName = iTestResult.getName().trim();
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver)context.getAttribute("driver");
        attachScreenShot(methodName, driver, System.getProperty("user.dir") + config.getScreenshotFolder());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("***** " + iTestResult.getName() + " test has skipped *****");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
