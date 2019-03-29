package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.OrangeHRMHomePage;
import pages.OrangeHRMLoginPage;
import utility.constant;

public class Add_Nationality {

	private static WebDriver driver = null;
	private static String nationality = "Wakandan";

	@BeforeTest
	public void setUp() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public static void add_nationality() {
		
		Logger LOGGER = Logger.getLogger(Add_Nationality.class);

		//Logging in 
		driver.get(constant.URL);
		OrangeHRMLoginPage.textbox_username(driver).sendKeys(constant.Username);
		OrangeHRMLoginPage.textbox_password(driver).sendKeys(constant.Password);
		OrangeHRMLoginPage.button_login(driver).click();
		System.out.println("already logged in");

		//Moving to the Nationality sub-menu
		OrangeHRMHomePage.menu_admin(driver).click();
		OrangeHRMHomePage.submenu_nationality(driver).click();
		OrangeHRMHomePage.button_add(driver).click();
		OrangeHRMHomePage.textbox_nationality_name(driver).sendKeys(nationality);

		//Verify if nationality already exists
		LOGGER.error("Before wait condition");
		
		WebElement alreadyExists = null;
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			alreadyExists = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='frmNationality']/fieldset/ol/li[1]/span")));
			LOGGER.error("ALREADY EXISTS: " +alreadyExists.getText());
			
		}
		catch(Exception e) {
			LOGGER.error("ELEMENT NOT FOUND");
		}
		
		
		if(alreadyExists!=null) {
			
			Assert.assertTrue(true, "ALREADY EXISTS");
			LOGGER.error("NOT SAVED");

		}
		else {
			
			LOGGER.error("ELSE STATEMENT");
			OrangeHRMHomePage.button_save(driver).click();
			
		}
	

		System.out.println("AFTER CLICKING ON SAVE IN THE ELSE CONDITION");

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
