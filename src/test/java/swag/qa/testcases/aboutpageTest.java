package swag.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.qa.base.Testbase;
import swag.qa.pages.Homepage;
import swag.qa.pages.LoginPage;

public class aboutpageTest extends Testbase {
	
	LoginPage loginpage;
    Homepage homepage;
    swag.qa.pages.aboutpage aboutpage;
    
	
	public aboutpageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage= new LoginPage();
		 homepage = loginpage.verifylogin();
	}
	
	@Test
	
	public void abouteTest()
	{
		homepage.verifyabout();
		aboutpage.verifyfree();
		
	}

}
