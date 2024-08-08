package Udemy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Udemy.MainMethods.AbstractMethods;

public class ConfirmationPage extends AbstractMethods {
	public WebDriver driver;
	public ConfirmationPage(WebDriver driver)
  {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
  }
  @FindBy(xpath="//*[text()=' Thankyou for the order. ']") WebElement confirmationMsg;
  public String getConfirmationMsg()
  {
	  return confirmationMsg.getText();
  }
}
