package reusableMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.CartPage;



public class CommonMethods {
	
	WebDriver driver;
	
	

	public CommonMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	

	@FindBy(css="a[class='group tw-1s8viu2 tw-ozwx86 flex-row after::absolute after::hidden after::pointer-events-none after::-left-1 after::-top-1 after::-right-1 after::-bottom-1 after::border-2 after::border-outline after::rounded-sm focus-visible:after::block tw-10skrdm flex-grow'] div[class='opacity-100']")
	WebElement checkCart;
	

	
	@FindBy(css="[routerlink*='/dashboard/myorders']")
	WebElement clickOrdersButton;
    
	public void waitForElementToAppear(By bottomLeftText)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bottomLeftText)));
	}
	public void waitForWebElementToAppear(WebElement bottomLeftText)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(bottomLeftText));
	}
    
    public void waitForElementToDisappear(WebElement productToBeSelected)
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    	wait.until(ExpectedConditions.invisibilityOf(productToBeSelected));
    }
    
    public void Wait(WebDriver driver)
    {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    	
    }
    
    public CartPage cartButton()
    {
    	waitForWebElementToAppear(checkCart);
	    checkCart.click();
    	CartPage cp = new CartPage(driver);
    	return cp;
    }
    
    
    
    
}
