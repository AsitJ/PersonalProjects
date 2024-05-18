package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObject.PaymentPage;
import reusableMethods.CommonMethods;

public class ShippingPage extends CommonMethods{
	
	WebDriver driver;
	
	public ShippingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[contains(text(),'Continue to payment method')]")
	WebElement continueButton;
	
	
	public void enteringInfo(String email, String firstName, String postalCode, String address1, String city, String lastName, String phoneNo ) throws InterruptedException 
	{
		
		Actions move = new Actions(driver);
		move.moveToElement(driver.findElement(By.id("shipping-address-first-name"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys(firstName).build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-last-name"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys(lastName).build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-postal-code"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys(postalCode).build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-address1"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys(address1).build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-city"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys(city).build().perform();
	    move.moveToElement(driver.findElement(By.id("email"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys(email).build().perform();
		driver.findElement(By.id("phone-number")).sendKeys(phoneNo);
	}
	
	public PaymentPage submitOrder(WebDriver driver) 
	{
		continueButton.click();
		return new PaymentPage(driver);
	}
}
