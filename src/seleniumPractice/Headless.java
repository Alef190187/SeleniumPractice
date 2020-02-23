package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Headless {

	public static void main(String[] args) {
		// i am practicing how to do headless browser
		// in can do it by two ways 
		// 1 htmlunit driver
		// 2 chrome options.
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
//		  ChromeOptions option = new ChromeOptions();
//		  option.addArguments("window-size=1400,800");
//		  option.addArguments("headless");
//		  WebDriver driver = new ChromeDriver(option);
		  WebDriver driver = new HtmlUnitDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		  
		  driver.findElement(By.name("proceed")).click(); //click on go button
		  
		  Alert alert = driver.switchTo().alert();
		  String text = alert.getText();
		  System.out.println(text);
		  alert.accept();
		  //alert.dismiss();
		  driver.close();
		  
		  System.out.println("Program is executed");

	}

}
