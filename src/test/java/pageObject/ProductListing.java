package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusableMethods.CommonMethods;

public class ProductListing extends CommonMethods {
	 WebDriver driver;
	 WebElement products2;
	
	
	public ProductListing (WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		//WebElement userName = driver.findElement(By.id("userEmail"));

	@FindBy(id="product-list-items")
	List <WebElement> products;
	
	//By productsList = By.cssSelector(".mb-3");
	//By productsList = By.id("product-list-items");
	By productsList = By.xpath("//div[@class='w-full flex-none transform-gpu']");
	By clickOnProduct = By.cssSelector("li[data-test-id='product-list-item']");
	By addToCart = By.cssSelector("button[data-test-id='add-to-cart-button'] div[class='opacity-100']");
    //By bottomLeftText = By.cssSelector("#toast-container");
	
	
	@FindBy(xpath="//div[contains(text(),'Add new')]")
	WebElement addNewButton;
	
	@FindBy(xpath="//span[@class='text-base block mt-1 pb-1 whitespace-nowrap nav-underline group-hover:nav-underline-selected group-focus:nav-underline-selected'][normalize-space()='Men']")
	WebElement menSection;
	
	@FindBy(xpath="(//span[normalize-space()='UK 7'])[1]")
	WebElement selectSize;
	
	@FindBy(css="section[class='flex h-11 bg-puma-gold font-display text-white items-center justify-center mobile:text-xs text-sm']")
	WebElement moveTo;
	
	@FindBy(xpath="(//h3[@class='w-full mobile:text-sm mobile:pr-0 font-bold text-base pr-5 line-clamp-2'])[1]")
	WebElement product2;
	
	@FindBy(xpath="//span[normalize-space()='Please select a size']")
	WebElement sizeErrorMessage;
	
	
	
	public List<WebElement> getProductsList()
	{
		waitForWebElementToAppear(addNewButton);
		menSection.click();
	    Actions move = new Actions(driver);
	  	move.moveToElement(moveTo).build().perform();
	    Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3));
	    WebElement element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(productsList));
		return products;
	}
	
	public WebElement productToBeAdded(String productName) throws InterruptedException
	{
		//Thread.sleep(5000);
		 products2 = getProductsList().stream().filter(product->product.findElement(By.cssSelector("h3")).getText().contains(productName)).findFirst().orElse(null);
		return products2;
		
		
	    
		
	}
	
	public void addingProductToCart(String productName) throws InterruptedException
	{
		
		/*products2 = productToBeAdded(productName);
		products2.findElement(clickOnProduct).click();*/
		product2.click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(942,700)");
		waitForWebElementToAppear(selectSize);
		selectSize.click();
	    driver.findElement(addToCart).click();
	    
	}
	public void notSelectingSize() throws InterruptedException 
	{
		product2.click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(942,700)");
		driver.findElement(addToCart).click();
		
	}
	public String getSizeError() 
	{
		waitForWebElementToAppear(sizeErrorMessage);
		return sizeErrorMessage.getText();
	}
	
	
	
	

}
