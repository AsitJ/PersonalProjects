package stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;


import pageObject.ShippingPage;
import pageObject.PaymentPage;
import pageObject.ProductListing;
import testComponents.BrowserSettings;
import testComponents.Retry;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CartPage;
import pageObject.LoginProcess;

public class StepDefinations extends BrowserSettings{
	
	public ProductListing pl;
	public CartPage cp;
	public PaymentPage p;
	public ShippingPage sp;

	
	@Given("Landed on the PUMA website initial login page")
	public void landed_on_the_puma_website_initial_login_page() throws IOException {
		
		lp = launchUrl();

	}
	
	@Given("^Logged in with email (.+) and password (.+)$")
	public void logged_in(String email, String password) {
	    
		pl = lp.login(email, password);
	}
	@When("^Landing on product listing page and adding a product (.+) to the cart without selecting shoe size$")
	public void landing_on_product_listing_page_and_adding_a_product_smashic_unisex_sneakers_to_the_cart_without_selecting_shoe_size(String productName) throws InterruptedException 
	{
		List<WebElement> products = pl.getProductsList();
		pl.notSelectingSize();
	}
	
	@Then("{string} error message is displayed")
	public void error_message_is_displayed(String string) throws IOException {
		
		Assert.assertEquals(string, pl.getSizeError());
		getScreenshot(string);
		driver.close();
	}
	
	
	
	
	@Then("{string} displays in login page")
	public void displays_in_login_page(String strArg1) throws IOException {
		
		Assert.assertEquals(strArg1, lp.getError());
		getScreenshot(strArg1);
		driver.close();

	}
	
	
	
	@When("^Landing on product listing page and adding a product (.+) to the cart$")
	public void landing_on_product_listing_page_and_adding_a_product_smashic_unisex_sneakers_to_the_cart(String productName) throws InterruptedException {

		List<WebElement> products = pl.getProductsList();
		pl.addingProductToCart(productName);
	}
	
	@When("^Check if the product (.+) is successfully added to the cart and proceeding to Shipping page$")
	public void check_if_the_product_smashic_unisex_sneakers_is_successfully_added_to_the_cart_and_proceeding_to_shipping_page(String productName) {
	    
		cp = pl.cartButton();
		 sp = cp.checkout();
		//p = sp.submitOrder();

	}
	

	@When("Providing details in the Shipping page and proceeding to Payment page")
	public void providing_details_in_the_shipping_page_and_proceeding_to_payment_page() throws InterruptedException {
		
		
		driver.findElement(By.id("shipping-address-first-name")).clear();
		driver.findElement(By.id("shipping-address-first-name")).sendKeys("puma");
		driver.findElement(By.id("shipping-address-last-name")).clear();
		driver.findElement(By.id("shipping-address-last-name")).sendKeys("test");
		driver.findElement(By.id("shipping-address-postal-code")).clear();
		driver.findElement(By.id("shipping-address-postal-code")).sendKeys("110001");
		driver.findElement(By.id("shipping-address-address1")).clear();
		driver.findElement(By.id("shipping-address-address1")).sendKeys("Patparganj");
		driver.findElement(By.id("shipping-address-city")).clear();
		driver.findElement(By.id("shipping-address-city")).sendKeys("Delhi");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("pumatest130@gmail.com");
		driver.findElement(By.id("phone-number")).clear();
		driver.findElement(By.id("phone-number")).sendKeys("+919823763464");
	    p = sp.submitOrder(driver);
	}

	



	
	@Then("Validating that you land successfully on Payment page and select payment option")
	public void validating_that_you_land_successfully_on_payment_page_and_select_payment_option() throws InterruptedException {
	   
		p.paymentMethodSelection();
	}
	
}

	
	