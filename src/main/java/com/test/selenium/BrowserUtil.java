package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {
	WebDriver driver;
	
	/**
	 * This method initializes the browser based on the browser name provided
	 * The browser supported are chrome,edge,safari and firefox
	 * @param browserName
	 */
	
	public WebDriver initDriver(String browserName) {
		
		System.out.println("Launching the browser:"+ browserName);
		
		if (browserName==null) {
			System.out.println("browser can't be null");
			throw new MySeleniumException("BrowserNullException");
		}
		else if(browserName.toLowerCase().trim().equals("chrome")){
			//ChromeOptions co = new ChromeOptions();
			//co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
			
		}else if(browserName.toLowerCase().trim().equals("mozilla")){
		 driver=new FirefoxDriver();
		}else if(browserName.toLowerCase().trim().equals("edge")){
			 driver=new EdgeDriver();
			}else if(browserName.toLowerCase().trim().equals("safari")){
				 driver=new SafariDriver();
			}
		
		driver.manage().window().maximize();
		return driver;
		
		
		
	}
	
	/**
	 * This launches the  URL provided and check if it contains http\https.
	 * @param URL
	 */
	public void launchURL(String URL) {
		System.out.println("The URL is "+URL);
		if(URL.contains("http")) {
			driver.get(URL);
		}
		
	}
	
	/**
	 * Returns the page title
	 * @return
	 */
	
	
	public String getPageTittle() {
		return  driver.getTitle();
		
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
