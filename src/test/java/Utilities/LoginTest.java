package Utilities;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends Connection {
	// @BeforeTest
	public void Startup() throws IOException {
		// Initiate driver
		Connection obj = new Connection();
		driver = obj.intializeDriver();
		Reporter.log("Chrome Setup is done");
	}

	// @Test
	public void HomePage() {
		driver.get("https://vision2test.danlawinc.com/#/account/login");
		Reporter.log("Vision Test Page is accessed");
		driver.manage().window().maximize();
		Reporter.log("Window is maximized");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals("VISION", driver.getTitle());
		Reporter.log(driver.getTitle() + " is Opened");
	}

	// @Test
	public void Login() {
		WebElement userID = driver.findElement(By.name("userID"));
		userID.clear();
		userID.sendKeys("shivanip");
		Reporter.log("Send UserId of shivanip");
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("Sodium@11");
		Reporter.log("Send Password of Sodium@11");
		WebElement Login = driver.findElement(By.xpath("//*[@id=\'loginForm\']/form/div[3]/button"));
		Login.click();
		Reporter.log("Login Clicked");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String currentURL = driver.getCurrentUrl();
		assertTrue(currentURL.endsWith("#/home/dashboard"));
		Reporter.log("Successful Login.VISION HomePage entered");
	}

	public WebDriver Dashboard() {
		driver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();
		return driver;

	}
	// @Test
	public WebDriver Admin() {
		WebElement admin = driver.findElement(By.xpath("/html/body/my-app/div/header/nav/div/div[2]/ul/li[2]"));
		admin.click();
		Reporter.log("Vision Admin Page is accessed");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String currentURL = driver.getCurrentUrl();
		assertTrue(currentURL.contains("#/admin"));
		return driver;
	}
	public WebDriver Reports()  {
		driver.findElement(By.xpath("//span[contains(text(),'Reports')]")).click(); 
		Reporter.log("Vision Reports Page is accessed");
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
        String currentURL=driver.getCurrentUrl();
        assertTrue(currentURL.contains("#/reports/summaryReport"));
		return driver;
	}
}
