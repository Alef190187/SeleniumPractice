package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMPROTest {
	public static WebDriver driver; 
	public static void main(String[] args) throws InterruptedException {
	
		

			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");

			driver =new ChromeDriver();
			driver.manage().window();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			driver.get("https://www.CRMPRO.com");
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Shibendra");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("snroy0115");
			Thread.sleep(4000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();

			String St = driver.getTitle();
			if (St.equals("CRMPRO")) {
				System.out.println("correct page title");	 	 
	     
			} else {
			
			System.out.println("incorrect page tilte");
			} 
			
			driver.quit();
		

	}

}
