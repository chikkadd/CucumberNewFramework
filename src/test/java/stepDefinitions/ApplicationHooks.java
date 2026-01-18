package stepDefinitions;

import java.io.File;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	public static final Logger LOG= LogManager.getLogger(ApplicationHooks.class);
	long startTime;
	
	@Before(order=0)
	public void getProperty()
		{
		LOG.info("Initializing the properties file reader class ");
		System.out.println("reading the propertiries file");
		configReader=new ConfigReader();
		prop=configReader.init_prop();
	
		}
	
	@Before(order=1)
	public void launchbrowser()
		{
		String browsername=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browsername);
		startTime=System.currentTimeMillis();
		}
	

	
	@After(order=0)
	public void quitbrowser(Scenario scenario)
	{
		
		 LOG.info("_________After scenario- - - >" + scenario.getName() + "______");
		 long estimatedTime = System.currentTimeMillis() - startTime;
		 driver.quit();
		 
	}
	
	

	
	@After(order=1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotName=scenario.getName().replace(" ", "_");
			byte [] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
	
	
	/*
	 * @After(order=1) public void screenshot(Scenario scenario) {
	 * if(scenario.isFailed()) { String
	 * screenshotName=scenario.getName().replace(" ", "_"); byte [] sourcePath=
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	 * scenario.attach(sourcePath, "image/png", screenshotName); } }
	 */

}
