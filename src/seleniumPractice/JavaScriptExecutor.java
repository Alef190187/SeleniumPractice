package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExecutor {
	
	//System.out.println ("hello world");
	
	
	public static void main(String [] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\SeleniumDocuments\\\\WebDriver\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDocuments\\WebDriver\\geckodriver\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("document.querySelector('#loginForm > div > input:nth-child(1)').value='Alef190187'" );
		js.executeScript("document.querySelector('#loginForm > div > input:nth-child(2)').value='Au2155941186'");
		
		js.executeScript("document.querySelector('#loginForm > div > div > input').click()" );
		//get title of the page
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		//get url
		String url = js.executeScript("return document.URL").toString();
		System.out.println(url);
		
		
		
		//scroll down
		//js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);
		//Navigate to back.
		js.executeScript("window.history.back()");
		//scroll up to button.
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)" );
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(1000,0)");//scroll up
		//get all text in the page
		String text = js.executeScript("return document.documentElement.innerText").toString();
		System.out.println(text);
		driver.quit();
	}

}
