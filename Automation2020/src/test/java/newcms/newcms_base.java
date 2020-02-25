package newcms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newcms_base {

	public WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	@Test
	public void openBrowser() throws IOException {

		// loading config properties

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Properties\\config.properties");
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\Properties\\OR.properties");
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
	public void login() throws IOException {

		newcms_base base = new newcms_base();

		base.openBrowser();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getProperty("baseurl"));
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id(OR.getProperty("login_button_id"))).click();

	}

}