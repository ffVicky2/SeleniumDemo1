import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {
	
	private static WebDriver driver=null;
		
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath+"\n");
		
		//DesiredCapabilities options = new DesiredCapabilities();
		//options.setCapability("ignoreProtectedModeSettings", true);
		//options.setCapability("initialBrowserUrl", "https://www.google.com");
		
		/*
		System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		InternetExplorerOptions options = new InternetExplorerOptions().setPageLoadStrategy(PageLoadStrategy.NONE);
		options.setCapability("ignoreProtectedModeSettings", true);
		options.setCapability("initialBrowserUrl", "https://www.google.com");
		driver = new InternetExplorerDriver(options);*/
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");		
		//driver = new FirefoxDriver();
		//goto google.com 
		driver.get("https://google.com");
		driver.findElement(By.id("L2AGLb")).click();
		//System.out.print("Calling google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		//System.out.print("Enter text in textbox");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnK']")).click();
		System.out.print("Completed Successfull test with navigator closed");
		driver.close();
		//driver.quit();
		System.out.print("Completed Successfull test");
		
	}

}
