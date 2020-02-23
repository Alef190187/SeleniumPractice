package seleniumPractice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {
   static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (3)\\chromedriver.exe");
		String downloadPath = "C:/Users/alef1/Desktop/FileDownLoad";
		Map<String, Object> chromeprefs = new HashMap<String, Object>();
		
		chromeprefs.put("profile.default_content_settings.popups", 0);
		chromeprefs.put("download.default_directory", downloadPath);
		
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", chromeprefs);
		driver = new ChromeDriver(option);
		driver.get("https://skpatro.github.io/demo/links/");
		
		driver.findElement(By.xpath("//div[@class='download']//input[@class='btn']")).click();
  	  Thread.sleep(2000);

	}

}
