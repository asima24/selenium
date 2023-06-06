import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class amazongrid1 {
	
	@Test
	public void gridvalue() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		List<WebElement> el=driver.findElements(By.xpath("//a[@class='nav-a  ']"));
		System.out.println(el.size());

		List <String> str=new ArrayList<String>();
	     
	String[]  arr= { "Clinic","Best Sellers", "Customer Service", "Amazon Basics", "New Releases", "Prime", "Today's Deals", "Music","Books"};
		 
		 
	 	for(WebElement e:el) {
		    if(!(e.getText().equals(null))) {
			System.out.println(e.getText());
			str.add(e.getText());
			if(e.getText().equals("Books"))
				break;
		    }
		}
		
		System.out.println(str);
		str.toArray();
		List <String> strnew=str;
		boolean bol=arr.equals(str.toArray());

		System.out.println(bol);
		Assert.assertEquals(str.toArray(), arr);
		
	}

}
