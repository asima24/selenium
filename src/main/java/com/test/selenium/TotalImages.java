package com.test.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

		static WebDriver driver;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			driver = new ChromeDriver();
			
	        driver.get("https://www.amazon.com/");
			
	        By img=By.tagName("img");
	        List<String> imgattributeList= getElementAttribute(img,"alt");
	        if(imgattributeList.contains("Camping"))
	        {
	        	System.out.println("The test is pass");
	        }
	          
//			List<WebElement> linksList = driver.findElements(img);	 //400 links
//			int totalimgs= linksList.size();
//			System.out.println("total links = " + totalimgs);
//			int count=0;
//			for(WebElement e:linksList) {
//				
//				 System.out.println(count+"="+e.getAttribute("src")+" " +e.getAttribute("alt"));
//				count++;
//			}
	}
		
		
		
		public static int getElementCount(By locator) {
			return doGetElements(locator).size();
			
		}
		public static List<WebElement> doGetElements(By locator) {
			return driver.findElements(locator);
		}
		
		public static List<String>  getElementAttribute(By locator,String attributeName) {
			List<WebElement> linksList = doGetElements(locator) ;//400 links
			List<String> attributeList=new ArrayList<String>();
 			int totalimgs= linksList.size();
			System.out.println("total links = " + totalimgs);
			int count=0;
			for(WebElement e:linksList) {
				String attrValue=e.getAttribute(attributeName);
				System.out.println(count+"="+e.getAttribute(attributeName));
						attributeList.add(attrValue);
				count++;
			}
			return attributeList;
		}
     
}
