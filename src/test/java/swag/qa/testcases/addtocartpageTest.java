package swag.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.qa.base.Testbase;
import swag.qa.pages.Homepage;
import swag.qa.pages.LoginPage;

public class addtocartpageTest extends Testbase {

	
	
	LoginPage loginpage;
    Homepage homepage;
    swag.qa.pages.addtocartpage addtocartpage;
	
	public addtocartpageTest() {
        super();
    }

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage= new LoginPage();
		 homepage = loginpage.verifylogin();
		 addtocartpage = homepage.verifyaddtocart();
	}
       
    @Test
    
    public void checkoutTest()
    {
    
    	addtocartpage.verifycheckout();
    }
	
	
	
}
