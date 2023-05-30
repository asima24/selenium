package Xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CRMPROCustomPath {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.freecrm.com/");
		
		driver.findElement(By.name("username")).sendKeys("newautomation");
		  driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		  driver.findElement(By.xpath("//input[@value='Login']")).click();
		  driver.switchTo().frame("mainpanel");
		  
		  driver.findElement(By.xpath("//a[@title='Contacts']")).click();
		  

		////a[text()='Ali khan']/parent::td/preceding-sibling::td/input[@type='checkbox']
		// selectCheckboxUsername("Ali khan");
		 //selectMultipleCheckboxUsername("Bima P");
		  //userCompanyName("Bima P");
		  String companyName =  getContactCompanyName("Bima P");
		  System.out.println(companyName);

	}
	
	private static void userMultipleCompanyName(String string) {
		 driver.findElements(null);
		
	}

	public static void selectCheckboxUsername(String uname) {
		driver.findElement(By.xpath("//a[text()='"+uname+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
	}
	
	public static void selectMultipleCheckboxUsername(String uname) {
		List<WebElement> contactsCheckbox=driver.findElements(By.xpath("(//a[text()='"+uname+"'])/parent::td/preceding-sibling::td/input[@type='checkbox']"));
		
		for(WebElement e:contactsCheckbox) {
			e.click();
		}
		
		
	}
	public static void  userCompanyName(String uname) {
	String path="//a[text()='"+uname+"']/parent::td/following-sibling::td/a[@context='company']";
	////a[text()='Ali khan']/parent::td/following-sibling::td/a[@context='company']
	System.out.println(path);
	List<WebElement> companyList=driver
			.findElements
			    (By.xpath("path"));
	
	System.out.println(companyList.size());
     //System.out.println(companyName);
	for(WebElement e:companyList) {
		System.out.println(e.getText());
		
	}
	
	
		
	}
	public static String getContactCompanyName(String contactName) {
		return driver
			.findElement(By.xpath("//a[text()='"+contactName+"']/parent::td/following-sibling::td/a[@context='company']"))
				.getText();
	}
}