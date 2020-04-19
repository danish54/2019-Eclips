package newcms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newcms_base {

	public WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;


	
	
	public void openbrowseold() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER.NITRO 5\\eclipse-workspace\\newcms\\src\\test\\resources\\browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	
	public void openBrowser() throws IOException {

		// loading config properties

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);

		// instentiating browser

		driver = null;
		WebDriverManager.getInstance(CHROME).setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void login() throws IOException, InterruptedException {

		newcms_base base = new newcms_base();

		base.openBrowser();
		base.driver.get(config.getProperty("baseurl"));
		base.driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		base.driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		base.driver.findElement(By.id(OR.getProperty("login_button_id"))).click();
		
		Thread.sleep(2000);
		
		base.driver.findElement(By.className(OR.getProperty("dropdown"))).click();
		//base.driver.findElement(By.partialLinkText(OR.getProperty("My Subjects"))).click();
		
		
		
		//base.driver.quit();

	}

}