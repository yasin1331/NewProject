package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilites.ExtentReporter;

public class listeners extends Base implements ITestListener {
	WebDriver driver = null;
	ExtentReports extentreport = ExtentReporter.getExtentReports();
	ExtentTest extenttest;
	ThreadLocal<ExtentTest> extenttestThread=new  ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName();
		extenttest = extentreport.createTest(testName);
		extenttestThread.set(extenttest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName();
		extenttestThread.get().log(Status.PASS, testName + "got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getName();
	
		extenttestThread.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			String screenshot = takeScreenshot(testName, driver);
			extenttestThread.get().addScreenCaptureFromPath(screenshot,testName);//**
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();

	}

}
