package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driverDependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		String URL = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
		 
		 driver.get(URL);
		 
		 // It is always advisable to Maximize the window before performing DragNDrop action 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 JavascriptExecutor js = (JavascriptExecutor)driver; 
			js.executeScript("window.scrollBy(0,300)");
			
			//((JavascriptExecutor) driver).executeScript("scroll(0,300)");
		 
		 //Actions class method to drag and drop 
		 Actions builder = new Actions(driver);
		 
		 WebElement from = driver.findElement(By.xpath("//li[text()= 'A']"));
		 
		 //Perform dragAndDropBy 
		 builder.dragAndDropBy(from, 100,100).perform(); 
		 

	}

}
