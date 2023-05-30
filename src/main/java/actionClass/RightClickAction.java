package actionClass;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//right Click on the button ,select one of the option click on it accept the alert and again 
//start over for other option

public class RightClickAction {

	public static void main(String[] args) {
	WebDriver 	driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement target=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action=new Actions(driver);
		
		action.contextClick(target).build().perform();
				List<WebElement> rightClickOptions=driver.findElements(By.cssSelector("li.context-menu-item.context-menu-icon"));
		System.out.println("Number of options "+ rightClickOptions.size());
		  
		for(WebElement e:rightClickOptions) {
			String textValue=e.getText();
			System.out.println(textValue);
				e.click();

				Alert al=driver.switchTo().alert();
				al.accept();
				
				driver.switchTo().defaultContent();
				action.contextClick(target).build().perform();
			
			
		}
		
		
		
	}

}
