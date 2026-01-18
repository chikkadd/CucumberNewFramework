package com.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class BaseActions {
	
	private static WebDriver driver;
	 public static final long DRIVER_WAIT_TIME = 30;
	 
	 public static final Logger LOG=LogManager.getLogger(BaseActions.class);
	 
	 public static WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(DRIVER_WAIT_TIME));
	 
	 public static void click(By by)
	 {
		 try
		 {
		 LOG.info("clicking on element "+by.toString());
		 wait.until(ExpectedConditions.elementToBeClickable(by));
		 getElement(by).click(); 
		 }
		 catch (Exception exception) {
			 LOG.info("Exception -> " + exception.getMessage());
			 Assert.fail();
		}
		 
	 }
	 
	 public static void click(WebElement element)
	 {
		 try
		 {
		 LOG.info("clicking on element "+element.toString());
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 element.click();
		 }
		 catch (Exception exception) {
			 LOG.info("Exception -> " + exception.getMessage());
			 Assert.fail();
		}
		 
	 } 
	 
	 public static WebElement getElement(By by)
	 {
		 WebElement element=null;
		 try
		 {
			 wait.until(ExpectedConditions.presenceOfElementLocated(by));
			 element=driver.findElement(by);
		 }
		 catch (TimeoutException exception) {
			 LOG.info("Exception -> " + exception.getMessage());
			 Assert.fail();
		}
		 return element;
	 }
	 
	 public static List<WebElement> getElements(By by)
	 {
		 List<WebElement> elements=null;
		 try
		 {
			 wait.until(ExpectedConditions.presenceOfElementLocated(by));
			 elements=driver.findElements(by);
		 }
		 catch (TimeoutException exception) {
			 LOG.info("Exception -> " + exception.getMessage());
			 Assert.fail();
		}
		 return elements;
	 }
	 
	 public static String getText(By by)
	 {
		 String strText="";
		 try {
			 LOG.info("Element for get text is "+by.toString());
			 wait.until(ExpectedConditions.presenceOfElementLocated(by));
			 WebElement element = getElement(by);
			 strText = element.getText();	
			 LOG.info("text of the element is "+strText);
		 } catch (Exception exception) {
			 LOG.info("Exception -> " + exception.getMessage());
			 Assert.fail();
		}
		 return strText;
	 }
	 
	 
	 public static String getText(WebElement element)
	 {
		 String strText="";
		 try {
			 LOG.info("Element for get text is "+element.toString());
			if( isElementDisplayed(element))
			 strText = element.getText();	
			 LOG.info("text of the element is "+strText);
		 } catch (Exception exception) {
			 LOG.info("Exception -> " + exception.getMessage());
			 Assert.fail();
		}
		 return strText;
	 }
	 
	 public static Boolean isElementDisplayed(WebElement element)
	 {
		Boolean isElement=false;
		 try
		 {
			 wait.until(ExpectedConditions.visibilityOf(element));
			 isElement = element.isDisplayed();
			 
		 }
		 catch(Exception exception)
		 {
			 LOG.info(exception.getMessage());
		 }
		 return isElement;
	 }
	 
	 public static String getAttrubute(By by, String value)
	 {
		 String strText="";
		 try {
			 LOG.info("Attribute value of element "+by.toString());
			 wait.until(ExpectedConditions.presenceOfElementLocated(by));
			 WebElement element=getElement(by);
			 strText = element.getAttribute(value);
		 }
		 catch(Exception exeption)
		 {
			 LOG.info("Exception " + exeption.getMessage());
		 }
		 return strText;
	 }
	 
	 public static WebElement waitForExpectedElement(By by)
	 {
		 LOG.info("waiting for the presence of element "+by.toString());
		 return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	 }
	 
	 public static List<WebElement> waitForExpectedElementsPresence(By by)
	 {
		 LOG.info("waiting for presence of elements ");
		 return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	 }
	 
	 public static void javaScriptClick(By by)
	 {
		 try
		 {
			 LOG.info("clicking on element using javascript click" +by.toString());
			 elementToBeClickable(by);
			 WebElement element= getElement(by);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("Arguments[0].click();", element);
			 LOG.info("Element clicked "+element.toString());
		 }
		 catch(Exception exception)
		 {
			 LOG.info("excpeiton  -->" +exception.getMessage());
			 Assert.fail();
		 }
	 }
	 public static WebElement elementToBeClickable(By by) {
	     
	    	 return wait.until(ExpectedConditions.elementToBeClickable(by));
	    }
	 public static void javaScriptClick(WebElement element)
	 {
		 try
		 {
			 LOG.info("clicking on element using javascript click" +element.toString());
			
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("Arguments[0].click();", element);
			 LOG.info("Element clicked -> " + element.toString());
		 }
		 catch(Exception exception)
		 {
			 LOG.info("excpeiton  -->" +exception.getMessage());
			 Assert.fail();
		 }
	 }
	 
	 public static void enterTextByJavaScript(By by, String value)
	 {
		 try
		 {
			 LOG.info("Element for entering text using javascript ->" +by.toString());
			 waitForExpectedElement(by);
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 WebElement element= getElement(by);
			 js.executeScript("arguments[0].value=arguments[1]", element,value);
			 LOG.info("Element clicked -> " + element.toString());
		 }
		 catch(Exception exception)
		 {
			 LOG.info("excpeiton  -->" +exception.getMessage());
			 Assert.fail();
		 }
	 }
	 
	 
	 

}
