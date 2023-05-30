package com.test.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DropDownWithoutSelectClass {


		static WebDriver driver;
		public static void main(String[] args) {
			
			driver=new ChromeDriver();
			driver.get("https://www.orangehrm.com/orangehrm-30-day-trial#free-trial-info-menu");
			By locatorkey=By.xpath("//select[@name='Country']/option");
			
			doSelectValueFromDropDownWithoutSelect(locatorkey , "India");
			
	}
		
		public static boolean doSelectValueFromDropDownWithoutSelect(By locator,String value) {
			boolean flag = false;
			List<WebElement> optionsList = doGetElements(locator);
			for(WebElement e : optionsList) {
				String text = e.getText();
					if(text.equals(value)) {
						flag = true;
						e.click();
						break;
					}
			}
			
			if(flag == false) {
				System.out.println(value + " is not present in the drop down " + locator);	
			}
			
			return flag;
			
		}
		
		public static List<WebElement> doGetElements(By locator) 
		{
			return driver.findElements(locator);
		}

}
