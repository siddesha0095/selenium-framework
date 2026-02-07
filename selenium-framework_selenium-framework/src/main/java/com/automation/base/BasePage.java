package com.automation.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import com.automation.utils.ConfigReader;

/**
 * Base Page class with common methods for all page objects
 */
public class BasePage {
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor to initialize driver and wait
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait for element to be visible
     */
    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for element to be clickable
     */
    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Click on element
     */
    protected void clickElement(WebElement element, String elementName) {
        try {
            waitForElementToBeClickable(element);
            element.click();
            logger.info("Clicked on: " + elementName);
        } catch (Exception e) {
            logger.error("Failed to click on: " + elementName);
            throw e;
        }
    }

    /**
     * Enter text in element
     */
    protected void enterText(WebElement element, String text, String elementName) {
        try {
            waitForElementToBeVisible(element);
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text in " + elementName + ": " + text);
        } catch (Exception e) {
            logger.error("Failed to enter text in: " + elementName);
            throw e;
        }
    }

    /**
     * Get text from element
     */
    protected String getElementText(WebElement element, String elementName) {
        try {
            waitForElementToBeVisible(element);
            String text = element.getText();
            logger.info("Retrieved text from " + elementName + ": " + text);
            return text;
        } catch (Exception e) {
            logger.error("Failed to get text from: " + elementName);
            throw e;
        }
    }

    /**
     * Check if element is displayed
     */
    protected boolean isElementDisplayed(WebElement element, String elementName) {
        try {
            boolean isDisplayed = element.isDisplayed();
            logger.info(elementName + " is displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            logger.info(elementName + " is not displayed");
            return false;
        }
    }

    /**
     * Scroll to element
     */
    protected void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info("Scrolled to element");
    }

    /**
     * Get page title
     */
    protected String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Current page title: " + title);
        return title;
    }

    /**
     * Get current URL
     */
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: " + url);
        return url;
    }

    /**
     * Wait for page to load
     */
    protected void waitForPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        logger.info("Page loaded successfully");
    }
}
