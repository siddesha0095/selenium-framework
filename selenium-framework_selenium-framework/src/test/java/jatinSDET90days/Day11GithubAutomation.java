package jatinSDET90days;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day11GithubAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver wd=new ChromeDriver(options);
		wd.get("https://github.com/signup");
		
	//	wd.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(wd, Duration.ofSeconds(10));
		//wd.findElement(By.id("email")).sendKeys("sample");
		
		By emailBoxLocator=By.id("email");
		WebElement emailtextbox=wait.until(ExpectedConditions.visibilityOfElementLocated(emailBoxLocator));
		emailtextbox.sendKeys("siddesha0094@gmail.com");
		
		
		By passwordBoxLocator=By.id("password");
		WebElement passwordtextbox=wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBoxLocator));
		passwordtextbox.sendKeys("test@123Automation");
		
		
		By usernameBoxLocator=By.id("login");
		WebElement usernametextbox=wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBoxLocator));
		usernametextbox.sendKeys("siddesha123ss");
		
		
		By DropDownBoxLocator=By.xpath("//button[contains(@id,'select-panel') and @type='button']");
		WebElement DropDownbox=wait.until(ExpectedConditions.visibilityOfElementLocated(DropDownBoxLocator));
		DropDownbox.click();
		
		
		By DropDownBoxLocatorSearch=By.xpath("//input[contains(@id,'select-panel') and @type='search']");
		WebElement DropDownboxSearch=wait.until(ExpectedConditions.visibilityOfElementLocated(DropDownBoxLocatorSearch));
		DropDownboxSearch.sendKeys("Albania");	
		
		

		By DropDownBoxLocatorSelection=By.xpath("//span[contains(text(),'Albania')]/..");
		WebElement DropDownboxSealect=wait.until(ExpectedConditions.visibilityOfElementLocated(DropDownBoxLocatorSelection));
		DropDownboxSealect.click();
		
		
		
		By userConsentLocator=By.id("user_signup[marketing_consent]");
		WebElement userConsenttextbox=wait.until(ExpectedConditions.visibilityOfElementLocated(userConsentLocator));
		userConsenttextbox.click();
		
		
		
		
	//	wd.close();
		wd.quit();

	}

}
