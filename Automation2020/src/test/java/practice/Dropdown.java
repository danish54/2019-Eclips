package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {

	public static WebDriver driver;

	@BeforeMethod
	public void openbrowser() {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driverDependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://demoqa.com/select-menu";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void dropdown1() {
		Select se = new Select(driver.findElement(By.xpath("//*[@id='oldSelectMenu']")));
		// Select the option by index
		se.selectByIndex(3);
	}

	@Test(enabled = false)
	public void dropdown2() throws InterruptedException {
		WebElement el = driver.findElement(By.xpath("//div[contains(text(),'Select Option')]"));
		
		////*[@id="react-select-2-option-0-1"]
		////*[@id="react-select-2-option-0-1"]
		////*[@id="react-select-2-option-0-0"]
		////*[@id="react-select-2-option-1-0"]
		////*[@id="react-select-2-option-1-1"]
		
		el.click();
		Actions key = new Actions(driver);
		key.moveToElement(el).perform();
		/*Thread.sleep(3000);
		key.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();*/
	}

	@Test(enabled = true)
	public void JsDropdown() throws InterruptedException {
		Actions key = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("//div[contains(text(),'Select Option')]"));
		Thread.sleep(2000);
		key.moveToElement(el).perform();
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("//*[@id='react-select-2-option-0-1']")).click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Hello "+e.toString());
		}
		
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
