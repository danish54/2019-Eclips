package newcms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Static_Page {
	
	WebDriver driver;
	
	@Test
	public void openbrowser() {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER.NITRO 5\\eclipse-workspace\\newcms\\src\\test\\resources\\browser\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://dev.tueetor.com/");
}}
