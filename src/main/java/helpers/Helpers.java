package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	
	
	/**
	 * 
	 * Method to wait until an element becomes clickable
	 * 
	 */
	public void waitForClickableElement(WebElement element) {
		
		try {
			
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 
	 * Method to wait until an element is on Screen
	 * 
	 */
	public void waitForElementOnScreen(WebElement element) {
		
		try {
			
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 
	 * Method to type a value
	 * 
	 */
	public void type(WebElement element, String value) {
		
		try {
			
			element.sendKeys(value);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Method to click on over an element
	 * 
	 */
	public void click(WebElement element) {
		
		try {
			
			element.click();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
