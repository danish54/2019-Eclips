package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropdown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driverDependencies\\chromedriver.exe");

		//Open Browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Login
		driver.get("https://development.first-hold.net/login");
		driver.findElement(By.name("email")).sendKeys("testvenue8@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		
		//Clicking on +Add Venue
		driver.findElement(By.xpath("//span[contains(text(),'+ Add Venue')]")).click();
		
		//Clicking on Select
		driver.findElement(By.id("select-venueType")).click();
		
		//Selecting Value from Dropdown
		driver.findElement(By.xpath("//li[contains(text(),'Boat / Yacht')]")).click();
		
	}

}
