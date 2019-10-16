package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links_count {

	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://crmpro.com");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("alef190187");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Au2155941186");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector('#loginForm > div > div > input').click()");
		
		List<WebElement>frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		
		for(int i=0; i<frames.size(); i++) {
			String names = frames.get(i).getText();
			System.out.println(names);
		}
		
		
		List<WebElement> link = driver.findElements(By.tagName("a"));
		
		System.out.println(link.size());
		
		for(int j=0; j<link.size(); j++) {
			String linkNames = link.get(j).getText();
			System.out.println(linkNames);
		}
		driver.quit();
		
	}

	
	

}
