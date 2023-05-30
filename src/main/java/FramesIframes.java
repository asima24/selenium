import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesIframes {
	static WebDriver driver;
	public static void main(String[] args) {
	
//		driver=new ChromeDriver();
//		driver.get("https://selectorshub.com/iframe-scenario/");
//     driver.switchTo().frame("pact1");
//     driver.findElement(By.id("inp_val")).sendKeys("ASK");
//     driver.switchTo().parentFrame();
//     driver.findElement(By.xpath("//ul[@id='menu-1-505c1be']/li[4]")).click();
//     
     
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
	driver.findElement(By.xpath("//div[@id='imageTemplateContainer']")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
	driver.findElement(By.xpath("//textarea[@name='RESULT_TextArea-5']")).sendKeys("Arina");
	}
}
