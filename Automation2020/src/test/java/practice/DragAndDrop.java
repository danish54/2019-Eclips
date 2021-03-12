package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driverDependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,300)");
		
		Actions act = new Actions(driver);
		
		WebElement drag = driver.findElement(By.xpath("//li[text()= 'A']"));
		
		WebElement drop = driver.findElement(By.xpath("//li[text()= 'L']"));
		
		act.dragAndDrop(drag, drop).perform();
	}

}
