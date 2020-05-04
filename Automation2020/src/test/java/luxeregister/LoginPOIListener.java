package luxeregister;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPOIListener extends baseclassluxe {
 
	

	
	
	WebDriverWait wait;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell Cell;

	@BeforeMethod
	public void BrowserSetup() throws IOException {
		
		
		baseclassluxe.Setup();

		
	}

	@DataProvider(name = "testdata")
	public Object[][] testdatafeed() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\Testdata1.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

		int row = sheet.getLastRowNum();
		System.out.println("Total Row Count" + row);
		Object[][] credential = new Object[row][2];

		for (int i = 0; i< row; i++) {

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

		Thread.sleep(2000L);
		
		driver.findElement(By.id(OR.getProperty("username_id"))).clear();
		driver.findElement(By.id(OR.getProperty("username_id"))).sendKeys(username);

		driver.findElement(By.id(OR.getProperty("password_id"))).clear();
		driver.findElement(By.id(OR.getProperty("password_id"))).sendKeys(password);
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath(OR.getProperty("loginsumbit_button_xpath"))).click();
		Thread.sleep(2000L);

		Assert.assertTrue(driver.getCurrentUrl().matches("https://dev.theluxeregister.com/profile"),"Login Successfull");
		System.out.println("Login Successfull");

	}

	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}

}
