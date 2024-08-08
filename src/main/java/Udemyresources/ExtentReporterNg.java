package Udemyresources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	
	public static ExtentReports getReportObject()
	{
		
	//ExtentrReports, ExtentSparksRepporter
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter report=new ExtentSparkReporter(path);
	report.config().setDocumentTitle("Title results");
	report.config().setDocumentTitle("Title results");
	
	ExtentReports	extent=new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester","Rahul Shetty");
	return extent;
}
}
