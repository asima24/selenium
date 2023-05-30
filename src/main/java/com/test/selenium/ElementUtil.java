package com.test.selenium;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	//https://www.lambdatest.com/selenium-playground/select-dropdown-demo
	//https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
	private WebDriver driver;
	private final int DEFAULT_TIME_OUT=5;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void doSendkeys(By locator,String value ) {
		if (value==null) {
			throw new MySeleniumException("ValuNULLException");
		}
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	
	public  WebElement getElement(By locator,int timeout) {
		return waitForElementVisible(locator, timeout);
	}
	
	public WebElement getElement(By locator) {
		WebElement element=null;
		try {
			element = driver.findElement(locator);
			System.out.println("element is found with locator: " + locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element is not found using this locator..." + locator);	
		
			element =  waitForElementVisible(locator, DEFAULT_TIME_OUT);
		}
		return element;
	}
	
	
	public void doClick(By locator) {

		getElement(locator).click();
	}
	public void doClick(By locator,int timeout) {

		checkElementClickable(locator,timeout).click();
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}

	
	public boolean checkElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public String doGetAttributeValue(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public int getElementCount(By locator) {
		return doGetElements(locator).size();
		
	}
	public List<WebElement> doGetElements(By locator) {
		return driver.findElements(locator);
	}
	
	public  List<String>  getElementAttribute(By locator,String attributeName) {
		List<WebElement> linksList = doGetElements(locator) ;//400 links
		List<String> attributeList=new ArrayList<String>();
			int totalimgs= linksList.size();
		System.out.println("total links = " + totalimgs);
		int count=0;
		for(WebElement e:linksList) {
			String attrValue=e.getAttribute(attributeName);
			System.out.println(count+"="+e.getAttribute(attributeName));
					attributeList.add(attrValue);
			count++;
		}
		return attributeList;
	}
	public  int doGetDropdownCount(By locator) {
		return getAllDropdownOptions(locator).size();
		
	}
	public  WebElement doGetElement(By locator) {
		return driver.findElement(locator);
	}

	public  List<String> getAllDropdownOptions(By locator) {
	WebElement country=doGetElement(locator);
	 Select countrySelect=new Select(country);
	 List<WebElement> optionList=countrySelect.getOptions();
	 List<String> optionValueList=new ArrayList();
	 System.out.println("List size is "+ optionList.size());
	  for(WebElement e:optionList) {
		 
		  System.out.println( e.getText());
		  optionValueList.add(e.getText());
		 
	  }
	  return optionValueList;
	}
	
	public boolean doSelectDropDownValue(By locator, String dropDownValue) {
		boolean flag=false;
		Select select = new Select(doGetElement(locator));
		List<WebElement> optionsList = select.getOptions();
		System.out.println("total values : " + optionsList.size());
		
		for(WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
				if(text.equals(dropDownValue)) {
					flag=true;
					e.click();
					break;
				}
		}
		if(flag==false) {
			System.out.println(dropDownValue +"is not present in the "+ locator);
		}
		return flag;
	}
	
	public  void doSelectByIndex(int index,By locator) {
		WebElement option=getElement(locator);
		Select countrySelect=new Select(option);
		countrySelect.selectByIndex(index);
	}
	public  void doSelectByValue(String value,By locator) {
		WebElement option=getElement(locator);
		Select countrySelect=new Select(option);
		countrySelect.selectByValue(value);
	}
	
	public  void doSelectByText(String text,By locator) {
		WebElement option=getElement(locator);
		Select countrySelect=new Select(option);
		countrySelect.selectByVisibleText(text);
	}
	
	public boolean doSelectValueFromDropDownWithoutSelect(By locator,String value) {
		boolean flag = false;
		List<WebElement> optionsList = doGetElements(locator);
		for(WebElement e : optionsList) {
			String text = e.getText();
				if(text.equals(value)) {
					flag = true;
					e.click();
					break;
				}
		}
		
		if(flag == false) {
			System.out.println(value + " is not present in the drop down " + locator);	
		}
		
		return flag;
		
	}
	// ****************Actions class Utils************************

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	//overloaded
	public void doActionsClick(By locator, int timeOut) {
		Actions act = new Actions(driver);
		act.click(checkElementClickable(locator, timeOut)).build().perform();
	}

	public void doDragAndDrop(By sourceLocator, By targetLocator) {
		Actions act = new Actions(driver);
		act.dragAndDrop(getElement(sourceLocator), getElement(targetLocator)).build().perform();
	}

	public void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).build().perform();
	}

	public void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).build().perform();
	}
	
	/********Wait******************/
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 *This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public  WebElement waitForElementPresence(By locator,int timeout) {
		WebDriverWait wdwait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wdwait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public  WebElement waitForElementVisible(By locator,int timeout) {
		WebDriverWait wdwait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wdwait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public WebElement checkElementClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}
