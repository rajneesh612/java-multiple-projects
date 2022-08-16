package alerts_in_selenium;

import org.testng.annotations.Test;

import parallel_processing_Listner.Browser_Utility;

import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Alert_test {
  @Test(priority =1)
  public void test_accept() {
	  WebDriver driver = Browser_Utility.browser_setting("Chrome");
	  //System.out.println(" test1 chrome");
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  WebElement alert_button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  alert_button.click();
	//Wait for the alert to be displayed and store it in a variable
	  WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	  //Store the alert text in a variable
	  String text = alert.getText();
	  
	  System.out.println("text :" +text);

	  //Press the OK button
	  alert.accept();
	  //driver.close();
	  
	
  }
  
  @Test(priority=2)
  public void test_dismiss() {
	  WebDriver driver = Browser_Utility.browser_setting("Chrome");
	  //System.out.println(" test1 chrome");
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  //WebElement alert_button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  //alert_button.click();
	  
	  driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	//Wait for the alert to be displayed and store it in a variable
	  WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	  //Store the alert text in a variable
	  String text = alert.getText();
	  
	  System.out.println("text :" +text);

	  //Press the OK button
	  alert.dismiss();
	 // driver.close();
  }
  
  @Test(priority=3)
  public void test_confirm_dimiss() {
	  WebDriver driver = Browser_Utility.browser_setting("Chrome");
	  //System.out.println(" test1 chrome");
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  //WebElement alert_button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  //alert_button.click();
	  
	  WebElement alert_button=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
	  alert_button.click();
	//Wait for the alert to be displayed and store it in a variable
	  WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	  //Store the alert text in a variable
	  String text = alert.getText();
	  
	  System.out.println("text :" +text);

	  //Press the OK button
	  alert.dismiss();
	 // driver.close();
  }
  
  
  @Test(priority=4)
  public void test_confirm_accept() {
	  WebDriver driver = Browser_Utility.browser_setting("Chrome");
	  //System.out.println(" test1 chrome");
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  //WebElement alert_button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  //alert_button.click();
	  
	  WebElement alert_button=driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
	  alert_button.click();
	//Wait for the alert to be displayed and store it in a variable
	  WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	  //Store the alert text in a variable
	  String text = alert.getText();
	  
	  System.out.println("text :" +text);

	  //Press the OK button
	  alert.accept();
	 // driver.close();
  }
  
  
  @Test(priority=5)
  public void test_confirm_prompt_accept() {
	  WebDriver driver = Browser_Utility.browser_setting("Chrome");
	  //System.out.println(" test1 chrome");
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  //WebElement alert_button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  //alert_button.click();
	  
	  WebElement alert_button=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
	  alert_button.click();
	//Wait for the alert to be displayed and store it in a variable
	  WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	  //Store the alert text in a variable
	  String text = alert.getText();
	  
	  System.out.println("text :" +text);

	  //Press the OK button
	  alert.accept();
	 // driver.close();
  }
  
  
  @Test(priority=6)
  public void test_confirm_prompt_dismiss() {
	  WebDriver driver = Browser_Utility.browser_setting("Chrome");
	  //System.out.println(" test1 chrome");
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  //WebElement alert_button =driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	  //alert_button.click();
	  
	  WebElement alert_button=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
	  alert_button.click();
	//Wait for the alert to be displayed and store it in a variable
	  WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	  driver.switchTo().alert();

	  alert.sendKeys("xyz");

	  //Store the alert text in a variable
	  String text = alert.getText();
	  
	  System.out.println("text :" +text);

	  //Press the OK button
	  alert.dismiss();
	  //driver.close();
  }
  
  
  
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
