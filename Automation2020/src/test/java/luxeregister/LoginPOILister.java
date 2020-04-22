package luxeregister;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPOILister {

	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell Cell;

	@BeforeMethod
	public void BrowserSetup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ACER.NITRO 5\\Downloads\\eclipse\\workspace\\dependencies\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@DataProvider(name = "testdata")
	public Object[][] testdatafeed() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\Test_Data4.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

		int row = sheet.getLastRowNum();
		Object[][] credential = new Object[row][2];

		for (int i = 1; i < row; i++) {

			Cell = sheet.getRow(i).getCell(1);
			Cell.setCellType(CellType.STRING);
			credential[i][0] = Cell.getStringCellValue();

			Cell = sheet.getRow(i).getCell(2);
			Cell.setCellType(CellType.STRING);
			credential[i][1] = Cell.getStringCellValue();

		}
		return credential;

	}

	@Test(dataProvider = "testdata")
	public void logintest(String username, String password) throws InterruptedException {

		
		driver.get("https://dev.theluxeregister.com/");
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		// navigate to login page
		driver.findElement(By.xpath("//a[@class='nav-link sign-in-btn']")).click();
		Thread.sleep(2000L);
		
		driver.findElement(By.id("userEmail")).clear();
		driver.findElement(By.id("userEmail")).sendKeys(username);

		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//a[@class='btn dark-btn sign-btn']")).click();
		Thread.sleep(2000L);

		Assert.assertTrue(driver.getCurrentUrl().matches("https://dev.theluxeregister.com/profile"),"Login Successfull");
		System.out.println("Login Successfull");

	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

}
