import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pagination {

	public static WebDriver driver;
	static int countrySize;
	static int size;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	////td[text()='Denmark']/preceding-sibling::td/input[@type='checkbox']
		while(true) {
			countrySize=driver.findElements(By.xpath("//td[text()='India']")).size();
			System.out.println("Number of same country name in the table "+countrySize);
			if(driver.findElements(By.xpath("//td[text()='India']")).size()>0) {
//				driver.findElement(By.xpath("//td[text()='India']/preceding-sibling::td/input[@type='checkbox']")).click();
//				break;
				multiSelectCountry("India");
				if(size==countrySize)
					break;
				
			}
			else {
				WebElement next = driver.findElement(By.linkText("Next"));

				if(next.getAttribute("class").contains("disabled"))
						{
						System.out.println("pagination is over...country is not found...");
						break;
				}
					//paginate_button next disabled
					next.click();
			}
		}

	}
	
	
	public static int multiSelectCountry(String country) throws InterruptedException {
		
		for(int i=1;i<=countrySize;i++) {
			driver.findElement(By.xpath("(//td[text()='India'])["+i+"]/preceding-sibling::td/input[@type='checkbox']")).click();
			Thread.sleep(2000);
			size++;
			
		}
		return size;
		
	}




	
}
