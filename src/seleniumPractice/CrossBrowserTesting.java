package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	public WebDriver driver;
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName) {
		System.out.println("Browser name is::"+ browserName);
		System.out.println("Thread id is::"+ Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "C:\\SeleniumDocuments\\WebDriver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		}else if(browserName.equalsIgnoreCase("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDocuments\\WebDriver\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
			
		}
		
	driver.manage().window();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.google.com");
	}
	
	
	
	@Test
   public void launchIETest() {
		String title = driver.getTitle();
		System.out.println(" The title is "+title);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("The program is completed");
	}

}
