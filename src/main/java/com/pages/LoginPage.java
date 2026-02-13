package com.pages;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BaseActions{

	
	//1. By locators
	private static final By loginLink = By.xpath("//a[@href='/login']");
    private static final By emailIDtxt = By.xpath("//div[h2[text()='Login to your account']]/form/input[2]");
    private static final By passwordtxt = By.xpath("//div[h2[text()='Login to your account']]/form/input[3]");
    private static final By loginButton = By.xpath("//div[h2[text()='Login to your account']]//button");
    private static final By btnDeleteAccoutn = By.xpath("//a[contains(@href,'delete_account')]");
    private static final By lblInvalidLoginErrorMessage = By.xpath("//form[@action='/login']/p");
    
    //construction of the page class
    
    
    //behavior of the pages in form of method
    
    public static String getLoginPageTitle()
    {
    	return getCurrentPageTitle();
    }
    
    public static boolean isForgotPasswordLinkDisplayed()
    {
    	//return driver.findElement(loginLink).isDisplayed();
    	return isElementDisplayed(loginLink);
    }
    public static void EnterUserName(String username)
    {
    	enterText(emailIDtxt, username);
    }
    public static void EnterPassword(String password)
    {
    	//driver.findElement(passwordtxt).sendKeys(password);
    	enterText(passwordtxt, password);
    }
    
    public static void doLogin(String username, String password)
    {
    	//driver.findElement(loginLink).click();
    	click(loginLink);
    	System.out.println("login with "+username+ "and "+password);
    	//driver.findElement(emailIDtxt).sendKeys(username);
    	//driver.findElement(passwordtxt).sendKeys(password);
    	//driver.findElement(loginButton).click();
    	//return new CatagoriesPage(driver);
    	
    	enterText(emailIDtxt, username);
    	enterText(passwordtxt, password);
    	click(loginButton);
    }
    
    public static void clickSignInButton()
    {
    	//.findElement(loginButton).click();
    	click(loginButton);
    }
    public static void clickSignInLink()
    {
    	//driver.findElement(loginLink).click();
    	click(loginLink);
    }

    
    public static boolean isDeleteAccountDisplayed()
    {
    	return isElementDisplayed(btnDeleteAccoutn);
    }
    
    public static void validateInValideLoginErrorMessage(String expectedMessage)
    {
    	Assert.assertTrue(isElementDisplayed(lblInvalidLoginErrorMessage));
    	Assert.assertEquals(getText(lblInvalidLoginErrorMessage), expectedMessage,"error message does not match");
    }

}
