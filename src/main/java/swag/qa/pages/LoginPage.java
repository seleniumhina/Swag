package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	
	
	public LoginPage()
	{
		
		PageFactory.initElements(driver,this);
		
	}


public Homepage verifylogin()
{
	username.sendKeys("standard_user");
	password.sendKeys("secret_sauce");
	loginbtn.click();
	return new Homepage();

}


}
