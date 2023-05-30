package testNGSession;

import org.testng.annotations.Test;

public class testCasesPriority {
	
	
	@Test(priority=-5)
	public void aTest()
	 {
		System.out.println("Test---aTest");
	}

	@Test(priority=3)
	public void doSearchTest()
	 {
		System.out.println("Test---doSearch");
	}
	
	@Test(priority=4)
	public void addToCartTest()
	 {
		System.out.println("Test---addToCart");
	}
	
	@Test
	public void doPaymentTest()
	 {
		System.out.println("Test---doPaymentTest");
	}
	@Test
	public void bTest()
	 {
		System.out.println("Test---bTest");
	}
}
