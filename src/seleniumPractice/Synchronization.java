package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com");
		
		WebElement nsername = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		//webdriverwait is also called explicit wait.
		//it is used for a certain element on certain condition and time.
		//explicit wait is globaly declaired.
		//implicit and explicit wait are not used at the same time in the script.
		
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(nsername));
	   
	    nsername.sendKeys("Alef190187");
	    
	    
		
	    Synchronization sync = new Synchronization();
	    sync.sendKeys(driver, password, 10,"Au2155941186");
		
	    WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
		
	    sync.clickOn(driver, button, 10);
	    
	    
	    driver.close();
		

	}
	
	
	public void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
	    new WebDriverWait(driver,timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
		
	}
	public void clickOn(WebDriver driver, WebElement element, int timeout) {
	    new WebDriverWait(driver,timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}


}
