package luxeregister;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class baseclassluxe {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	
	
	// Setup Browser
	public void Setup() throws IOException {

		// loading config properties

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		config.load(fis);

		// loading OR properties
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);

		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ACER.NITRO 5\\Downloads\\eclipse\\workspace\\dependencies\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	// Login method with hardcode locators
	public void loginhrd() throws IOException {

		baseclassluxe base = new baseclassluxe();
		
		
		base.Setup();
		driver.get("https://dev.theluxeregister.com/");

		/*
		 * boolean Ele = base.isElementPresent(driver,
		 * By.className("nav-link sign-in-btn"));
		 * 
		 * if (Ele==true) {
		 * driver.findElement(By.className("nav-link sign-in-btn")).click(); }
		 */

		
		driver.findElement(By.className("nav-link sign-in-btn")).click();
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

	
	//login method with OR properties
	public void loginOR() throws IOException, InterruptedException {

		baseclassluxe base = new baseclassluxe();

		base.Setup();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getProperty("baseurl"));
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(config.getProperty("username"));
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(config.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id(OR.getProperty("login_button_id"))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}


	
	//screenshot first method using FileUtils
	public void captureSnapShot() throws IOException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		File ssFile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ssFile, new File(
				"E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\" + sdf.format(d) + ".jpg"));
	}
	
	//screenshot third method using FileHandler
	public void getScreenShot() {
	      try {
	            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            //The below method will save the screen shot in destination directory with name "screenshot.png"
	             FileHandler.copy(scrFile, new File("D:/reports/screenshot.png"));
	         } catch (IOException e) {
	             e.printStackTrace();
	            }
	  }
	
	
	
	
	//CLosing method
	public void Close() {

		driver.quit();
	}

}
