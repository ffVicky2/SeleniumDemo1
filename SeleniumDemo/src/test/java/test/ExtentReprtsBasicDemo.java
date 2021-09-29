package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReprtsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		//create ExtentReports and attach reporter (s)
		ExtentReports extend = new ExtentReports();		
		extend.attachReporter(htmlReporter);
		
		//create a toggle for the given test, add all log events under it
		ExtentTest test1 = extend.createTest("Google Search Test One", "This is a test to validate google search functionality");
		
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath+"\n");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com");
		test1.pass("Navigate to www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("ABCD");
		test1.fail("Entered text in search textbox");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.fail("Pressed Keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Completed Test Case");
		
		//calling flush writes everything to the log file
		extend.flush();
		
	}

}
