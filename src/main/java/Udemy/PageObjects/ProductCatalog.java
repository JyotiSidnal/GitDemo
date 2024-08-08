package Udemy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Udemy.MainMethods.AbstractMethods;

public class ProductCatalog extends AbstractMethods {
	public WebDriver driver;
	public ProductCatalog(WebDriver driver)
  {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
  }
  @FindBy(xpath="/html/body/app-root/app-dashboard/section[2]/div[1]/div[2]/div[1]/div/div/button[1]") WebElement prod;
  @FindBy(xpath="//button[text()='Add to Cart']") WebElement cart;
 By waits= By.id("toast-container");
  
  public CheckOut Addcart() throws InterruptedException
  {
	  prod.click();
	  Thread.sleep(3000);
	  cart.click();
	  waitForElementToAppear(waits);
	  System.out.println("pass");
	  CheckOut c=new CheckOut(driver);
	  return c;
  }
}
