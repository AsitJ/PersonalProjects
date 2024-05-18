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
import org.testng.annotations.Test;

import testComponents.BrowserSettings;
import testComponents.Retry;

import org.openqa.selenium.interactions.*;


public class ErrorScenarios extends BrowserSettings {
	
	@Test(retryAnalyzer=Retry.class)

	public void submitOrderToValidateError() throws InterruptedException, IOException {
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 lp.login("asit@gmail.com", "Learningselenium90");
		Assert.assertEquals("Invalid login or password. Remember that login names and passwords are case-sensitive. Please try again.", lp.getError());
		
	}

}
