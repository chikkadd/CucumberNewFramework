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

import com.qa.factory.DriverFactory;

import org.junit.Assert;

public class BaseActions {
	
	public static final long DRIVER_WAIT_TIME = 30;
    public static final Logger LOG = LogManager.getLogger(BaseActions.class);

    private static WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DRIVER_WAIT_TIME));
    }

    public static void click(By by) {
        try {
            LOG.info("clicking on element " + by.toString());
            getWait().until(ExpectedConditions.elementToBeClickable(by));
            getElement(by).click();
        } catch (Exception exception) {
            LOG.info("Exception -> " + exception.getMessage());
            Assert.fail();
        }
    }

    public static WebElement getElement(By by) {
        try {
            return getDriver().findElement(by);
        } catch (TimeoutException exception) {
            LOG.info("Exception -> " + exception.getMessage());
            Assert.fail();
            return null;
        }
    }

	 public static List<WebElement> getElements(By by)
	 {
		 List<WebElement> elements=null;
		 try
		 {
			 getWait().until(ExpectedConditions.presenceOfElementLocated(by));
			 elements=getDriver().findElements(by);
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
			 getWait().until(ExpectedConditions.presenceOfElementLocated(by));
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
			 getWait().until(ExpectedConditions.visibilityOf(element));
			 isElement = element.isDisplayed();
			 
		 }
		 catch(Exception exception)
		 {
			 LOG.info(exception.getMessage());
		 }
		 return isElement;
	 }
	 
	 public static Boolean isElementDisplayed(final By by)
	 {
		Boolean isElement=false;
		WebElement element = getElement(by);
		 try
		 {
			 getWait().until(ExpectedConditions.visibilityOf(element));
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
			 getWait().until(ExpectedConditions.presenceOfElementLocated(by));
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
		 return getWait().until(ExpectedConditions.presenceOfElementLocated(by));
	 }
	 
	 public static List<WebElement> waitForExpectedElementsPresence(By by)
	 {
		 LOG.info("waiting for presence of elements ");
		 return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	 }
	 
	 public static void javaScriptClick(By by)
	 {
		 try
		 {
			 LOG.info("clicking on element using javascript click" +by.toString());
			 elementToBeClickable(by);
			 WebElement element= getElement(by);
			 JavascriptExecutor js=(JavascriptExecutor)getDriver();
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
	     
	    	 return getWait().until(ExpectedConditions.elementToBeClickable(by));
	    }
	 public static void javaScriptClick(WebElement element)
	 {
		 try
		 {
			 LOG.info("clicking on element using javascript click" +element.toString());
			
			 JavascriptExecutor js=(JavascriptExecutor)getDriver();
			 js.executeScript("Arguments[0].click();", element);
			 LOG.info("Element clicked -> " + element.toString());
		 }
		 catch(Exception exception)
		 {
			 LOG.info("excpeiton  -->" +exception.getMessage());
			 Assert.fail();
		 }
	 }
	 
	    /**
	     * Returns the current page title from page
	     */
	    public static String getCurrentPageTitle() {
	        return getDriver().getTitle();
	    }
	    
	    public static void enterText(By by, String text) {
	        isElementDisplayedAndEnabled(by);
	        clearEnterText(by, text);
	        LOG.info("Text entered in text box with value " + text);
	    }
	    public static void clearEnterText(By by, String inputText) {
	        waitForExpectedElement(by).clear();
	        waitForExpectedElement(by).sendKeys(inputText);
	   
	    }
	    
	    public static boolean isElementDisplayedAndEnabled(final By by) {
	        try {
	           
	            return waitForExpectedElement(by).isDisplayed() && waitForExpectedElement(by).isEnabled();
	        } catch (Exception exception) {
	            LOG.info(exception.getMessage());
	            LOG.info("Exception while checking element - " + by.toString());
	            return false;
	        }
	    }
	 
	 public static void enterTextByJavaScript(By by, String value)
	 {
		 try
		 {
			 LOG.info("Element for entering text using javascript ->" +by.toString());
			 waitForExpectedElement(by);
			 JavascriptExecutor js=(JavascriptExecutor)getDriver();
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
