package com.test.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RightPanelLink {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
        By rightPanel=By.className("list-group-item");
         int linkCount= getElementCount(rightPanel);
         if(linkCount==13) {
        	 System.out.println("Correct no of links");
         }
         
         List<String> textValue=  getElementText(rightPanel);
         if(textValue.contains("Forgotten Password")) {
        	 System.out.println("Forgotten password-Pass");
         }
       
         clickElementFromPageSelection(rightPanel, "Forgotten Password");
//		List<WebElement> linksList = driver.findElements(img);	 //400 links
//		int totalimgs= linksList.size();
//		System.out.println("total links = " + totalimgs);
//		int count=0;
//		for(WebElement e:linksList) {
//			
//			 System.out.println(count+"="+e.getAttribute("src")+" " +e.getAttribute("alt"));
//			count++;
//		}
}
	
	
	
	public static int getElementCount(By locator) {
		return doGetElements(locator).size();
		
	}
	public static List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static List<String>  getElementText(By locator) {
		List<WebElement> linksList = doGetElements(locator) ;//400 links
		List<String> textList=new ArrayList<String>();
			
		int count=0;
		for(WebElement e:linksList) {
			
			String textValue=e.getText();
			System.out.println(count+"="+e.getText());
					textList.add(textValue);
			count++;
		}
		return textList;
	}
 
	
	public static void  clickElementFromPageSelection(By locator,String eletext) {
		List<WebElement> linksList = doGetElements(locator) ;//400 links
		List<String> textList=new ArrayList<String>();
			
	
		for(WebElement e:linksList) {
			
			String textValue=e.getText();
			if(textValue.equals(eletext))
			{
				e.click();
				break;
			}
			
		}
		
	}
 
}
//navFooterDescItem