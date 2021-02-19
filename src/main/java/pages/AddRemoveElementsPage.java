package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helpers.Helpers;
import helpers.TestBase;

public class AddRemoveElementsPage extends TestBase{
	
	Helpers helpersPage;
	
	@FindBy (xpath="//button[@onclick='addElement()']")
	public WebElement btn_AddElement;
	
	@FindBy (xpath="//button[@class='added-manually']")
	public WebElement btn_Delete;
	
	int timesClickedAdd;
	int timesClickedDelete;
	List <WebElement> buttonsAdded;
	List <WebElement> buttonsRemaining;
	
	/*
	 * 
	 * Constructor
	 * 
	 */
	public AddRemoveElementsPage() {
		
		PageFactory.initElements(driver, this);
		helpersPage = new Helpers();
	}
	
	
	public void clickOnAdd(int timesToClickOn) {
		
		try {
			
			if(timesToClickOn <= 0) {
				
				timesToClickOn = 1;
			}
			
			for (int times = 1; times <= timesToClickOn; times++) {
				
				helpersPage.click(btn_AddElement);
			}
			
			timesClickedAdd = timesToClickOn;
			
			System.out.println("'Add Element' button clicked on "+timesToClickOn+" times");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public boolean deleteButtonsMatch() {
		
		boolean buttonsMatch = false;
		
		try {
			
			buttonsAdded = driver.findElements(By.xpath("//button[@class='added-manually']"));
			
			if(buttonsAdded.size() == timesClickedAdd) {
				
				buttonsMatch = true;
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return buttonsMatch;
	}
	
	
	public void clickOnDelete(int timesToClickOn) {
		
		try {
			
			if(timesToClickOn > buttonsAdded.size()) {
				
				timesToClickOn = buttonsAdded.size();
			}
			
			for (int times = 1; times <= timesToClickOn; times++) {
				
				helpersPage.click(btn_Delete);
			}
			
			timesClickedDelete = timesToClickOn;
			
			System.out.println("'Delete Element' button clicked on "+timesToClickOn+" times");
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public boolean remainingButtonsMatch() {
		
		boolean remainingMatch = false;
		
		try {
			
			buttonsRemaining = driver.findElements(By.xpath("//button[@class='added-manually']"));
			
			if(buttonsRemaining.size() == (buttonsAdded.size() - timesClickedDelete)) {
				
				remainingMatch = true;
			}
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return remainingMatch;
	}

}
