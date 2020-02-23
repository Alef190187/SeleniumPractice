package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (2)\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
       driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
       driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
       List<WebElement>links = driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby= 'dropdownMenuButton']//a"));
        
       System.out.println("The link size is:: "+links.size());
       
       for(int i=0; i<links.size(); i++) {
    	  System.out.println(links.get(i).getText());
    	  
    	  if(links.get(i).getText().contains("Another action")) {
    		  links.get(i).click();
    		  //break;
    	  }
    	  
       }
       driver.close();
       
       }

}
