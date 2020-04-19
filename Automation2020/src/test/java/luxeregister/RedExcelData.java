package luxeregister;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RedExcelData {
	
	public static void main(String[] args) throws Exception{

        ArrayList data = new ArrayList();

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Excel_Data\\Test_Data.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet s = book.getSheet("Sheet1");

    Iterator itr = s.iterator();
    while (itr.hasNext()) {
        Row rowitr = (Row) itr.next();
        Iterator cellitr = rowitr.cellIterator();
        while(cellitr.hasNext()) {
            Cell celldata = (Cell) cellitr.next();

            switch(celldata.getCellType()) {
            case STRING:
                data.add(celldata.getStringCellValue());
                break;
            case NUMERIC:
                data.add(celldata.getNumericCellValue());
                break;
            case BOOLEAN:
                data.add(celldata.getBooleanCellValue());
                break;
            }
        }
    }

    for (int i=0;i<data.size();i++) {
        if(data.get(i).equals("zehra")) {
            System.out.println(data.get(i));
            System.out.println(data.get(i+1));
            System.out.println("*************");            
        }
        
        if(data.get(i).equals("manisha")) {
            System.out.println(data.get(i));
            System.out.println(data.get(i+1));
            System.out.println("*************");
        }
            if(data.get(i).equals("kratika")) {
                System.out.println(data.get(i));
                System.out.println(data.get(i+1));
                System.out.println("*************");
            }
}       
}
	

}
