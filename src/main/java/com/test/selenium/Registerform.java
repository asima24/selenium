package com.test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registerform {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
        By firstName= By.id("input-firstname");
        By lastName=By.id("input-lastname");//input-email
        By email=By.id("input-email");
        By telephone=By.id("input-telephone");
        By password=By.id("input-password");
        By confirmPswd=By.id("input-confirm");
        By checkbox=By.name("agree");
      
		WebElement field= driver.findElement(firstName);
		 System.out.println(doGetAttribute(firstName,"placeholder"));
		 field.sendKeys("Nayan");
		 //System.out.println(field.getAttribute("value"));
		 System.out.println(doGetAttribute(firstName,"value"));
		}
	
	
	public static String doGetAttribute(By locator,String attribute) {
		return driver.findElement(locator).getAttribute(attribute);
	}
	
	
}
