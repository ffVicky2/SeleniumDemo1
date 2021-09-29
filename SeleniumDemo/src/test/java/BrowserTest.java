import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {
	
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.print(projectPath);
		//System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");		
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		//System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		driver.get("https://google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("ABCD");
		//WebElement textbox = driver.findElement(By.id("lst-ib"));
		//textbox.sendKeys("Automation Step By Step");
		driver.close();
	}

}
