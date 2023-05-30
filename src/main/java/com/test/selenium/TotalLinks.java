package com.test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {
  static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		
        driver.get("https://www.amazon.com/");
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));	 //400 links
				
		int totalLinks = linksList.size();
		System.out.println("total links = " + totalLinks);
		int count=0;
		for(WebElement e:linksList) {
			 if(e.getText().length()>0) {
			 System.out.println(count+"="+e.getText());}
			count++;
		}
		

	}

}
