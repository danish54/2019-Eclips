package luxeregister;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class roughclass {
	
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell Cell;
	
	
		
	
	
@Test
public void testdatapro() throws IOException {
	
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\Test_Data3.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

		int row = sheet.getLastRowNum();
		System.out.println("Total Row Count" + row);


		for (int i = 1; i <= row; i++) {

			Cell = sheet.getRow(i).getCell(1);
			Cell.setCellType(CellType.STRING);
			String username = Cell.getStringCellValue();

//			XSSFCell username = sheet.getRow(i).getCell(1);
//			XSSFCell password = sheet.getRow(i).getCell(2);
			
			Cell = sheet.getRow(i).getCell(2);
			Cell.setCellType(CellType.STRING);
			String password = Cell.getStringCellValue();

			System.out.println("UserName  = " +username +  "    Password = "+ password );
		}
		

	}



}
