package waiteUtils;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitForElement {

	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		
		By username = By.name("username");
		By password = By.name("password");

		By forgotpwd = By.linkText("Forgot Password?");
		
		//WebDriverWait wdwait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//An expectation for checking that an element is present on the DOM of a page. 
		//This does notnecessarily mean that the element is visible.
		//WebElement uname_ele=wdwait.until(ExpectedConditions.presenceOfElementLocated(username));
		waitForElementPresence(username,10).sendKeys("manu");
		waitForElementPresence(password,5).sendKeys("pass@123");
		waitForElementPresence(forgotpwd,5).click();

	}
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 *This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator,int timeout) {
		WebDriverWait wdwait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wdwait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
/**
 * An expectation for checking that an element is present on the DOM of a page and visible.
 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
 * @param locator
 * @param timeout
 * @return
 */
	
	public static WebElement waitForElementVisible(By locator,int timeout) {
		WebDriverWait wdwait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wdwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
