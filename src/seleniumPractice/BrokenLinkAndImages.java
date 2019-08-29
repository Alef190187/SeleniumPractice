package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkAndImages {

	public static void main(String[] args) throws InterruptedException, IOException,MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com");
		String title =driver.getTitle();
		System.out.println(title);
//		String pagesrc = driver.getPageSource();
//		System.out.println(pagesrc);
		driver.findElement(By.name("username")).sendKeys("Alef190187");
		driver.findElement(By.name("password")).sendKeys("Au2155941186");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
        //switch to the frame
		driver.switchTo().frame("mainpanel");
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		//list of all links+images
		linkslist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("total links and images ==>" +linkslist.size());
		 List<WebElement>activelinks = new ArrayList<WebElement>();
		 //Filtering out active links with href.
		 for(int i=0; i<linkslist.size(); i++) {
			 //getting all links 
			 System.out.println(linkslist.get(i).getAttribute("href"));
			// System.out.println(linkslist.get(i).getAttribute("src"));
			 
			 
			 if(linkslist.get(i).getAttribute("href") != null && ( !linkslist.get(i).getAttribute("href").contains("javascript")) ) {
				 activelinks.add(linkslist.get(i));
			 }
		 }
		System.out.println("total active links ==>" +activelinks.size());
		
		for(int j=0; j<activelinks.size(); j++) {
			//getting all the actives links
			String links = activelinks.get(j).getAttribute("href");
			URL url = new URL(links);//create a object of url class
			//create a object of httpurlconnection class and cast url with it
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.connect();
			//200=ok
			//404= not found
			//400=bad request.
			String resmsg = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(links+"==>"+ resmsg);
			
			
		}
		
		
		driver.quit();

	}

}
