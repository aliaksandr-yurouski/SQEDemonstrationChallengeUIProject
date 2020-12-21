package com.sample.utils;

import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Log4j
public class ScreenshotUtils {

    private ScreenshotUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void attachScreenShot(String methodName, WebDriver driver, String filePath) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Allure.addAttachment(filePath + methodName + ".png", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        try {
            FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
            log.debug("***Placed screen shot in " + filePath + " ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
