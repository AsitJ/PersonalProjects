package rough;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RoughImplementation {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\000ZZ8744\\\\Documents\\\\chromedriver2\\\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Users\\000ZZ8744\\Documents\\chrome-win64\\chrome.exe");
		options.addArguments("--disable-notifications");
	    WebDriver driver = new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.get("https://in.puma.com/in/en");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    /*Actions a = new Actions(driver);
	    a.sendKeys(Keys.ESCAPE).build().perform();
	    Browser.keys("Escape");*/
	    driver.findElement(By.xpath("//button[@id='account-button']//div[@class='relative mr-0 ml-0 rtl:ml-0 rtl:mr-0 opacity-100']//*[name()='svg']")).click();
	    driver.findElement(By.xpath("(//div[@class='relative font-bold uppercase px-2 text-base'])[2]")).click();
	    driver.findElement(By.xpath("//div[contains(text(),'Login with Email and Password')]")).click();
	    driver.findElement(By.id("email")).sendKeys("pumatest130@gmail.com");
	    driver.findElement(By.name("password")).sendKeys("Seleniumautomation42@");
	    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]/div[1]/div[1]")).click();
	    //Thread.sleep(4000);
	    //Actions move = new Actions(driver);
		//WebElement moveTo = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
	    //move.moveToElement(moveTo).build().perform();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	    WebElement addNewButton = driver.findElement(By.xpath("//div[contains(text(),'Add new')]"));
	    wait.until(ExpectedConditions.visibilityOf(addNewButton));
	    driver.findElement(By.xpath("//span[@class='text-base block mt-1 pb-1 whitespace-nowrap nav-underline group-hover:nav-underline-selected group-focus:nav-underline-selected'][normalize-space()='Men']")).click();
	    //driver.findElement(By.xpath("(//a[@role='menuitem'][normalize-space()='Sneakers'])[2]")).click();
	    Actions move = new Actions(driver);
	  	WebElement moveTo = driver.findElement(By.xpath("//span[contains(text(),'EXTRA 5% DISCOUNT FOR ALL ONLINE PAYMENTS.')]"));
	  	move.moveToElement(moveTo).build().perform();
	    Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3));
	    WebElement element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w-full flex-none transform-gpu']")));
	    //WebElement element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Filters (0)')]")));
	    List<WebElement> products = driver.findElements(By.id("product-list-items"));
	    WebElement products2 = products.stream().filter(product->product.findElement(By.cssSelector("h3")).getText().contains("PUMA Evoke Layup Men's Sneakers")).findFirst().orElse(null);
	    //WebElement products2 = products.stream().filter(product->product.findElement(By.xpath("//h3[@class='w-full mobile:text-sm mobile:pr-0 font-bold text-base pr-5 line-clamp-2']")).getText().contains("PUMA Evoke Layup Men's Sneakers")).findFirst().orElse(null);
	    products2.findElement(By.cssSelector("li[data-test-id='product-list-item']")).click();
	    JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(942,700)");
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=2000");
	    //WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement selectSize = driver.findElement(By.xpath("(//span[normalize-space()='UK 7'])[1]"));
	    wait.until(ExpectedConditions.elementToBeClickable(selectSize));
	    selectSize.click();
	    driver.findElement(By.cssSelector("button[data-test-id='add-to-cart-button'] div[class='opacity-100']")).click();
	    //WebDriverWait wait3 = new WebDriverWait(driver,Duration.ofSeconds(10));
	    //WebElement checkCart = driver.findElement(By.xpath("//div[contains(text(),'View cart')]"));
	    //WebElement checkCart = driver.findElement(By.xpath("//div[@class='relative font-bold uppercase px-3 text-lg']//div[@class='opacity-100'][normalize-space()='View cart (1) & checkout']"));
	    WebElement checkCart = driver.findElement(By.cssSelector("a[class='group tw-1s8viu2 tw-ozwx86 flex-row after::absolute after::hidden after::pointer-events-none after::-left-1 after::-top-1 after::-right-1 after::-bottom-1 after::border-2 after::border-outline after::rounded-sm focus-visible:after::block tw-10skrdm flex-grow'] div[class='opacity-100']"));
	    wait.until(ExpectedConditions.visibilityOf(checkCart));
	    checkCart.click();
	    //List <WebElement> cartProducts = driver.findElements(By.cssSelector("h3"));
		//Boolean match = cartProducts.stream().anyMatch(cart->cart.getText().equals("PUMA Evoke Layup Men's Sneakers"));
		//Assert.assertTrue(match);
	    //Thread.sleep(3000);
		/*driver.findElement(By.xpath("//div[contains(text(),'Checkout')]")).click();
		driver.findElement(By.id("shipping-address-first-name")).sendKeys("puma");
		driver.findElement(By.id("shipping-address-last-name")).sendKeys("test");
		driver.findElement(By.id("shipping-address-postal-code")).sendKeys("110001");
		driver.findElement(By.id("shipping-address-address1")).sendKeys("Patparganj");
		driver.findElement(By.id("shipping-address-city")).sendKeys("Delhi");
		driver.findElement(By.id("email")).sendKeys("pumatest130@gmail.com");*/
	    driver.findElement(By.xpath("//div[contains(text(),'Checkout')]")).click();
	    move.moveToElement(driver.findElement(By.id("shipping-address-first-name"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys("puma").build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-last-name"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys("test").build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-postal-code"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys("110001").build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-address1"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys("Patparganj").build().perform();
	    move.moveToElement(driver.findElement(By.id("shipping-address-city"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys("Delhi").build().perform();
	    move.moveToElement(driver.findElement(By.id("email"))).click().doubleClick().keyDown(Keys.BACK_SPACE).sendKeys("pumatest130@gmail.com").build().perform();
		driver.findElement(By.id("phone-number")).sendKeys("9823763464");
		driver.findElement(By.xpath("//div[contains(text(),'Continue to payment method')]")).click();
		driver.findElement(By.name("paymentMethod")).click();
		//js.executeScript("window.scrollBy(0,400)");
		WebElement PlaceOrderbutton = driver.findElement(By.xpath("//div[contains(text(),'Place order')]"));
		//WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait2.until(ExpectedConditions.elementToBeClickable(PlaceOrderbutton));
		Thread.sleep(3000);
		PlaceOrderbutton.click();
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.className("razorpay-checkout-frame")));
		WebElement UPIOption = driver.findElement(By.cssSelector("button[method='upi']"));
		wait.until(ExpectedConditions.visibilityOf(UPIOption));
		UPIOption.click();
		driver.quit();
		
	}

}
