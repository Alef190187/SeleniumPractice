package seleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		
		   FileInputStream file = new FileInputStream ("C:\\Users\\alef1\\eclipse-workspace\\SeleniumPractice\\UseName.xlsx");
		
		   XSSFWorkbook wb = new XSSFWorkbook(file);
		   XSSFSheet sheet =   wb.getSheetAt(0);
		  String username =  sheet.getRow(1).getCell(0).getStringCellValue();
		  System.out.println("username is::" +username);
		  
		   int rownum = sheet.getLastRowNum();
		   System.out.println(rownum);
		   
		   for(int row=1; row<=rownum;row++) {
			   System.out.println("========");
			   String uname=sheet.getRow(row).getCell(0).getStringCellValue();
			   System.out.println(uname);
			   String pass=sheet.getRow(row).getCell(1).getStringCellValue();
			   System.out.println(pass);
			   String email=sheet.getRow(row).getCell(2).getStringCellValue();
			   System.out.println(email);
		   }
		   
//		   sheet.getRow(0).createCell(3).setCellValue("result");
//		   sheet.getRow(1).createCell(3).setCellValue("Pass");
//		   FileOutputStream fos = new FileOutputStream("C:\\Users\\alef1\\eclipse-workspace\\SeleniumPractice\\UseName.xlsx");
//		   wb.write(fos);
//		   wb.close();
		   Properties prop = new Properties();
		   FileInputStream fis = new FileInputStream("C:\\Users\\alef1\\eclipse-workspace\\SeleniumPractice\\src\\Confiq.Properties");
		  prop.load(fis);
		  String data = prop.getProperty("browser");
		  System.out.println(data);
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDocuments\\WebDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		  
		  WebDriver driver = new ChromeDriver();
		  driver.get(prop.getProperty("url"));
		  
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File srcfile = ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcfile,new File("./output/screenshot/fb.png"));
		 
		 WebElement name = driver.findElement(By.id("u_0_f"));
		File srcfil =  name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfil, new File ( "./Output/screenshot/name.png"));
		 
		 driver.quit();

		  
		   

	}
	public static void elementScreenshoot(WebElement element, String filename) {
		 File srcfil = element.getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(srcfil, new File("./output/screenshot/"+filename+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
