package RahulShetty.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import RahulShetty.TestComponents.BaseTest;
import Udemy.PageObjects.CheckOut;
import Udemy.PageObjects.ConfirmationPage;
import Udemy.PageObjects.OrderPage;
import Udemy.PageObjects.PlaceOrder;
import Udemy.PageObjects.ProductCatalog;
import junit.framework.Assert;

public class SubmitOrderTest extends BaseTest {
	String expected="ZARA COAT 3";
	@Test(dataProvider="method",groups= {"purchase"})
	public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException 
	{
		System.out.println("Brwoser launched");

//		WebDriver driver=new FirefoxDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
//		LandingPage lp=new LandingPage(driver);
//		lp.goTo();
		//LandingPage lp=launchApplication();
		ProductCatalog p=lp.loginApplication(input.get("email"),input.get("password"));
	//	ProductCatalog p=new ProductCatalog(driver);
		CheckOut c=p.Addcart();
	             p.gotoCart();//parent calss methos directly calling here
		
	    //String expected="ZARA COAT 3";
	//	CheckOut c=new CheckOut(driver);
		String match=c.verifyproduct();
		Assert.assertEquals(expected, match);
		PlaceOrder po=c.checkout();
	     po.selectCountry("India");
	     ConfirmationPage co=po.submitOrder();
	    String actual1= co.getConfirmationMsg();
	    Assert.assertTrue(actual1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));     		
	}
	@Test(dependsOnMethods= {"submitorder"})
	public void orderhistoryTest()
	{
		ProductCatalog p=lp.loginApplication("roopasidnal@gmail.com", "Sidnal@123");
	    OrderPage orderpage	=p.gotoOrderPage();
	    Assert.assertTrue(orderpage.verifyOrderDisplay(expected));
	}
	
	
//	@DataProvider(name="dataset")
	
//	public Object[][] method(){
//		return new Object[][] {
//			{"roopasidnal@gmail.com","Sidnal@123"},
//			//{"jyosidnal@gmail.com","Sidnal@123"}
//		};
//	}
	@DataProvider
	public Object[][] method()
	{ 
     HashMap<String,String> map=new HashMap<String,String>();
     map.put("email","roopasidnal@gmail.com" );
     map.put("password","Sidnal@123");
     
//     HashMap<String,String> map1=new HashMap<String,String>();
//     map.put("email","jyotisidnal@gmail.com" );
//     map.put("password","Sidnal@123");
     
     return new Object[][] {{map}};
	}
}

