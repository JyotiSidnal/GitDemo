package Udemy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Udemy.MainMethods.AbstractMethods;

public class LandingPage extends AbstractMethods {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
  {
    super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
  }
	@FindBy(id="userEmail") WebElement user;
	@FindBy(id="userPassword") WebElement userpswrd;
	@FindBy(id="login") WebElement btn;
	//#toast-container
	@FindBy(css="#toast-container") WebElement errorMsg;
	
	public ProductCatalog loginApplication(String un,String pswrd) 
	{
		user.sendKeys(un);
		userpswrd.sendKeys(pswrd);
		btn.click();
		ProductCatalog p=new ProductCatalog(driver);
		return p;		
	}
	public String getError()
	{
		waitForElementToAppear(errorMsg);
		return errorMsg.getText();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
