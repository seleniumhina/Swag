package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.Testbase;

public class checkoutdetailspage extends Testbase{

	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement pincode;
	
	@FindBy(id="continue")
	WebElement continuebtn;
	
	
	
	public checkoutdetailspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public finaldetails verifycheckoutdetails()
	{
		firstname.sendKeys("Rina");
		lastname.sendKeys("Peter");
		pincode.sendKeys("233445");
		continuebtn.click();
		return new finaldetails();
		
	}
	
	
}
