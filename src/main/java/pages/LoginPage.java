package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Helpers;
import helpers.TestBase;

public class LoginPage extends TestBase{
	
	Helpers helpersPage;
	
	@FindBy (xpath="//input[@id='username']")
	public WebElement txt_Username;
	
	@FindBy (xpath="//input[@id='password']")
	public WebElement txt_Password;
			
	@FindBy (xpath="//button[@type='submit']")
	public WebElement btn_Login;
	
	@FindBy (xpath="//a[@class='button secondary radius']")
	public WebElement btn_Logout;
	
	@FindBy (xpath="//div[@id='flash']")
	public WebElement msg_ResultMessage;	
	
	
	/*
	 * 
	 * Constructor
	 * 
	 */
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		helpersPage = new Helpers();
	}
	
	
	/**
	 * 
	 * Method to set the credentials
	 * 
	 */
	public void setCredentials(String usr, String pwd) {
		
		try {
			
			helpersPage.waitForClickableElement(txt_Username);
			helpersPage.type(txt_Username, usr);
			
			helpersPage.waitForClickableElement(txt_Password);
			helpersPage.type(txt_Password, pwd);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * 
	 * Method to click on 'Login' or 'Logout' button
	 * 
	 */
	public void clickOnLoginLogout(WebElement button) {
		
		try {
			
			helpersPage.waitForClickableElement(button);
			helpersPage.click(button);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
