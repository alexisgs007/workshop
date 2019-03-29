package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeHRMHomePage {

	private static WebElement element = null; 

	//MENUS
	//ADMIN MENU
	public static WebElement menu_admin(WebDriver driver) {

		element = driver.findElement(By.id("menu_admin_viewAdminModule"));
		return element; 

	}


	//SUBMENUS
	//NATIONALITY SUBMENU 
	public static WebElement submenu_nationality(WebDriver driver) {

		element = driver.findElement(By.id("menu_admin_nationality"));
		return element; 

	}

	//ELEMENTS 
	//ADD BUTTON
	public static WebElement button_add(WebDriver driver) {

		element = driver.findElement(By.id("btnAdd"));
		return element; 

	}

	//DELETE BUTTON
	public static WebElement button_delete(WebDriver driver) {

		element = driver.findElement(By.id("btnDelete"));
		return element; 

	}
	
	//NATIONALITY NAME TEXTBOX
	public static WebElement textbox_nationality_name(WebDriver driver) {

		element = driver.findElement(By.id("nationality_name"));
		return element; 

	}
	
	//NATIONALITY SAVE BUTTON 
	public static WebElement button_save(WebDriver driver) {

		element = driver.findElement(By.id("btnSave"));
		return element; 

	}
	
	//NATIONALITY CANCEL BUTTON
	public static WebElement button_cancel(WebDriver driver) {

		element = driver.findElement(By.id("btnCancel"));
		return element; 

	}
	
	//CONFIRM DELETION
	public static WebElement button_confirm(WebDriver driver) {

		element = driver.findElement(By.id("dialogDeleteBtn"));
		return element; 

	}
	
}
