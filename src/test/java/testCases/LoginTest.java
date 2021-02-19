package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.Helpers;
import helpers.TestBase;
import pages.LoginPage;

public class LoginTest extends TestBase{
	
	LoginPage login;
	Helpers helper;
	
	@BeforeClass
	public void navigateToLogin() {
		
		try {			
			
			initialization("http://the-internet.herokuapp.com/login");			
			login = new LoginPage();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Steps to enter credentials and click on 'Login' button	 * 
	 * 
	 */
	public void enterCredentialsAndClick(String usr, String pwd) {
		
		try {
			
			login.setCredentials(usr, pwd);
			login.clickOnLoginLogout(login.btn_Login);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}		
	}	
	
	
	/**
	 * 
	 * Test case to validate the System behavior when no Username hasn't been entered
	 * 
	 */
	@Test
	public void blankUser() {
		
		try {
			
			enterCredentialsAndClick("", "SuperSecretPassword!");
			
			if(login.msg_ResultMessage.getAttribute("innerHTML").contains("Your username is invalid!")) {				
				
				System.out.println("Successful: Login process not completed - Username cannot be blank");
			}
			else {
				
				System.out.println("Fail: Message displayed is not the expected one");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate the System behavior when entered Username is incorrect 
	 * 
	 */
	@Test
	public void incorrectUser() {
		
		try {
			
			enterCredentialsAndClick("incorrectUser", "SuperSecretPassword!");
			
			if(login.msg_ResultMessage.getAttribute("innerHTML").contains("Your username is invalid!")) {				
				
				System.out.println("Successful: Login process not completed - Incorrect Username");
			}
			else {
				
				System.out.println("Fail: Message displayed is not the expected one");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate the System behavior when Password hasn't been entered 
	 * 
	 */
	@Test
	public void blankPassword() {
		
		try {
			
			enterCredentialsAndClick("tomsmith", "!");
			
			if(login.msg_ResultMessage.getAttribute("innerHTML").contains("Your password is invalid!")) {				
				
				System.out.println("Successful: Login process not completed - Password cannot be blank");
			}
			else {
				
				System.out.println("Fail: Message displayed is not the expected one");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate the System behavior when entered Password is incorrect 
	 * 
	 */
	@Test
	public void incorrectPassword() {
		
		try {
			
			enterCredentialsAndClick("tomsmith", "123@asd");
			
			if(login.msg_ResultMessage.getAttribute("innerHTML").contains("Your password is invalid!")) {	
				
				System.out.println("Successful: Login process not completed - Incorrect enterd Password");				
			}
			else {
				
				System.out.println("Fail: Message displayed is not the expected one");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate the System behavior when entered credentials are correct 
	 * 
	 */
	@Test
	public void correctCredentials() {
		
		try {
			
			enterCredentialsAndClick("tomsmith", "SuperSecretPassword!");
			
			if(login.msg_ResultMessage.getAttribute("innerHTML").contains("You logged into a secure area!")) {				
				
				System.out.println("Successful: Login process successfully completed");
			}
			else {
				
				System.out.println("Fail: Message displayed is not the expected one or 'secure Area' screen not displayed");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate the System behavior when 'Logout' button is clicked on 
	 * 
	 */
	@Test
	public void logout() {
		
		try {
			
			login.clickOnLoginLogout(login.btn_Logout);
			
			if(login.msg_ResultMessage.getAttribute("innerHTML").contains("You logged out of the secure area!")) {				
				
				System.out.println("Successful: Logout process successfully completed");
			}
			else {
				
				System.out.println("Fail: Message displayed is not the expected one or 'Login' screen not displayed");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void tearDown() {
		
		try {			
			
			driver.quit();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
