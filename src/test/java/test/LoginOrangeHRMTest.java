package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.OrangeHRMLoginPage;
import utility.constant;

public class LoginOrangeHRMTest {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
				
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public static void login() {
	
		driver.get(constant.URL);
		OrangeHRMLoginPage.textbox_username(driver).sendKeys(constant.Username);
		OrangeHRMLoginPage.textbox_password(driver).sendKeys(constant.Password);
		OrangeHRMLoginPage.button_login(driver).click();
		System.out.println("already logged in");
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}

}
