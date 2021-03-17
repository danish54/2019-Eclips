package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class shawafts {
	
	
	public static WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void openbrowser() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driverDependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://shawafts.github.io/test-page");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		
	}
		
	@Test(enabled = true, priority = 1)
		public void test1()
		{
			driver.findElement(By.id("normalDivButton")).click();
			WebElement e1 = driver.findElement(By.id("normalDiv"));
			Assert.assertEquals(true, e1.isDisplayed());
		}
	
	@Test(enabled = true, priority = 2)
		public void test2()
		{
		    
			driver.findElement(By.id("delayedDivButton")).click();
			WebElement e2 = driver.findElement(By.id("delayedDiv"));
			wait.until(ExpectedConditions.visibilityOf(e2));
			Assert.assertEquals(true, e2.isDisplayed());
		}
		
	@Test(enabled = true, priority = 3)
		public void test3()
		{
		     
		WebElement e4 =	driver.findElement(By.id("modalDivButton"));
		wait.until(ExpectedConditions.visibilityOf(e4));
		e4.click();
		
			WebElement e3 = driver.findElement(By.className("modal-content"));
			wait.until(ExpectedConditions.visibilityOf(e3));
			Assert.assertEquals(true, e3.isDisplayed());
		}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
