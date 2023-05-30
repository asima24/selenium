package waiteUtils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForAlerts {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			
			driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
			
//			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//			Alert al=wait.until(ExpectedConditions.alertIsPresent());
			System.out.println(alertJSGetText(10));
			alertJSDismiss(5);

	}
	
	public static Alert waitForAlertJSPopUp(int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	public static String alertJSGetText(int timeOut) {
		return waitForAlertJSPopUp(timeOut).getText();
	}
	public static void alertJSAccept(int timeOut) {
		waitForAlertJSPopUp(timeOut).accept();
	}
	public static void alertJSDismiss(int timeOut) {
		waitForAlertJSPopUp(timeOut).dismiss();;
	}
	public static void EnterAlertValue(int timeOut, String value) {
		waitForAlertJSPopUp(timeOut).sendKeys(value);
	}

}
