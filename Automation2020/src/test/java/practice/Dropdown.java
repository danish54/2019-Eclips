package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@Test
	public void dropdown2() throws InterruptedException {
		WebElement el = driver.findElement(By.xpath("//div[contains(text(),'Select Option')]"));
		el.click();
		Actions key = new Actions(driver);
		key.moveToElement(el).click().perform();
		Thread.sleep(3000);
		key.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
