package swag.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.qa.base.Testbase;
import swag.qa.pages.Homepage;
import swag.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {
	
	LoginPage loginpage;
	Homepage homepage;	

	
	public LoginPageTest()
	{
		
		super();
		
	}

	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage= new LoginPage();
	}
	
	@Test
	public void loginTest()
	{
		
	loginpage.verifylogin();
	}
	
}

	

