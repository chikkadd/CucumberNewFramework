package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatagoriesPage extends BaseActions{

	
	private static final By catagoriesSection = By.cssSelector("div.panel-group>div");
	
	/*
	 * public CatagoriesPage(WebDriver driver) { this.driver=driver;
	 * 
	 * }
	 */
	public static String getPageTitle()
	{
		return getCurrentPageTitle();
	}
	
	public static int getCatagoryCount()
	{
		//return driver.findElements(catagoriesSection).size();
		List<WebElement> catagories= getElements(catagoriesSection); 
		return catagories.size();
	}
	
	public static List<String> getCatagoriesList()
	{
		List<String> txtCatagories= new ArrayList<>();
		List<WebElement> catagoriesList=getElements(catagoriesSection);
		//for(WebElement e : catagoriesList)
		//{
		//	String text= e.getText();
		//	System.out.println(text);
		//	txtCatagories.add(text);
		//}
		
		catagoriesList.forEach(element->txtCatagories.add(element.getText()));
		System.out.println(catagoriesList);
		return txtCatagories;
	}

}
