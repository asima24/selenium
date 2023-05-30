package com.test.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {
	static WebDriver driver;
	public static void main(String[] args) {
	
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial#free-trial-info-menu");
		By locatorkey=By.name("Country");
		
		// Select countrySelect=new Select(country);
		//doSelectByIndex(6,locatorkey);
		//doSelectByValue("Iceland",locatorkey);
	doSelectByText("India",locatorkey);
		 //countrySelect.selectByValue("Belarus");
		 //countrySelect.selectByVisibleText("Benin");	 
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectByIndex(int index,By locator) {
		WebElement country=getElement(locator);
		Select countrySelect=new Select(country);
		countrySelect.selectByIndex(index);
	}
	public static void doSelectByValue(String value,By locator) {
		WebElement country=getElement(locator);
		Select countrySelect=new Select(country);
		countrySelect.selectByValue(value);
	}
	
	public static void doSelectByText(String text,By locator) {
		WebElement country=getElement(locator);
		Select countrySelect=new Select(country);
		countrySelect.selectByVisibleText(text);
	}
	
	
}
