package com.automation.listeners;

import com.automation.base.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ScreenshotUtility;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestNG Listener for Extent Reports and Screenshot capture
 */
public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started: " + context.getName());
        ExtentReportManager.initReports();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Finished: " + context.getName());
        ExtentReportManager.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: " + result.getMethod().getMethodName());
        String description = result.getMethod().getDescription();
        if (description == null || description.isEmpty()) {
            description = "Test execution for " + result.getMethod().getMethodName();
        }
        ExtentReportManager.createTest(result.getMethod().getMethodName(), description);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getMethod().getMethodName());
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getMethod().getMethodName());
        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        ExtentReportManager.getTest().log(Status.FAIL, result.getThrowable());

        // Capture screenshot on failure
        try {
            String screenshotBase64 = ScreenshotUtility.captureScreenshotAsBase64(BaseTest.getDriver());
            if (screenshotBase64 != null) {
                ExtentReportManager.getTest().addScreenCaptureFromBase64String(screenshotBase64, 
                    "Failure Screenshot");
            }
        } catch (Exception e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getMethod().getMethodName());
        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        if (result.getThrowable() != null) {
            ExtentReportManager.getTest().log(Status.SKIP, result.getThrowable());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test Failed but within success percentage: " + result.getMethod().getMethodName());
    }
}
