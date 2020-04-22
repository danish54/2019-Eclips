package luxeregister;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultiLoginExecl {

	public static WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@BeforeTest
	public void TestSetup() {
		// Set the path of the Chrome driver.
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
	}

	@Test
	public void ReadData() throws IOException, InterruptedException {
		// Import excel sheet.
		File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\TestData2.xlsx");

		// Load the file.
		FileInputStream finput = new FileInputStream(src);

		// Load he workbook.
		workbook = new XSSFWorkbook(finput);

		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		System.out.println("Number of Rows" + sheet.getLastRowNum());
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			// Import data for Email.
			Thread.sleep(2000L);
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.id("userEmail")).clear();
			driver.findElement(By.id("userEmail")).sendKeys(cell.getStringCellValue());

			// Import data for password.
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(cell.getStringCellValue());

			driver.findElement(By.xpath("//a[@class='btn dark-btn sign-btn']")).click();
			Thread.sleep(4000L);

			String URL = driver.getCurrentUrl();

			if (URL.equalsIgnoreCase("https://dev.theluxeregister.com/profile")) {

				System.out.println("Login Successful");

				driver.findElement(By.xpath("//li[@class='li-pr2 active-menu']")).click();
				Thread.sleep(3000L);
				driver.findElement(By.xpath("//button[@class='profile-log-out']")).click();
				Thread.sleep(3000L);
				// Write data in the excel.
				FileOutputStream foutput = new FileOutputStream(src);

				// Specify the message needs to be written.

				String message = "Login Successful.";

				// Create cell where data needs to be written.
				sheet.getRow(i).createCell(3).setCellValue(message);

				// finally write content
				workbook.write(foutput);

				// close the file
				foutput.close();
				Thread.sleep(2000L);

			}

			else {

				System.out.println("Login Failed");

				// Write data in the excel.
				FileOutputStream foutput = new FileOutputStream(src);

				// Specify the message needs to be written.
				System.out.println("Login Failed");
				String message = "Login Failed.";

				// Create cell where data needs to be written.
				sheet.getRow(i).createCell(3).setCellValue(message);

				// finally write content
				workbook.write(foutput);

				// close the file
				foutput.close();

			}

		}
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
