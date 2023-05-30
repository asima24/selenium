package testNGSession;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGAnnotations {
	
	//Global precondition
	//Precondiotion
	//Test steps-- Expected condition Pass/Fail
	//post condition
	//global postcondition
	@BeforeSuite
	public void dbConnection()
	{
		System.out.println("BeforeSuite---dbConnection");
	}
	@BeforeTest
	public void  createUser() {
		System.out.println("BeforeTest---createUser");
	}
	@BeforeClass
	public void openBrowser() {
		System.out.println("BeforeClass---openBrowser");
	}
	

	@BeforeMethod
	public void doLogin () {
		System.out.println("-----------------");
		System.out.println("BeforeMethod---doLogin");
	}
	
	
	@Test
	public void doSearchTest()
	 {
		System.out.println("Test---doSearch");
	}
	
	@Test
	public void addToCartTest()
	 {
		System.out.println("Test---addToCart");
	}
	
	@Test
	public void doPaymentTest()
	 {
		System.out.println("Test---doPaymentTest");
	}
	
	@AfterMethod
	public void doLogout () {
		System.out.println("AfterMethod---doLogout");
		
	}
	
	@AfterClass
	public void  closeBrowser() {
		System.out.println("-----------------");
		System.out.println("AfterClass---closeBrowser");
	}
	@AfterTest
	public void  deleteUser() {
		System.out.println("AfterTest---deleteUser");
	}
	
	@AfterSuite
	public void dbConnectionClose()
	{
		System.out.println("AfterSuite---dbConnectionClose");
	}


}
