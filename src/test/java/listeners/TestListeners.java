package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener{
	
	public static final Logger LOGGER= LogManager.getLogger(TestListeners.class);
	
	public void onStart(ITestContext context)
	{
		LOGGER.info("Test suite execution Started ");
	}
	public void onFinish(ITestContext context)
	{
		LOGGER.info("test suite execution Stopped ");
	}
	public void onTestStart(ITestResult result)
	{
		LOGGER.info("Execution started "+result.getMethod().getMethodName());
		LOGGER.info("Description !! "+result.getMethod().getMethodName());
	}
	public void onTestFinish(ITestResult result)
	{
		LOGGER.info("Execution finished "+result.getMethod().getMethodName());
		LOGGER.info("Description "+result.getMethod().getDescription());
	}
	public void onTestFailed(ITestResult result)
	{
		LOGGER.info("Test case execution faied "+result.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult result)
	{
		LOGGER.info("Execution skipped !!"+result.getMethod().getMethodName());
		LOGGER.info("Description !!"+result.getMethod().getDescription());
	}
	public void onTestSuccess(ITestResult result)
	{
		LOGGER.info("Passed !!"+result.getMethod().getMethodName());
		LOGGER.info("Description !!"+result.getMethod().getDescription());
	}
	
	
	

}
