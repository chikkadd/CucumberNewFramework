package stepDefinitions;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApplicationHooks {
    private DriverFactory driverFactory;
    private ConfigReader configReader;
    Properties prop;
    long startTime;
    public static final Logger LOG= LogManager.getLogger(ApplicationHooks.class);
    

    @Before(order=0)
    public void getProperty() {
		LOG.info("Initializing the properties file reader class ");
		System.out.println("reading the propertiries file");
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order=1)
    public void launchbrowser() {
        String browsername = prop.getProperty("browser");
        String url = prop.getProperty("url");
        driverFactory = new DriverFactory();
        driverFactory.init_driver(browsername, url);
        startTime = System.currentTimeMillis();
    }

    @After(order=0)
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replace(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver())
                                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    @After(order=1)
    public void tearDown2() {
        if (DriverFactory.getDriver() != null) {
            DriverFactory.getDriver().quit();
            DriverFactory.removeDriver();
        }
    }

}
