import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		String parentID=driver.getWindowHandle();
		System.out.println(parentID);
		//driver.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		 
		while(it.hasNext()) {
			String windowId=it.next();
		     driver.switchTo().window(windowId);
		     System.out.println(driver.getTitle());
		     if(!windowId.equals(parentID))
		     {driver.close();}
		}
		
		driver.switchTo().window(parentID);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	
		

	}

}
