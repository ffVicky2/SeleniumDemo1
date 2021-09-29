package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {
	
	private WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath+"\n");
		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
		options.setCapability("ignoreProtectedModeSettings", true);
		options.setCapability("initialBrowserUrl", "https://google.com");
		driver = new InternetExplorerDriver(options);
		//driver = new ChromeDriver();
	}
	
	@Test
	public void googleSearch2() {
		//goto google.com 
		driver.get("https://google.com");		
		//enter text in the textbox
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);				
	}
	

	@Test
	public void googleSearch3() {
		//goto google.com 
		driver.get("https://google.com");		
		//enter text in the textbox
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);				
	}
	
	@AfterTest
	public void tearDownTest() {		
        driver.close();
		driver.quit();
		System.out.print("Test1 Completed Successfully");
	}

}
