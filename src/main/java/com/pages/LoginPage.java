package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
private WebDriver driver;
	
	//1. By locators
	private By loginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By emailIDtxt = By.xpath("//div[h2[text()='Login to your account']]/form/input[2]");
    private By passwordtxt = By.xpath("//div[h2[text()='Login to your account']]/form/input[3]");
    private By loginButton = By.xpath("//div[h2[text()='Login to your account']]//button");
    
    //construction of the page class
    
    public LoginPage(WebDriver driver)
    {
    	this.driver=driver;
    }
    
    //behavior of the pages in form of method
    
    public String getLoginPageTitle()
    {
    	return driver.getTitle();
    }
    
    public boolean isForgotPasswordLinkDisplayed()
    {
    	return driver.findElement(loginLink).isDisplayed();
    }
    public void EnterUserName(String username)
    {
    	driver.findElement(emailIDtxt).sendKeys(username);
    }
    public void EnterPassword(String password)
    {
    	driver.findElement(passwordtxt).sendKeys(password);
    }
    
    public CatagoriesPage doLogin(String username, String password)
    {
    	driver.findElement(loginLink).click();
    	System.out.println("login with "+username+ "and "+password);
    	driver.findElement(emailIDtxt).sendKeys(username);
    	driver.findElement(passwordtxt).sendKeys(username);
    	driver.findElement(loginButton).click();
    	return new CatagoriesPage(driver);
    }
    
    public void clickSignInButton()
    {
    	driver.findElement(loginButton).click();
    }
    public void clickSignInLink()
    {
    	driver.findElement(loginLink).click();
    }
    public void clickLoginLink(String password)
    {
    	driver.findElement(loginLink).click();
    }

}
