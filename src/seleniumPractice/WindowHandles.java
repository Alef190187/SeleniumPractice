package seleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/goodpopups.html");
		driver.findElement(By.xpath("//a[@class='black']")).click();
		 
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parentWinId = it.next();
		System.out.println("the parent window id is ::"+ parentWinId);
		String title = driver.getTitle();
		System.out.println("the parent window title is ::" + title);
		
		String childWinId = it.next();
		System.out.println("the parent window id is ::"+ childWinId);
		driver.switchTo().window(childWinId);
		String title1 = driver.getTitle();
		System.out.println("the child  window title is ::" + title1);
		driver.close();
		
		driver.switchTo().window(parentWinId);
		//driver.switchTo().defaultContent();
		String title2 = driver.getTitle();
		System.out.println("the parent window title after switching is ::" + title2);
		driver.findElement(By.xpath("//a[@class='black']")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
		

	}

}
