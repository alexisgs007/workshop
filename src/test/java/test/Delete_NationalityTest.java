package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pages.OrangeHRMHomePage;
import pages.OrangeHRMLoginPage;
import utility.constant;

public class Delete_NationalityTest {

	private static WebDriver driver = null;

	@BeforeTest
	public void setUp() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public static void delete_nationality(){
		
		Logger LOGGER = Logger.getLogger(Delete_NationalityTest.class);
		
		//Logging in 
		driver.get(constant.URL);
		driver.manage().window().maximize();
		OrangeHRMLoginPage.textbox_username(driver).sendKeys(constant.Username);
		OrangeHRMLoginPage.textbox_password(driver).sendKeys(constant.Password);
		OrangeHRMLoginPage.button_login(driver).click();
		System.out.println("already logged in");

		//Moving to the Nationality sub-menu
		OrangeHRMHomePage.menu_admin(driver).click();
		OrangeHRMHomePage.submenu_nationality(driver).click();
		
		//Waiting for the table to appear
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
		
		try {

			//Search for the record and delete 
			String actualNationality = driver.findElement(By.xpath("//table[@id='resultTable']/tbody//a[text()='Wakandan']")).getText();
			LOGGER.info("TEXT FROM TABLE" +actualNationality);
			
			//Clicking the checkbox and selecting "Wakandan"
			driver.findElement(By.xpath("//table[@id='resultTable']/tbody//a[text()='Wakandan']/../../td//input")).click();
			LOGGER.info("CLICKING THE CHECKBOX");
			
			//clicking the delete button and confirming deletion
			OrangeHRMHomePage.button_delete(driver).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deleteConfModal")));
			OrangeHRMHomePage.button_confirm(driver).click();
			
		}catch(Exception e) {
			
			LOGGER.info("PROBLEM FINDING ELEMENT IN DOM");
			
		}
	}
	
	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
