package luxeregister;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class roughloginclass {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell Cell;

	@Test
	public Object[][] testdatafeed() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\Testdata1.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);

		int row = sheet.getLastRowNum();
		System.out.println("Total Row Count" + row);
		Object[][] credential = new Object[row][2];

		for (int i = 1; i <= row; i++) {

			Cell = sheet.getRow(i).getCell(1);
			Cell.setCellType(CellType.STRING);
			credential[i][0] = Cell.getStringCellValue();

			Cell = sheet.getRow(i).getCell(2);
			Cell.setCellType(CellType.STRING);
			credential[i][1] = Cell.getStringCellValue();

		}
		return credential;
	}

	
}
