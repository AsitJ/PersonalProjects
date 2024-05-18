package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import testComponents.BrowserSettings;

import org.openqa.selenium.interactions.*;


public class E2EPaymentPage extends BrowserSettings {
	
	String productName = "PUMA Evoke Layup Men's Sneakers";
	String email = "pumatest130@gmail.com";
	String password = "Seleniumautomation42@";
	String firstName = "puma";
	String lastName = "test";
	String address1 = "Patparganj";
	String postalCode = "110016";
	String city = "Delhi";
	String phoneNo = "9675484324";
	//ShippingPage sp = new ShippingPage(driver);
	//PaymentPage p = new PaymentPage(driver);
	
	@Test

	public void submitOrder() throws InterruptedException, IOException {
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ProductListing pl = lp.login(email, password);
		List<WebElement> products = pl.getProductsList();
		pl.addingProductToCart(productName);
		CartPage cp = pl.cartButton();
		ShippingPage sp = cp.checkout();
		sp.enteringInfo(email, firstName, postalCode, address1, city, lastName, phoneNo);
		PaymentPage p = sp.submitOrder(driver);
		p.paymentMethodSelection();
		
	}
	
	//To verify if ADIDAS ORIGINAL product is displaying in orders page
	/*@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistory() throws InterruptedException 
	{
		ProductListing pc = lp.login("asit@gmail.com", "Learningselenium90@");
		Thread.sleep(3000);
		OrdersPage op = pc.clickOnOrders();
		Assert.assertFalse(op.verifyProductDisplayOrdersPage(productName));
	}*/
	
	

}
