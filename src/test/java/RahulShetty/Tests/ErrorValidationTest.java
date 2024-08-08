package RahulShetty.Tests;

import org.testng.annotations.Test;

import RahulShetty.TestComponents.BaseTest;
import Udemy.PageObjects.CheckOut;
import Udemy.PageObjects.ProductCatalog;
import junit.framework.Assert;

public class ErrorValidationTest extends BaseTest{
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation()
	{
		 String expected="ZARA COAT 3";
		lp.loginApplication("roopasidnal@gmail.com", "0");
		Assert.assertEquals("Incorrect email or password.",lp.getError());
	}
	@Test
	public void ProductErrorValidation() throws InterruptedException
	{

	    String expected="ZARA COAT 3";
		ProductCatalog p=lp.loginApplication("roopasidnal@gmail.com", "Sidnal@123");
	//	ProductCatalog p=new ProductCatalog(driver);
		CheckOut c=p.Addcart();
	             p.gotoCart();//parent calss methos directly calling here
		String match=c.verifyproduct();
		Assert.assertEquals(expected, match);
		System.out.println("pass");
		
	}
	
	

}
