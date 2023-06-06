import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonGrid {
	static WebDriver driver;
	public static void main(String[] args) {
	
	driver=new ChromeDriver();
	driver.get("https://www.amazon.com/");
	List<WebElement> el=driver.findElements(By.xpath("//a[@class='nav-a  ']"));
	System.out.println(el.size());

	List <String> str=new ArrayList<String>();
     
String[]  arr= { "clinic","Best Sellers", "Customer Service", "Amazon Basics", "New Releases", "Prime", "Today's Deals", "Music"," Books"};
	 String arr1=Arrays.toString(arr);
	System.out.println(Arrays.toString(arr));
// 	for(WebElement e:el) {
//	    if(!(e.getText().equals(null))) {
//		System.out.println(e.getText());
//		str.add(e.getText());
//		if(e.getText().equals("Books"))
//			break;
//	    }
//	}
 	
	int count=0;
	for(WebElement e:el) {
		 if(e.getText().length()>0) {
		 System.out.println(count+"="+e.getText());
		 str.add(e.getText());
		 }
		count++;
	}
	
	System.out.println(str);

	//List <String> strnew=str;
	boolean bol=str.equals(arr1);

	System.out.println(bol);
	}
}
