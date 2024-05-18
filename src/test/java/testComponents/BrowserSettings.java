package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObject.LoginProcess;
import reusableMethods.CommonMethods;

public class BrowserSettings {
	
public WebDriver driver;
public LoginProcess lp;
CommonMethods cm = new CommonMethods(driver);
	
	public WebDriver initializeDriver() throws IOException 
	{
		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"\\\\\\\\src\\\\\\\\test\\\\\\\\java\\\\\\\\properties\\\\\\\\GlobalData.properties";
		FileInputStream fis = new FileInputStream(path);
		//FileInputStream fis = new FileInputStream("C:\\\\Users\\\\000ZZ8744\\\\eclipse-workspace\\\\PumaBDDFramework\\\\src\\\\test\\\\java\\\\properties\\\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ?	System.getProperty("browser") : prop.getProperty("browser");
				//prop.getProperty("browser");
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\000ZZ8744\\\\Documents\\\\chromedriver2\\\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Users\\000ZZ8744\\Documents\\chrome-win64\\chrome.exe");
			options.addArguments("--disable-notifications");
		    //driver = new ChromeDriver(options);     //since WebDriver driver is defined as global variable here
		    
		    //ChromeOptions options = new ChromeOptions();
		    if(browserName.contains("headless")) {    //is not working since it is not compatible with Jenkins
		    options.addArguments("headless");
		    }
		    driver = new ChromeDriver(options);
		    driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//write code to invoke firefox driver
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "edge.exe(file path)");
			driver = new EdgeDriver();             //since WebDriver driver is defined as global variable here
		}
		driver.manage().window().maximize();
		return driver;
	}	
	
	
	
	@BeforeMethod
	public LoginProcess launchUrl() throws IOException 
	{
		initializeDriver();
		 lp = new LoginProcess(driver);
		lp.urlLoad();
		return lp;
	}
	@AfterMethod
	public void closeApp() 
	{
		driver.close();
	}
	
	public String getScreenshot(String testCaseName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\000ZZ8744\\eclipse-workspace\\PumaBDDFramework\\target\\FailedTestScreenshots " + testCaseName + "png");
		FileUtils.copyFile(source, file);
		return "C:\\Users\\000ZZ8744\\eclipse-workspace\\PumaBDDFramework\\target\\FailedTestScreenshots " + testCaseName + "png";
	}
	
	/* public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException 
	{
        //to convert json file to string format
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);//StandardCharsets is the format in which we want the string file to be encoded
		//to convert json string to HashMap using Jackson Databind dependency
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		//"data" is a list which has two hashmaps each containing one data set with return or object type as string  {{map},{map1}} in this format
		return data;  */
		
	}



