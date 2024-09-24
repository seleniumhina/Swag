package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.Testbase;

public class addtocartpage extends Testbase {
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkout;
	
	
	
	public addtocartpage()
	{
		
		PageFactory.initElements(driver,this);
		
	}


public checkoutdetailspage verifycheckout ()

{
	checkout.click();
	return new checkoutdetailspage();
	

}


}
