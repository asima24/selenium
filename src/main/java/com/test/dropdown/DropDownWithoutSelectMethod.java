package com.test.dropdown;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownWithoutSelectMethod {

	static WebDriver driver;
	public static void main(String[] args) {
	
		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial#free-trial-info-menu");
		By locatorkey=By.name("Country");
		
		//WebElement country=driver.findElement(locatorkey);
		getAllDropdownOptions(locatorkey);
	
		
		//doSelectByIndex(6,locatorkey);
		//doSelectByValue("Iceland",locatorkey);
	//doSelectByText("India",locatorkey);
		 //countrySelect.selectByValue("Belarus");
		 //countrySelect.selectByVisibleText("Benin");	 
		
	}
	
	public static int doGetDropdownCount(By locator) {
		return getAllDropdownOptions(locator).size();
		
	}
	public static WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> getAllDropdownOptions(By locator) {
	WebElement country=doGetElement(locator);
	 Select countrySelect=new Select(country);
	 
	 List<WebElement> countryList=countrySelect.getOptions();
	 List<String> optionValueList=new ArrayList();
	 System.out.println("List size is "+ countryList.size());
	  for(WebElement e:countryList) {
		 
		  System.out.println( e.getText());
		  optionValueList.add(e.getText());
		 
	  }
	  return optionValueList;
	}
	
	public static void doSelectDropDownValue(By locator, String dropDownValue) {
		Select select = new Select(doGetElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("total values : " + optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals(dropDownValue)) {
					e.click();
					break;
				}
		}
	}
}
