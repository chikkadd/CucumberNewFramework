package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser, String url) {
		System.out.println("browser value is :" + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			// Run in headless mode
			options.addArguments("--headless=new"); // modern headless mode
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");

			// Use a specific Chrome profile (optional)
			// Replace with your actual Chrome user data directory path
			// options.addArguments("user-data-dir=/path/to/your/chrome/profile");

			tlDriver.set(new ChromeDriver(options));

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			tlDriver.set(new SafariDriver());

		} else {
			System.out.println("Please pass correct browser value " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(url);

		return getDriver();
	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void removeDriver() {
		tlDriver.remove();
	}
}
