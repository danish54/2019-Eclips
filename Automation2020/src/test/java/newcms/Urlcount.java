package newcms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class Urlcount {
	
	
	public WebDriver driver;
	
	
	
	
	@Test
	public void UrlcountM() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER.NITRO 5\\eclipse-workspace\\newcms\\src\\test\\resources\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
		WebElement firstcoldriver= footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(firstcoldriver.findElements(By.tagName("ul")).size());
		
		
		Thread.sleep(5000L);
		driver.quit();
	}
	

}
