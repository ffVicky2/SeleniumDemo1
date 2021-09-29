package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsWithTestNGDemo {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent.html");
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath+"\n");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("MyFistTest", "Sample description od Test2");  
		driver.get("https://google.com");
		test.pass("Navigate to google.com");
		driver.findElement(By.id("L2AGLb")).click();
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnK']")).click();
		//test.fail("Entered text in search textbox");
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    //test.fail("Test 1 is failed");
	    test.addScreenCaptureFromPath("screenshot.png");		
     }
	
	@Test
	public void test2() throws IOException {
	    ExtentTest test = extent.createTest("MySecondTest", "Sample description od Test2");  
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("Test 2 is passed");
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.print("Test Completed Successfull");
	}
	
	@AfterSuite
	public void tearDown() {
		// calling flush writes everything to the log file
        extent.flush();
	}

}
