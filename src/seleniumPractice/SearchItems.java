package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchItems {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.webstaurantstore.com/");
		driver.findElement(By.xpath("//input[@id='searchval']")).sendKeys("stainless work table");
		driver.findElement(By.xpath("//input[@id='searchval']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> list =driver.findElements(By.tagName("Table"));
		//List<WebElement> list = driver.findElements(By.name("Table"));
		//List<WebElement> list = driver.findElements(By.tagName(""));
		//List<WebElement> list = driver.findElements(By.name("stainless work table"));
		//List<WebElement> list = driver.findElements(By.linkText("table"));		

		System.out.println(list.size());
		int length= list.size();
		int size = list.size()-1;
		//String table= list.get(list.size()-1).getText();
		String table=list.get(size).getText();
		System.out.println("last item :::" + table);
		System.out.println("======================");
			
		
		for(int i=0; i<list.size(); i++) {
			String tableNames= list.get(i).getText();
			System.out.println(tableNames);
		
	}
		if(table.contains("1 - 4\r\n" + 
				"5+\r\n" + 
				"$296.99 $267.86")) {
			driver.findElement(By.xpath("//*[@id=\"product_60_9F4E6275-0CF6-2897-5F76F09D98DB97F8\"]/div[1]/div/input[2]"));
		}
	}

}
