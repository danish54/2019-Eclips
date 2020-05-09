package luxeregister;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentManager;
public class baseclassluxe {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	public ExtentReports rep = (ExtentReports) ExtentManager.getInstance();
	public static ExtentTest test;

	static WebDriverWait wait;
	public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("devpinoylogger");
	
	
	
	// Setup Browser
	public static void Setup() throws IOException {


		// loading config properties

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driverDependencies\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get(config.getProperty("baseurl"));
		wait = new WebDriverWait(driver, 30);
		driver.findElement(By.xpath(OR.getProperty("SigninlinkXpath"))).click();
	}

	// Login method with hardcode locators
	public void loginhrd() throws IOException {

		baseclassluxe.Setup();

		driver.findElement(By.id("userEmail")).sendKeys("danish.ali@hipster-inc.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.xpath("//a[@class='btn dark-btn sign-btn']")).click();

	}

	// is Element Present Method
	public boolean isElementPresent(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			driver.findElement(by);
			return true;
		}

		catch (Exception e)

		{

			return false;
		}

		finally {

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	// login method with OR properties
	public void loginOR() throws IOException, InterruptedException {

		baseclassluxe.Setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getProperty("baseurl"));
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id(OR.getProperty("login_button_id"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	

	// CLosing method
	public void Close() {

		driver.quit();
	}

}
