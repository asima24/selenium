package actionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TabAction {static WebDriver driver;
public static void main(String[] args) {
	
	driver=new ChromeDriver();
	driver.get(" https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	driver.manage().window().maximize();
	WebElement firstname=driver.findElement(By.name("firstname"));
	Actions act=new Actions(driver);
	act.sendKeys(firstname, "Narshima")
	.sendKeys(Keys.TAB).sendKeys("Rao")
	.sendKeys(Keys.TAB).sendKeys("rao@gmail.com")
	.sendKeys(Keys.TAB).sendKeys("8923344455")
	.sendKeys(Keys.TAB).sendKeys("raoAppa@123")
	.sendKeys(Keys.TAB).sendKeys("raoAppa@123")
	.pause(1000)
	.sendKeys(Keys.TAB)
	.pause(1000)
	.sendKeys(Keys.TAB)
	.pause(1000)
	.sendKeys(Keys.TAB).click(driver.findElement(By.name("agree")))
	.pause(1000)
	.sendKeys(Keys.TAB).click()// check box gets unchecked
	.build().perform();
	
	Action action=act.sendKeys(firstname, "Narshima")
			.sendKeys(Keys.TAB).sendKeys("Rao").build();
	
	
}
}
