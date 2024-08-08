package RahulShetty.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AppTest {

	public static void main(String[] args) throws InterruptedException {

      WebDriver driver=new FirefoxDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      driver.get("https://rahulshettyacademy.com/client/");
      driver.findElement(By.id("userEmail")).sendKeys("roopasidnal@gmail.com");
      driver.findElement(By.id("userPassword")).sendKeys("Sidnal@123");
      driver.findElement(By.id("login")).click();
      
      System.out.println("successfully loged in");
      driver.findElement(By.xpath("/html/body/app-root/app-dashboard/section[2]/div[1]/div[2]/div[1]/div/div/button[1]")).click();
      driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
      Thread.sleep(5);
      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
      System.out.println("pass");
      
      driver.findElement(By.xpath("//*[text()='  Cart ']")).click();  
      String expected="ZARA COAT 3";
      String actual = driver.findElement(By.xpath("//*[text()='ZARA COAT 3']")).getText();
      Assert.assertEquals(expected, actual);
      
      driver.findElement(By.xpath("//*[text()='Checkout']")).click();
      Actions a= new Actions(driver);
      a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")),"India").build().perform();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ta-results list-group ng-star-inserted']")));
      driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button[2]")).click();
      driver.findElement(By.xpath("//*[text()='Place Order ']")).click();
      
     String actual1 = driver.findElement(By.xpath("//*[text()=' Thankyou for the order. ']")).getText();
     Assert.assertTrue(actual1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
     
     driver.close();
	}
}
