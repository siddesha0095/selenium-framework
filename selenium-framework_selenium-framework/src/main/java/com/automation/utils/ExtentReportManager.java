package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Extent Report Manager to handle report generation
 */
public class ExtentReportManager {
    private static final Logger logger = LogManager.getLogger(ExtentReportManager.class);
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static String reportPath;

    /**
     * Initialize Extent Reports
     */
    public static void initReports() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport_" + timestamp + ".html";
            
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            
            // Configure report settings
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Facebook Login Test Suite");
            sparkReporter.config().setTheme(Theme.STANDARD);
            sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            
            // System information
            extent.setSystemInfo("Application", "Facebook");
            extent.setSystemInfo("Operating System", System.getProperty("os.name"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", ConfigReader.getBrowser());
            
            logger.info("Extent Report initialized at: " + reportPath);
        }
    }

    /**
     * Create a new test in the report
     */
    public static void createTest(String testName, String description) {
        ExtentTest test = extent.createTest(testName, description);
        extentTest.set(test);
        logger.info("Created test: " + testName);
    }

    /**
     * Get the current test
     */
    public static ExtentTest getTest() {
        return extentTest.get();
    }

    /**
     * Flush the report
     */
    public static void flushReports() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report flushed successfully");
        }
    }

    /**
     * Get report path
     */
    public static String getReportPath() {
        return reportPath;
    }

    /**
     * Remove test from thread local
     */
    public static void removeTest() {
        extentTest.remove();
    }
}
