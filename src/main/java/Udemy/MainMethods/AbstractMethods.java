package Udemy.MainMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Udemy.PageObjects.OrderPage;



public class AbstractMethods {
 WebDriver driver;
	
	 //driver.findElement(By.xpath("//*[text()='  Cart ']")).click();
	@FindBy(xpath="//*[text()='  Cart ']") WebElement CartHomePage;
	@FindBy(xpath="//*[text()='  ORDERS']") WebElement orderHeader;
	public AbstractMethods(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void waitForElementToAppear(By findBy)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	      wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToAppear(WebElement findBy)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	      wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void gotoCart()
	{
		CartHomePage.click();
		
	}
	public OrderPage gotoOrderPage()
	{
		orderHeader.click();
		OrderPage ap=new OrderPage(driver);
		return ap;
		
	}

}
