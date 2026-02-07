package com.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration from properties file
 */
public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties properties;
    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH);
            properties.load(fis);
            fis.close();
            logger.info("Configuration file loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load configuration file: " + e.getMessage());
            throw new RuntimeException("Configuration file not found at: " + CONFIG_FILE_PATH);
        }
    }

    /**
     * Get property value by key
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("Property not found: " + key);
        }
        return value;
    }

    /**
     * Get application URL
     */
    public static String getAppUrl() {
        return getProperty("app.url");
    }

    /**
     * Get browser type
     */
    public static String getBrowser() {
        return getProperty("browser");
    }

    /**
     * Get implicit wait time
     */
    public static int getImplicitWait() {
        return Integer.parseInt(getProperty("implicit.wait"));
    }

    /**
     * Get explicit wait time
     */
    public static int getExplicitWait() {
        return Integer.parseInt(getProperty("explicit.wait"));
    }

    /**
     * Get page load timeout
     */
    public static int getPageLoadTimeout() {
        return Integer.parseInt(getProperty("page.load.timeout"));
    }

    /**
     * Check if headless mode is enabled
     */
    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }
}
