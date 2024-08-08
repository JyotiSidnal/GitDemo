package RahulShetty.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import Udemy.PageObjects.LandingPage;

public class BaseTest {
	 public WebDriver driver;
	 public LandingPage lp;
	 
	 public WebDriver initializeDriver() throws IOException
	 {
		 //properties class
		 
		 Properties prop=new Properties();		
		 FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Udemyresources//GlobalData.properties");
		 prop.load(fis);
		// String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		 String browserName=prop.getProperty("browser");
		 if(browserName.equalsIgnoreCase("Firefox"))
		 {
			 driver=new FirefoxDriver();
		 }
	     else if(browserName.equalsIgnoreCase("chrome"))
	     {
		 //firefox
	     }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 return driver;
	 }
	 @BeforeMethod(alwaysRun=true)
	 public LandingPage launchApplication() throws IOException
	 {
		 driver=initializeDriver();
			lp=new LandingPage(driver);
			lp.goTo();
			return lp;	 
}
	 @AfterMethod(alwaysRun=true)
	 public void close()
	 {
		 driver.close();
	 }
	 public String getScreenShot(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			File targete=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
			 FileUtils.copyFile(source,targete);
			 //return System.getProperty(".//screenshots//Demo2.png");
			 return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
				
		}
}
