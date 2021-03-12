package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold 
		{ 
		 public static void main(String[] args) 
		 { 
			 
			 System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\driverDependencies\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver(); 
		   driver.manage().window().maximize(); 
		  String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html"; 
		  driver.get(url); 

		// Locate the element C by By.xpath. 
		  WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']")); 
		  
		  ////span[contains(text(),'Back')]
		// Create an object of actions class and pass reference of WebDriver as a parameter to its constructor. 
		   Actions actions = new Actions(driver); 
		// Move the cursor to the position of element C. 
		   actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation. 
		   actions.clickAndHold().perform(); 
		  } 
		}