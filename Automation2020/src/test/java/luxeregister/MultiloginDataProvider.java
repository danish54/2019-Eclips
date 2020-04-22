package luxeregister;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Xls_Reader;

public class MultiloginDataProvider {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@Test(dataProvider = "testdata")
	public void multilogindataprovider(String username, String password) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driverDependencies\\chromedriver.exe");

		driver = new ChromeDriver();

		// Enter url.

		driver.manage().window().maximize();
		driver.get("https://dev.theluxeregister.com/");

		// navigate to login page
		driver.findElement(By.xpath("//a[@class='nav-link sign-in-btn']")).click();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("userEmail")).clear();
		driver.findElement(By.id("userEmail")).sendKeys(username);
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.findElement(By.xpath("//a[@class='btn dark-btn sign-btn']")).click();
		Thread.sleep(4000L);
		
		Assert.assertTrue(!driver.getCurrentUrl().matches("https://dev.theluxeregister.com/profile"), "Login Unsuccessfull");
		System.out.println("Login Successfull");
	}

	
	
	@DataProvider(name= "testdata")
		
		public Object[][] testdatafeed(){
		
		Xls_Reader config = new Xls_Reader(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\Test_Data.xlsx");
		
		int rows = config.getColumnCount("sheet1");
		
		Object[][] credential = new Object[rows][2];
		
		for(int i=1; i<rows; i++) {
			
			credential[i][1] = config.getCellData("sheet1", i, 1);
			credential[i][2] = config.getCellData("sheet1", i, 2);
		}
			
			return credential;
		}
	
}
