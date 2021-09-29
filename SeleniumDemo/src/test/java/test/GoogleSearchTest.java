package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath+"\n");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		//goto google.com 
		driver.get("https://google.com");
		
		//enter text in the textbox
		GoogleSearchPage.texbox_search(driver).sendKeys("ABCD");
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
		driver.close();
		
		System.out.print("Test1 Completed Successfully");
	}

}
