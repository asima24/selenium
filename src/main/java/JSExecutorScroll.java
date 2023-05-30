import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorScroll {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
	driver=new ChromeDriver();
	
	driver.get("http://amazon.com");
	driver.manage().window().maximize();
JavaScriptUtil js=new JavaScriptUtil(driver);
//	 js.scrollPageDown();
//	 
//	 
//	 Thread.sleep(1000);
//	 js.scrollPageUp();
//	 Thread.sleep(2000);
//	 js.scrollPageDownMiddlepage();
//	 Thread.sleep(2000);
//	 js.scrollPageDown("1000");
	 

		//WebElement sustainableTechText= driver.findElement(By.xpath("//div[text()='Get to Know Us']"));
	

     JavascriptExecutor jse=(JavascriptExecutor)driver;
	//jse.executeScript("arguments[0].scrollIntoView(true);",sustainableTechText);
	//https://www.album.alexflueras.ro/#container
		//js.scrollIntoView(sustainableTechText);
	driver.get("https://www.album.alexflueras.ro/#container");
	driver.manage().window().maximize();
	
	jse.executeScript("scrollBy(1000,2000)");
	//getElementById
	//jse.executeScript("document.getElementBy('singer')='Run'");
	
	/*** to zoom in chrome***/
	
	String innerText=jse.executeScript("return document.documentElement.innerText;").toString();
	System.out.println(innerText);
	

	}

}
