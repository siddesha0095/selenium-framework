package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for custom waits
 */
public class WaitUtility {
    private static final Logger logger = LogManager.getLogger(WaitUtility.class);

    /**
     * Wait for element to be visible
     */
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not visible within " + timeoutInSeconds + " seconds");
            throw e;
        }
    }

    /**
     * Wait for element to be clickable
     */
    public static WebElement waitForClickability(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not clickable within " + timeoutInSeconds + " seconds");
            throw e;
        }
    }

    /**
     * Wait for element presence by locator
     */
    public static WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            logger.error("Element not present within " + timeoutInSeconds + " seconds");
            throw e;
        }
    }

    /**
     * Wait for alert to be present
     */
    public static void waitForAlert(WebDriver driver, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.alertIsPresent());
            logger.info("Alert is present");
        } catch (Exception e) {
            logger.error("Alert not present within " + timeoutInSeconds + " seconds");
            throw e;
        }
    }

    /**
     * Custom sleep (use sparingly)
     */
    public static void hardWait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            logger.error("Sleep interrupted: " + e.getMessage());
        }
    }
}
