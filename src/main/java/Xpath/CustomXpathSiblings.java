package Xpath;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpathSiblings {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://selectorshub.com/xpath-practice-page/");
	
		//to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(5000);
        doSelectUser("Jasmine.Morgan");
        doSelectUser("Kevin.Mathews");
        System.out.println("------------");
       List<String> userInfoValue=doGetUserInfo("Kevin.Mathews") ;
       System.out.println(userInfoValue);
		
	}
	
	public static void doSelectUser(String userName) {
		String path="//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		System.out.println(path);
		   driver.findElement(By.xpath(path)).click();
		
	}
	
	public static List<String> doGetUserInfo(String userName) {
		String path="//a[text()='"+userName+"']/parent::td/following-sibling::td";
		List<WebElement> userInfoList=driver.findElements(By.xpath(path));
		List<String>   userInfoListValue=new ArrayList<String>();
		for(WebElement e:userInfoList) {
			String text=e.getText();
			//System.out.println(text);
			userInfoListValue.add(text);
		}
		
		return userInfoListValue;
		
	}

}
