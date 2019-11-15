package introduction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class oranghover {
	 WebDriver driver;
	@Test(priority=1)
	public void openbrowser() throws InterruptedException {
		 
		  
		 System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32_2\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		 driver.get("https://opensource-demo.orangehrmlive.com/");
		 driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		 driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	
	@Test(priority=2)
	public void hoverclick() throws InterruptedException {
		
        List<WebElement> elements = driver.findElements(By.tagName("a"));
		
		System.out.println("No of dropdown = "+elements.size()+elements );
		
		Actions action = new Actions(driver);
		WebElement elem = driver.findElement(By.id("menu_admin_viewAdminModule"));
		action.moveToElement(elem);
		action.perform();
		Thread.sleep(2000);
		
		WebElement elem1 = driver.findElement(By.id("menu_admin_UserManagement"));
		action.moveToElement(elem1);
		action.perform();
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Users")).click();
	}
	
}
