package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import reusableMethods.CommonMethods;

public class PaymentPage extends CommonMethods{
WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Place order')]")
	WebElement PlaceOrderbutton;
	
	@FindBy(className="razorpay-checkout-frame")
	WebElement Paymentpopup;
	
	@FindBy(css="button[method='upi']")
	WebElement UPIOption;
	
	By radioButton = By.name("paymentMethod");
	
	public void paymentMethodSelection() throws InterruptedException 
	{
		    //waitForElementToAppear(radioButton);
		    Thread.sleep(3000);
		    driver.findElement(radioButton).click();
			Thread.sleep(3000);
			PlaceOrderbutton.click();
			Thread.sleep(4000);
			driver.switchTo().frame(Paymentpopup);
			waitForWebElementToAppear(UPIOption);
			UPIOption.click();
			driver.quit();
			
	}


}
