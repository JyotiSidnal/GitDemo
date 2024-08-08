package Udemy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Udemy.MainMethods.AbstractMethods;

public class CheckOut extends AbstractMethods{
	public WebDriver driver;
	public CheckOut(WebDriver driver)
  {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
  }
  @FindBy(xpath="//*[text()='ZARA COAT 3']") WebElement verifyprod;
  @FindBy(xpath="//*[text()='Checkout']") WebElement gotocheckout;
  
  public String verifyproduct( )
  {
	  return verifyprod.getText();
//    String actual= verifyprod.getText();
//	return actual;
  }
  public PlaceOrder checkout()
  {
	  gotocheckout.click();
	  PlaceOrder po=new PlaceOrder(driver);
	  return po;
  }

}
