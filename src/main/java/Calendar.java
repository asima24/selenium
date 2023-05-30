import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.ous.jtoml.ParseException;

public class Calendar {

	public static void main(String[] args) throws java.text.ParseException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://jqueryui.com/datepicker/");
driver.switchTo().frame(0);

        WebElement datepicker=driver.findElement(By.id("datepicker"));
        
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(datepicker));
		datepicker.click();
		
		String calendermonth=driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
		String calenderyear=driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
		
		String  dateToSelect="07/23/2023";
		
		String  displayedmonthYear=calendermonth+" "+calenderyear;
		System.out.println("Month and Year of the calendar  displayedmonthYear==="+ displayedmonthYear);
		 
		String currentDate=LocalDate.now().toString();
		 System.out.println(currentDate);
		 
//		String  day=String.valueOf(LocalDate.now().getDayOfMonth());
//	  System.out.println("Day========="+day);
//		String  month=String.valueOf(LocalDate.now().getMonthValue());
//		  System.out.println("month========="+month);
//		String  year=String.valueOf(LocalDate.now().getYear());
//		  System.out.println("Year========="+year);
		  
		  
//		  String desiredMonthYear=month+" "+year;
//		  System.out.println(desiredMonthYear);
		 
				
		  
	   
				   
				 Date current = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		
			Date selected = sd.parse(dateToSelect);
			String day = new SimpleDateFormat("dd").format(selected);
			String month = new SimpleDateFormat("MMMM").format(selected);
			String year = new SimpleDateFormat("yyyy").format(selected);
			System.out.println(day+" --- "+month+" --- "+ year);
			String desiredMonthYear=month+" "+year;
			System.out.println("desiredMonthYear ========="+desiredMonthYear);
			String xyz=driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
			System.out.println("Calender999999"+driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText());
			boolean match= xyz.equals(displayedmonthYear);
			System.out.println("Match=========="+match);
					
			while(true){
				displayedmonthYear=driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
				if(desiredMonthYear.equals(displayedmonthYear)){
					// select the day
					System.out.println("inside if");
					driver.findElement(By.xpath("//td//a[text()='"+day+"']")).click();
					break;
				}else{
					
					if(selected.compareTo(current) > 0)
						driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
					else if(selected.compareTo(current) < 0)
						driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();

				}
			}

		} 
		
	}

	
	


