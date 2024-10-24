package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.Testbase;

public class aboutpage extends Testbase {
	
	
	@FindBy(xpath="//button[normalize-space()='Test it all. Free']")
	WebElement testallfree;



public  aboutpage()
{
  PageFactory.initElements(driver, this);

}

public void verifyfree()
{
	testallfree.click();	
}


}