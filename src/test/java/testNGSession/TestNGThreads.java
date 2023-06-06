package testNGSession;

import org.testng.annotations.Test;

public class TestNGThreads {
	  @Test(threadPoolSize = 4, invocationCount = 2, timeOut = 1000)
	    public void testMethod() 
	    {
	        System.out.println("Thread ID Is : " + Thread.currentThread().getId());
	    }

	  @Test(expectedExceptions = ArithmeticException.class)
		public void homePageTest() {
			System.out.println("homePageTest");
			int i = 9/0;
		}
}
