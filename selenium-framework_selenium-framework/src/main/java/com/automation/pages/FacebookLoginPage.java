package com.automation.pages;

import com.automation.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object Model for Facebook Login Page
 */
public class FacebookLoginPage extends BasePage {

    // Page Elements using @FindBy annotations
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(linkText = "Forgotten password?")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[@data-testid='open-registration-form-button']")
    private WebElement createNewAccountButton;

    @FindBy(className = "_9ay7")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class, 'error')]")
    private WebElement loginErrorMessage;

    /**
     * Constructor
     */
    public FacebookLoginPage(WebDriver driver) {
        super(driver);
        logger.info("Facebook Login Page initialized");
    }

    /**
     * Enter email address
     */
    public FacebookLoginPage enterEmail(String email) {
        enterText(emailField, email, "Email Field");
        return this;
    }

    /**
     * Enter password
     */
    public FacebookLoginPage enterPassword(String password) {
        enterText(passwordField, password, "Password Field");
        return this;
    }

    /**
     * Click login button
     */
    public void clickLoginButton() {
        clickElement(loginButton, "Login Button");
    }

    /**
     * Perform login operation
     */
    public void login(String email, String password) {
        logger.info("Attempting to login with email: " + email);
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Click forgot password link
     */
    public void clickForgotPassword() {
        clickElement(forgotPasswordLink, "Forgot Password Link");
    }

    /**
     * Click create new account button
     */
    public void clickCreateNewAccount() {
        clickElement(createNewAccountButton, "Create New Account Button");
    }

    /**
     * Check if login button is displayed
     */
    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton, "Login Button");
    }

    /**
     * Check if email field is displayed
     */
    public boolean isEmailFieldDisplayed() {
        return isElementDisplayed(emailField, "Email Field");
    }

    /**
     * Check if password field is displayed
     */
    public boolean isPasswordFieldDisplayed() {
        return isElementDisplayed(passwordField, "Password Field");
    }

    /**
     * Check if forgot password link is displayed
     */
    public boolean isForgotPasswordLinkDisplayed() {
        return isElementDisplayed(forgotPasswordLink, "Forgot Password Link");
    }

    /**
     * Check if create new account button is displayed
     */
    public boolean isCreateNewAccountButtonDisplayed() {
        return isElementDisplayed(createNewAccountButton, "Create New Account Button");
    }

    /**
     * Check if error message is displayed
     */
    public boolean isErrorMessageDisplayed() {
        try {
            return isElementDisplayed(loginErrorMessage, "Error Message");
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get error message text
     */
    public String getErrorMessageText() {
        try {
            return getElementText(loginErrorMessage, "Error Message");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * Verify login page is loaded
     */
    public boolean isLoginPageLoaded() {
        waitForPageLoad();
        return isEmailFieldDisplayed() && isPasswordFieldDisplayed() && isLoginButtonDisplayed();
    }

    /**
     * Get page title
     */
    public String getLoginPageTitle() {
        return getPageTitle();
    }
}
