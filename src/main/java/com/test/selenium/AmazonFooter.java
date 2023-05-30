package com.test.selenium;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonFooter {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		
        driver.get("https://www.amazon.com");
		
        By footer=By.className("navFooterDescItem");
         int footerlinkCount= getElementCount(footer);
         if(footerlinkCount==36) {
        	 System.out.println("Correct no of links");
         }
         
         List<String> textValue=  getElementText(footer);
         boolean value=textValue.contains("Amazon Music\r\n"
         		+ "Stream millions\r\n"
         		+ "of songs");
         System.out.println(value);
         if(value) {
        	 System.out.println("Amazon Photos-Pass");
         }
       
         System.out.println("---------------------");
         clickElementFromPageSelection(footer, "Amazon Music");
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
			
	System.out.println(eletext);
		for(WebElement e:linksList) {
			
			String textValue=e.getText();
			
			System.out.println(textValue);
		if(textValue.contains(eletext))
			{
				e.click();
				break;
			//
			
		}
		
	}
	}
}
