package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObject.ShippingPage;
import reusableMethods.CommonMethods;

public class CartPage extends CommonMethods{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[contains(text(),'Checkout')]")
	WebElement checkOutButton;

	
	
	public ShippingPage checkout() 
	{
		checkOutButton.click();
		ShippingPage sp = new ShippingPage(driver);
		return sp;
	}
	
}
