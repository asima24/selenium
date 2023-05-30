import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	 WebElement rightClickbtn=driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
	 Actions act=new Actions(driver);
	 act.contextClick(rightClickbtn).build().perform();
	 Thread.sleep(1000);
	 WebElement childMenu;
//	 copy.click();
//	 
//	 Alert al=driver.switchTo().alert();
//	 al.accept();
//	 
//	driver.switchTo().defaultContent();
//	

   List<WebElement> rightClick=driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root span"));
   
   for(int i=0;i<rightClick.size();i++) {
	 
           String text=rightClick.get(i).getText();
	   System.out.println(text);
	   System.out.println("Xpath --"+"//span[text()='"+text+"']");
   childMenu=driver.findElement(By.xpath("//span[text()='"+text+"']"));
   
	   childMenu.click();
	   
	    
  Alert al=driver.switchTo().alert();
System.out.println(al.getText());
	al.accept();
	
	driver.switchTo().defaultContent();
	driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
	  act=new Actions(driver);
	 act.contextClick(rightClickbtn).build().perform();
	 rightClick=driver.findElements(By.cssSelector("ul.context-menu-list.context-menu-root span"));
	   
	
   
	}
	}
}
