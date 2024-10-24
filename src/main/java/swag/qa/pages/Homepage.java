package swag.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.qa.base.Testbase;

public class Homepage extends Testbase {
	
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addtocart;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement addtocart2;
	
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement Sort;
	
	@FindBy(xpath="//span[@class='active_option']")
	WebElement Sortvalue;
	
	@FindBy(xpath="(//button[normalize-space()='Open Menu'])[1]")
	WebElement threeline;
	
	@FindBy(xpath="(//a[normalize-space()='About'])[1]")
	WebElement about;
	
	
	
	
	public Homepage()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void verifysort()
	{
		Sort.click();
		Sortvalue.click();
		
	}
	
	
	public addtocartpage verifyaddtocart()
	{
		addtocart.click();
		addtocart2.click();
		addtocartbtn.click();
		return new addtocartpage();
	}
	
	public aboutpage verifyabout()
	{
		threeline.click();
		about.click();
		return new aboutpage();
		
	}

}
