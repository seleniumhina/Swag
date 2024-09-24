package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.Testbase;

public class finaldetails extends Testbase {
	
	
	@FindBy(id="finish")
	WebElement finishbtn;
	
	@FindBy(id="cancel")
	WebElement cancelbtn;
	
	
	
	public finaldetails()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void verifyfinish()
	{
		
		finishbtn.click();		
	}
	
	public void verifycancel()
	{
		
		cancelbtn.click();
		
	}

}
