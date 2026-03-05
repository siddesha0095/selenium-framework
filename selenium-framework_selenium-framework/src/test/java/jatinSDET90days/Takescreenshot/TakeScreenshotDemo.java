package jatinSDET90days.Takescreenshot;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jatinSDET90days.Takescreenshot.ScreenshotUtil;

public class TakeScreenshotDemo {

    public static void main(String[] args) {

        // Set ChromeDriver path if required
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Maximize window
            driver.manage().window().maximize();

            // Wait 2 seconds (just for demo visibility)
            Thread.sleep(2000);

            // Call utility method
            ScreenshotUtil.captureScreenshot(driver, "GoogleHomePage");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}