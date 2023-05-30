package actionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropHandle {
public static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		
		Actions act=new Actions(driver);	
		act.dragAndDrop(source, target).build().perform();
		
		 Action acts=act.moveByOffset(100,100).build();
		
		  if(driver.findElement(By.xpath("//p[text()='Dropped!']")).getText().equals("Dropped!")) {
			  System.out.println("Drag and drop is successfull");
		  }
		
	}

}
