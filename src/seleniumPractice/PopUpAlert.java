package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PopUpAlert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		  ChromeOptions option = new ChromeOptions();
		  option.addArguments("window-size=1400,800");
		  option.addArguments("headless");
	      WebDriver driver = new ChromeDriver(option);
		//WebDriver driver = new HtmlUnitDriver();
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
		  driver.close();
		  
		  System.out.println("Program is executed");
		  
		  
//		  
//		  String text = alert.getText();
//		  System.out.println(text);
		  
//		  if(text.equals("Please enter a valid user name")){
//		  System.out.println("correct alert masssge");
//		     } else {
//		  System.out.println("In correct alert massage"); 
//		  Thread.sleep(5000);
//		  alert.accept(); //click on ok button
//		  //alert.dismiss();  //click on cancel button
//		  driver.close();
//
//	}

}
}
