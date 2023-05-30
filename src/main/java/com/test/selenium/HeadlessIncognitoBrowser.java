package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessIncognitoBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		//co.addArguments(("--headless"));
		co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https:\\google.com");
		System.out.println(driver.getTitle());
		
		
	}

}
