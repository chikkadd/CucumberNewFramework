package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"@target/failedrerun.txt"},
				 glue = "stepDefinitions",
				 monochrome = true,
				 tags = "@smoke",
				 plugin = {"pretty","rerun:target/failedrerun.txt"})

public class FailedRun extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
