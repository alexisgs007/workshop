package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMLoginPage {
	
	private static WebElement element = null; 
	
	//USERNAME TEXTBOX
	public static WebElement textbox_username(WebDriver driver) {
		
		element = driver.findElement(By.id("txtUsername"));
		return element; 
		
	}
	
	//PASSWORD TEXTBOX
	public static WebElement textbox_password(WebDriver driver) {
		
		element = driver.findElement(By.id("txtPassword"));
		return element;
	}
	
	//LOGIN BUTTON
	public static WebElement button_login(WebDriver driver) {
		
		element = driver.findElement(By.id("btnLogin"));
		return element;
		
	}

}
