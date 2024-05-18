package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObject.ProductListing;
import reusableMethods.CommonMethods;

public class LoginProcess extends CommonMethods{
	 WebDriver driver;
	 
	
	public LoginProcess (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		//WebElement userName = driver.findElement(By.id("userEmail"));

	@FindBy(id="email")
	WebElement emailTextField;
	
	@FindBy(name="password")
	WebElement passwordTextField;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]/div[1]/div[1]")
	WebElement loginButton2;
	
	@FindBy(xpath="(//p[@class='undefined tw-ou8532 tw-1n7poqb tw-iti11x tw-133bblj'])[1]")
	WebElement errorMessage;
	
	@FindBy(xpath="//button[@id='account-button']//div[@class='relative mr-0 ml-0 rtl:ml-0 rtl:mr-0 opacity-100']//*[name()='svg']")
	WebElement profileButton;
	
	
	@FindBy(xpath="(//div[@class='relative font-bold uppercase px-2 text-base'])[2]")
	WebElement loginButton;
	

	
	@FindBy(xpath="//div[contains(text(),'Login with Email and Password')]")
	WebElement loginLink;
	
	
	public ProductListing login(String email, String password)
	{
		//Wait(driver);
		profileButton.click();
		loginButton.click();
		loginLink.click();
		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton2.click();
		ProductListing pl = new ProductListing(driver);
		return pl;
	}
	
	public void urlLoad()
	{
		
		driver.get("https://in.puma.com/in/en");
		//Wait(driver);
		
	}
	
	public String getError() 
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	

}
