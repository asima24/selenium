package actionClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TwoLevelMenuActionHandle {
	static WebDriver 	driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html
	 driver= new ChromeDriver();
	//driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
//		WebElement target=driver.findElement(By.cssSelector("a.menulink"));
//		Actions action=new Actions(driver);
//		action.moveToElement(target).build().perform();
//		
	//	driver.findElement(By.linkText("ARTICLES")).click();
		
	//mrbool
//	 By parentMenulocator=By.cssSelector("a.menulink");
//	 twoLevelHandle(parentMenulocator,"ARTICLES");
	 
	 driver.get("https://www.spicejet.com/");
//	 Alert al=driver.switchTo().alert();
//	 al.accept();
	 Thread.sleep(5000);
	 By parentMenulocator=By.xpath("//div[text()='Add-ons']");
	 twoLevelHandle(parentMenulocator,"Spice Assurance");
	}

	 public static void twoLevelHandle(By parentMenulocator,String childMenuLinkText) {
		 WebElement target=driver.findElement(parentMenulocator);
		Actions action=new Actions(driver);
		action.moveToElement(target).build().perform();
			
		driver.findElement(By.linkText(childMenuLinkText)).click();
	 }
}
