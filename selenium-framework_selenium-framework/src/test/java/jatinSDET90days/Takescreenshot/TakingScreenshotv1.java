package jatinSDET90days.Takescreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenshotv1 {

    public static void main(String[] args) throws IOException {

        // Launch Chrome browser
        WebDriver wd = new ChromeDriver();

        // Open Google website
        wd.get("https://www.google.com");

        // Typecasting WebDriver to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) wd;

        // Capture screenshot and store in temporary file
        File myFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Define destination file
        File outputFile = new File("screenshot.png");

        // Copy file to project folder
        FileUtils.copyFile(myFile, outputFile);

        // Close browser
        wd.quit();
    }
}