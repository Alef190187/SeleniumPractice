package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws IOException,MalformedURLException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com");
		
		List<WebElement>linksize = driver.findElements(By.tagName("a"));
		System.out.println("The linksize is ==>" +linksize.size());//getting links size
		linksize.addAll(driver.findElements(By.tagName("img")));
		//getting links and image size.
		System.out.println("The linksize is ==>" +linksize.size());
		
		for(int i=0; i<linksize.size(); i++) {
			
		String url = linksize.get(i).getAttribute("href");
		
		  
			URL links = new URL(url);
		
		
		  HttpURLConnection connection = (HttpURLConnection)links.openConnection();
		  connection.connect();
		  int rescode = connection.getResponseCode();
		  if(rescode>=400) {
			  System.out.println(url +"===="+ " is broken links ");
		  }else {
			  System.out.println(url +"===="+ " is valid links "); 
		  }
		 //HttpURLConnection connection =(HttpURLConnection)links.openConnection();
		}
      
		driver.quit();
	}

}
