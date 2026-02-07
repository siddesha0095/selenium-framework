package com.automation.base;

import com.automation.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Base class for all tests - handles WebDriver initialization and teardown
 */
public class BaseTest {
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initialize WebDriver based on browser configuration
     */
    public static void initializeDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        logger.info("Initializing " + browser + " driver");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (ConfigReader.isHeadless()) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (ConfigReader.isHeadless()) {
                    firefoxOptions.addArguments("--headless");
                }
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (ConfigReader.isHeadless()) {
                    edgeOptions.addArguments("--headless");
                }
                driver.set(new EdgeDriver(edgeOptions));
                break;

            default:
                logger.error("Invalid browser: " + browser);
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // Set timeouts
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigReader.getImplicitWait()));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));
        getDriver().manage().window().maximize();

        logger.info("WebDriver initialized successfully");
    }

    /**
     * Get WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quit WebDriver
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            logger.info("Closing browser");
            driver.get().quit();
            driver.remove();
        }
    }

    /**
     * Navigate to URL
     */
    public static void navigateToUrl(String url) {
        logger.info("Navigating to: " + url);
        getDriver().get(url);
    }
}
