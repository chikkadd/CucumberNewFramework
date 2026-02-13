package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/appFeature/", glue = "stepDefinitions", monochrome = true,
		// tags = "@test",
		plugin = { "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json",
				"rerun:target/failedrerun.txt" })

public class MyTestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		System.setProperty("dataproviderthreadcount", "2");
		return super.scenarios();
	}

}
