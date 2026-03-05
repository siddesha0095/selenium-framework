package jatinSDET90days.Takescreenshot;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    /**
     * Captures screenshot and saves it in screenshots folder
     * @param driver WebDriver instance
     * @param screenshotName Name of screenshot
     * @return Full path of saved screenshot
     */
    public static String captureScreenshot(WebDriver driver, String screenshotName) {

        // Generate timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Create screenshots folder path
        String projectPath = System.getProperty("user.dir");
        String folderPath = projectPath + "/screenshots/";

        // Create folder if not exists
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Define full file path
        String fullPath = folderPath + screenshotName + "_" + timestamp + ".png";

        try {
            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Copy file to destination
            FileUtils.copyFile(srcFile, new File(fullPath));

            System.out.println("Screenshot saved at: " + fullPath);

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

        return fullPath;
    }
}
