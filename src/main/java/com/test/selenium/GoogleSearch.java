package com.test.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	static WebDriver driver;

	public static void searchElement(By locatorKey, String searchKey, String suggestionName, By suggestions) {
		driver.findElement(locatorKey).sendKeys(searchKey);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> suggestionList = driver.findElements(suggestions);
		System.out.println("Total size " + suggestionList.size());
		
		if( suggestionList.size()>0) {
		for (WebElement e : suggestionList) {
			String textvalue = e.getText();
			if (textvalue.length() > 0 && !textvalue.equals(" ")) {
				System.out.println(e.getText());
				if (textvalue.toLowerCase().contains(suggestionName)) {
					e.click();
					break;
				} 
			}else {
				System.out.println("blank suggestion --No suggestion");
				break;
			}
			

		}
		} else
			System.out.println("No suggestion found");
	}

	 public boolean isElementDisplayed(By locatorKey) {
		int size=  driver.findElements(By.id("")).size();
		if(size>0) {
			System.out.println(locatorKey+"element is present");
			return true;
		}else
		{
			return false;
		}
			
		}
		 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * driver = new ChromeDriver(); driver.get("https://www.google.com"); By
		 * locatorKey = By.name("q"); By suggestions = By.className("wM6W7d");
		 * searchElement(locatorKey, "sdddddd", "123456", suggestions);
		 */

		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com"); 
		 By locatorKey = By.xpath("//input[@id='twotabsearchtextbox']");
		By suggestions = By.cssSelector("div.s-suggestion.s-suggestion-ellipsis-direction");
		 searchElement(locatorKey, "girl dress", "girl dresses", suggestions);
	}

}
