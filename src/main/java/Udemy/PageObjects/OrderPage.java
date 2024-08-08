package Udemy.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Udemy.MainMethods.AbstractMethods;

public class OrderPage extends AbstractMethods {
	public WebDriver driver;
	public OrderPage(WebDriver driver)
  {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
  }
//  @FindBy(xpath="//*[text()='ZARA COAT 3']") WebElement verifyprod;
//  @FindBy(xpath="//*[text()='Checkout']") WebElement gotocheckout;
  @FindBy(css="tr td:nth-child(3)")
  private List<WebElement> productNames;
  
  public Boolean verifyOrderDisplay(String productName)
  {
	  Boolean match=productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
	  return match;
  }
 

}
