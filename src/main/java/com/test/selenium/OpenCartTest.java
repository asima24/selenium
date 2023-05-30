package com.test.selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.helpers.Util;

public class OpenCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtil browutil=new BrowserUtil();
		WebDriver driver=browutil.initDriver("chrome");
		browutil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        String tittle=browutil.getPageTittle();
        System.out.println("The tittle is :"+ tittle);
        
        ElementUtil  eutil=new ElementUtil(driver);
          By firstName= By.id("input-firstname");
          By lastName=By.id("input-lastname");//input-email
          By email=By.id("input-email");
          By telephone=By.id("input-telephone");
          By password=By.id("input-password");
          By confirmPswd=By.id("input-confirm");
          By checkbox=By.name("agree");
        
          eutil.doSendkeys(firstName, "Raman");
          eutil.doSendkeys(lastName, "Choudhary");
          eutil.doSendkeys(email, "raman@gmail.com");
          eutil.doSendkeys(telephone, "879123456");
          eutil.doSendkeys(password, "Raman123");
          eutil.doSendkeys(confirmPswd, "Raman123");
        
        
          List<WebElement> tags= driver.findElements(By.tagName("a"));
       // ArrayList<String> l=new ArrayList();
          
          
          
          
        

	}
	
	

}
