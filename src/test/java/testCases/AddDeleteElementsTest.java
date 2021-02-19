package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helpers.TestBase;
import pages.AddRemoveElementsPage;

public class AddDeleteElementsTest extends TestBase{
	
	AddRemoveElementsPage addRemove;
		
	@BeforeClass
	public void navigateToAddDelete() {
		
		try {			
			
			initialization("http://the-internet.herokuapp.com/add_remove_elements/");
			addRemove = new AddRemoveElementsPage();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate that 'Delete' buttons on screen match with the number of times
	 * that 'Add Element' button was clicked on. 
	 * 
	 */
	@Test
	public void addButtons() {
		
		try {
			
			addRemove.clickOnAdd(4);
			
			if(addRemove.deleteButtonsMatch()) {
				
				System.out.println("Successful: 'Delete' buttons on screen match with the number of times clicked on 'Add' button");
			}
			else {
				
				System.out.println("Fail: 'Delete' buttons on screen do not match with the number of times clicked on 'Add' button");
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * Test case to validate that 'Delete' buttons on screen are according to the number of times
	 * that 'Delete' buttons were clicked on.
	 * 
	 */
	@Test
	public void deleteButtons() {
		
		try {
			
			addRemove.clickOnDelete(5);
			
			if(addRemove.remainingButtonsMatch()) {
				
				System.out.println("Successful: 'Delete' buttons on screen are according to the number of times clicked on 'Delete' buttons");
			}
			else {
				
				System.out.println("Successful: 'Delete' buttons on screen are according to the number of times clicked on 'Delete' buttons");
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
