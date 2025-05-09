
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample {

	@Test
	public void m1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D://Automation_Projects//Jars//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://botapi.intense.in:9447/IncPortal/welcome");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//b[contains(text(),'Login')]"));
		element.click();
		Thread.sleep(1500);
		element.click();
		Thread.sleep(1500);
		element.click();
		
				  
		String pwindow = driver.getWindowHandle();
		
		  Set<String> windowHandles = driver.getWindowHandles(); 
		  
			
			/* List<String> windows=new ArrayList<String>(windowHandles);
			  driver.switchTo().window(windows.get(2));
			 System.out.println(windowHandles + " list " +windows+" ::: " + windowHandles.size()); */
		  
		  for (int i = 0; i < windowHandles.size(); i++) {
			 // windowHandles.
			
		}
		  
		  
		 
		WebElement regi = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", regi);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Venkatesh");
	}

}
