package luxeregister;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class login  {
	
	public static WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\driverDependencies\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://dev.theluxeregister.com/");
	    
	    
	    //navigate to login page
	    driver.findElement(By.xpath("//a[@class='nav-link sign-in-btn']")).click();
	    wait = new WebDriverWait(driver,30);
	    driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("danish.ali@hipster-inc.com");
        
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("123456789");
        
        driver.findElement(By.xpath("//a[@class='btn dark-btn sign-btn']")).click();
        Thread.sleep(3000L);

        driver.findElement(By.xpath("//li[@class='li-pr2 active-menu']")).click();
        driver.findElement(By.xpath("//button[@class='profile-log-out']")).click();
       
    	  
     
	
	}
	
	
	
}
