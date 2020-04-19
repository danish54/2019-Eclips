package luxeregister;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkCountTest extends baseclassluxe {
	
	baseclassluxe base = new baseclassluxe();
	
	int count =-1;
	
	@Test
	public void operation() throws IOException, InterruptedException {

		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: " + list.size());
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i).isDisplayed()) 
			  {
				count++;

				System.out.println(list.get(i).getText());
				String url = list.get(i).getText();
				
				FileInputStream inputStream = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\excel\\visblelinkURL1.xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(inputStream);
				
				XSSFSheet s = wb.getSheet("Sheet1");
				XSSFRow row = s.createRow(count);
				row.createCell(0).setCellValue(url);
				FileOutputStream outputStream = new FileOutputStream(
						System.getProperty("user.dir") + "\\src\\excel\\visblelinkURL1.xlsx");
				wb.write(outputStream);


			}

		}

		int total = list.size();
		int hidden = (total - count);
		System.out.println("No of hidden link=" + hidden);
		System.out.println("No of total link=" + total);
		System.out.println("No of visible link=" + count);
        
		
		
	   
	
	}

}
