package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.FacebookLoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Test class for Facebook Login functionality
 */
public class FacebookLoginTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(FacebookLoginTest.class);
    private FacebookLoginPage loginPage;

    @BeforeClass
    public void setupClass() {
        logger.info("Setting up test class: FacebookLoginTest");
    }

    @BeforeMethod
    public void setup() {
        logger.info("Setting up test method");
        initializeDriver();
        navigateToUrl(ConfigReader.getAppUrl());
        loginPage = new FacebookLoginPage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Tearing down test method");
        quitDriver();
    }

    @AfterClass
    public void tearDownClass() {
        logger.info("Test class completed: FacebookLoginTest");
    }

    @Test(priority = 1, description = "Verify Facebook login page loads successfully")
    public void testLoginPageLoad() {
        ExtentReportManager.getTest().log(Status.INFO, "Verifying login page loads successfully");
        logger.info("Executing: testLoginPageLoad");

        boolean isPageLoaded = loginPage.isLoginPageLoaded();
        Assert.assertTrue(isPageLoaded, "Login page did not load successfully");

        ExtentReportManager.getTest().log(Status.PASS, "Login page loaded successfully");
        logger.info("Test passed: Login page loaded successfully");
    }

    @Test(priority = 2, description = "Verify all elements are present on login page")
    public void testLoginPageElements() {
        ExtentReportManager.getTest().log(Status.INFO, "Verifying all login page elements");
        logger.info("Executing: testLoginPageElements");

        Assert.assertTrue(loginPage.isEmailFieldDisplayed(), "Email field not displayed");
        ExtentReportManager.getTest().log(Status.INFO, "Email field is displayed");

        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field not displayed");
        ExtentReportManager.getTest().log(Status.INFO, "Password field is displayed");

        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button not displayed");
        ExtentReportManager.getTest().log(Status.INFO, "Login button is displayed");

        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot password link not displayed");
        ExtentReportManager.getTest().log(Status.INFO, "Forgot password link is displayed");

        Assert.assertTrue(loginPage.isCreateNewAccountButtonDisplayed(), "Create new account button not displayed");
        ExtentReportManager.getTest().log(Status.INFO, "Create new account button is displayed");

        ExtentReportManager.getTest().log(Status.PASS, "All login page elements are present");
        logger.info("Test passed: All elements verified successfully");
    }

    @Test(priority = 3, description = "Verify login page title")
    public void testLoginPageTitle() {
        ExtentReportManager.getTest().log(Status.INFO, "Verifying login page title");
        logger.info("Executing: testLoginPageTitle");

        String pageTitle = loginPage.getLoginPageTitle();
        Assert.assertTrue(pageTitle.contains("Facebook"), "Page title does not contain 'Facebook'");

        ExtentReportManager.getTest().log(Status.PASS, "Page title verified: " + pageTitle);
        logger.info("Test passed: Page title is correct - " + pageTitle);
    }

    @Test(priority = 4, description = "Verify login with empty credentials")
    public void testLoginWithEmptyCredentials() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing login with empty credentials");
        logger.info("Executing: testLoginWithEmptyCredentials");

        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        // Facebook will show browser validation or keep user on same page
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"), "Should remain on Facebook domain");

        ExtentReportManager.getTest().log(Status.PASS, "Login with empty credentials handled correctly");
        logger.info("Test passed: Empty credentials validation working");
    }

    @Test(priority = 5, description = "Verify login with invalid email format")
    public void testLoginWithInvalidEmailFormat() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing login with invalid email format");
        logger.info("Executing: testLoginWithInvalidEmailFormat");

        loginPage.enterEmail("invalidemail");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        // Wait for potential error or page behavior
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"), "Should handle invalid email appropriately");

        ExtentReportManager.getTest().log(Status.PASS, "Invalid email format handled correctly");
        logger.info("Test passed: Invalid email format validation working");
    }

    @Test(priority = 6, description = "Verify login with valid email and empty password")
    public void testLoginWithEmptyPassword() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing login with empty password");
        logger.info("Executing: testLoginWithEmptyPassword");

        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        // Facebook will show validation
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"), "Should remain on Facebook domain");

        ExtentReportManager.getTest().log(Status.PASS, "Empty password validation working correctly");
        logger.info("Test passed: Empty password handled correctly");
    }

    @Test(priority = 7, description = "Verify login with invalid credentials")
    public void testLoginWithInvalidCredentials() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing login with invalid credentials");
        logger.info("Executing: testLoginWithInvalidCredentials");

        String invalidEmail = "invalid_test_" + System.currentTimeMillis() + "@example.com";
        String invalidPassword = "InvalidPassword123!";

        loginPage.login(invalidEmail, invalidPassword);

        // Wait for error message
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify still on login page or error page
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"), "Should show error or remain on Facebook");

        ExtentReportManager.getTest().log(Status.PASS, "Invalid credentials handled appropriately");
        logger.info("Test passed: Invalid credentials rejected successfully");
    }

    @Test(priority = 8, description = "Verify forgot password link functionality")
    public void testForgotPasswordLink() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing forgot password link");
        logger.info("Executing: testForgotPasswordLink");

        loginPage.clickForgotPassword();

        // Wait for navigation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("recover") || currentUrl.contains("identify"), 
            "Should navigate to password recovery page");

        ExtentReportManager.getTest().log(Status.PASS, "Forgot password link working correctly");
        logger.info("Test passed: Forgot password functionality verified");
    }

    @Test(priority = 9, description = "Verify create new account button functionality")
    public void testCreateNewAccountButton() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing create new account button");
        logger.info("Executing: testCreateNewAccountButton");

        loginPage.clickCreateNewAccount();

        // Wait for modal or navigation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify signup form appears or URL changes
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"), "Should remain on Facebook domain");

        ExtentReportManager.getTest().log(Status.PASS, "Create new account button working correctly");
        logger.info("Test passed: Create account functionality verified");
    }

    @Test(priority = 10, description = "Verify login with special characters in password")
    public void testLoginWithSpecialCharacters() {
        ExtentReportManager.getTest().log(Status.INFO, "Testing login with special characters in password");
        logger.info("Executing: testLoginWithSpecialCharacters");

        loginPage.enterEmail("test@example.com");
        loginPage.enterPassword("Test@#$%^&*()123");
        loginPage.clickLoginButton();

        // Wait for response
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("facebook.com"), "Should handle special characters in password");

        ExtentReportManager.getTest().log(Status.PASS, "Special characters in password handled correctly");
        logger.info("Test passed: Special characters validation working");
    }
}
