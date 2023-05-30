package com.test.selenium;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BrowserUtil tb = new BrowserUtil();
		tb.initDriver("chrome");
		tb.launchURL("http://www.amazon.com");
		System.out.println(tb.getPageTittle());
		if (Validation.equalValues(tb.getPageTittle(), "Amazon.com. Spend less. Smile more.")) {
			System.out.println("Tittle page is equal");
		}

	}

}
