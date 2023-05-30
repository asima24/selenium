import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		 //driver.get("https://www.grammarly.com/plagiarism-checker");
//		   JavascriptExecutor js=(JavascriptExecutor)driver;
//		    js.executeScript("window.scrollTo(0,'200')");
//		 driver.findElement(By.xpath("//span[text()='Upload a file']")).sendKeys("C:\\Users\\Administrator\\Documents\\allProd.properties.txt");
		
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Administrator\\Documents\\allProd.properties.txt");
		
	}

}
