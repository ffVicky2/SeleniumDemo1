package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import config.PropertiesFile;
import demo.Log4jDemo;

public class TestNG_Demo {
	
	WebDriver driver = null;
	public static String browserName=null;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();	
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");		
			driver = new FirefoxDriver();
		}else {
			//TODO It is muss the process kill for closing the iexplorer.exe
			System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");	
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.setCapability("ignoreProtectedModeSettings",true);	
		    options.setCapability("initialBrowserUrl", "https://www.google.com");
		    options.setCapability("disable-popup-blocking", true);
			driver = new InternetExplorerDriver(options);				
		}
		logger.info("Browser started successfully");
		
	}
	
	@Test
	public void googleSearch() {
		//goto google.com 
		if (!browserName.equalsIgnoreCase("internetexplorer")) {
		driver.get("https://google.com");	
		driver.findElement(By.id("L2AGLb")).click();
		}
		//enter text in the textbox		
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnK']")).click();
	}
	
	@AfterTest
	public void tearDownTest() {		
        driver.close();		
		System.out.print("Test1 Completed Successfully");
		PropertiesFile.setProperties();
	}

}
