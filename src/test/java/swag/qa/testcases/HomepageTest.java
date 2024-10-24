package swag.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import swag.qa.base.Testbase;
import swag.qa.pages.Homepage;
import swag.qa.pages.LoginPage;

public class HomepageTest extends Testbase{
	
	
	
	LoginPage loginpage;
    Homepage homepage;
	
	public HomepageTest() {
        super();
    }

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage= new LoginPage();
		 homepage = loginpage.verifylogin();
	}
       
  //  @Test
    
    public void cartTest()
    {
    
    	homepage.verifyaddtocart();
    }
	
	@Test
	public void abouttest()
	{
		homepage.verifyabout();
		
		
	}
}
