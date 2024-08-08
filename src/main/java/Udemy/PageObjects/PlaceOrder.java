package Udemy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Udemy.MainMethods.AbstractMethods;

public class PlaceOrder extends AbstractMethods {
	public WebDriver driver;
	public PlaceOrder(WebDriver driver)
  {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
  }
  @FindBy(xpath="//*[@placeholder='Select Country']") WebElement clkcountry;
  @FindBy(xpath="//*[text()='Place Order ']") WebElement plcebtn;
  @FindBy(xpath="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]") WebElement selectC;
  By result=By.xpath("//*[@class='ta-results list-group ng-star-inserted']") ;
  public void selectCountry(String countryName)
  {
	  Actions a=new Actions(driver);
	  a.sendKeys(clkcountry,countryName).build().perform();
	  waitForElementToAppear(result);
	  selectC.click();
	  
  }
  public ConfirmationPage submitOrder()
  {
	  plcebtn.click();
	  ConfirmationPage co=new ConfirmationPage(driver);
	  return co;
  }
}
