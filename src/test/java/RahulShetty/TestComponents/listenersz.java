package RahulShetty.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Udemyresources.ExtentReporterNg;

public class listenersz extends BaseTest implements ITestListener{
	ExtentTest test;
	
	ExtentReports extent=ExtentReporterNg.getReportObject();
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
	}
	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e1) {
			e1.printStackTrace();
			
		}		
		String filePath = null;
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}
	
	
	public void onFinish(ITestContext context){
		extent.flush();
	}

}
