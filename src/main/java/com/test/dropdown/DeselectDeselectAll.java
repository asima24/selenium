package com.test.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeselectDeselectAll {
	static WebDriver driver;
	public static void main(String[] args) {
	
		driver=new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		By locatorkey=By.name("States");
	 WebElement el=driver.findElement(locatorkey);
		
		  Select sel=new Select(el);
		  
		  sel.selectByValue("California");
		  sel.selectByValue("New Jersey");
		  sel.selectByIndex(7);
		  WebElement firstSelectedOption=sel.getFirstSelectedOption();
		  System.out.println("----"+ firstSelectedOption.getText()+"----");
		  sel.deselectByValue("New Jersey");
		  List<WebElement> allOptions=sel.getAllSelectedOptions();
		  for(WebElement e:allOptions) {
			  e.getText();
			  System.out.println(e.getText());
		  }
		  
		  sel.deselectAll();
		 
	
	}

}
