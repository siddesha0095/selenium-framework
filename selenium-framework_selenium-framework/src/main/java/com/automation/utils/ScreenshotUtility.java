package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for taking screenshots
 */
public class ScreenshotUtility {
    private static final Logger logger = LogManager.getLogger(ScreenshotUtility.class);
    private static final String SCREENSHOT_DIR = System.getProperty("user.dir") + "/screenshots/";

    /**
     * Take screenshot and save to file
     */
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        String screenshotPath = SCREENSHOT_DIR + fileName;

        try {
            // Create screenshots directory if it doesn't exist
            File directory = new File(SCREENSHOT_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Capture screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);

            logger.info("Screenshot captured: " + screenshotPath);
            return screenshotPath;
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }

    /**
     * Capture screenshot and return as base64 string for Extent Report
     */
    public static String captureScreenshotAsBase64(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            return ts.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot as Base64: " + e.getMessage());
            return null;
        }
    }
}
