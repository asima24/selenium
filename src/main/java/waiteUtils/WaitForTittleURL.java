package waiteUtils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.selenium.ElementUtil;

public class WaitForTittleURL {
static WebDriver driver;
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		By forgotPwdLink = By.linkText("Forgot Password?");
		By pricing = By.linkText("Pricing");
		
		ElementUtil ele=new ElementUtil(driver);
		ele.clickElementWhenReady(pricing, 10);
		
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//		if(wait.until(ExpectedConditions.urlContains("pricing.html")))
//		{
//			System.out.println("It contains \"pricing.html\" .The URL is "+driver.getCurrentUrl());
//		}else {
//			System.out.println("The URL doesn't contain\"pricing.html\" ");
//		}
		System.out.println(waitForURLContainsAndCapture("pricing.html5",5));
		
	}
	
	public static String waitForURLContainsAndCapture(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			String url = driver.getCurrentUrl();
			return url;
		} else {
			System.out.println("url is not present within the given timeout : " + timeOut);
			return null;
		}
	}

	
public static String waitForURLAndCapture(String urlValue, int timeOut) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if (wait.until(ExpectedConditions.urlToBe(urlValue))) {
		String url = driver.getCurrentUrl();
		return url;
	} else {
		System.out.println("url is not present within the given timeout : " + timeOut);
		return null;
	}
}

public static String waitForTitleIsAndCapture(String titleFraction, int timeOut) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
		String title = driver.getTitle();
		return title;
	} else {
		System.out.println("title is not present within the given timeout : " + timeOut);
		return null;
	}
}

public static String waitForFullTitleAndCapture(String titleVal, int timeOut) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	if (wait.until(ExpectedConditions.titleIs(titleVal))) {
		String title = driver.getTitle();
		return title;
	} else {
		System.out.println("title is not present within the given timeout : " + timeOut);
		return null;
	}
}}


