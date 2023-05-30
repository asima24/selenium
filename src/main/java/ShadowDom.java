import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(5000);
		String input_path= "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element =(WebElement)js.executeScript(input_path);
		element.sendKeys("gulgaon");
		
	}

}
