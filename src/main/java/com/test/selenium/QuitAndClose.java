package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class QuitAndClose {

public static void main(String[] args) {
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Tools\\TestingTools\\selenium\\driver\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		 WebDriver driver=new ChromeDriver(ops);
		 driver.get("https://www.google.com/");
		 System.out.println(driver.getTitle());
		 driver.close();//NoSuchSessionException: invalid session id
		// driver.quit();//NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		 System.out.println(driver.getCurrentUrl());
		 
}
}