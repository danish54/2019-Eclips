package introduction;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bjpnoelection
{
WebDriver driver;
WebElement element;
org.openqa.selenium.support.ui.Select s;
@BeforeTest
public void openapp()
{ 
 System.setProperty("webdriver.chrome.driver","C:\\Users\\Danish\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
 driver=new ChromeDriver();
 driver.manage().window().maximize();
 driver.get("https://voiceey.com/sadasytaparvoffline/enters/login");
 
 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);   

}

@Test
public void operation() throws InterruptedException, IOException
{

driver.findElement(By.xpath("//input[@id='lgId']")).clear();
driver.findElement(By.xpath("//input[@id='lgId']")).sendKeys("bjpoffline");

driver.findElement(By.xpath("//input[@id='lgPwd']")).clear();
driver.findElement(By.xpath("//input[@id='lgPwd']")).sendKeys("bjpoffline@123");

driver.findElement(By.xpath("//button[contains(@class,'btn-block')]")).click();

driver.findElement(By.xpath("//input[@id='name']")).clear();
driver.findElement(By.xpath("//input[@id='name']")).sendKeys("lko");

driver.findElement(By.xpath("//input[@id='mobile']")).clear();
driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("7379600001");

driver.findElement(By.xpath("//button[@class='btn btn-md pull-left submitForm']")).click();

FileInputStream fso=new FileInputStream("C:\\Users\\Danish\\Desktop\\BJPWORK.xlsx");

@SuppressWarnings("resource")
XSSFWorkbook wb=new XSSFWorkbook(fso);
XSSFSheet xs=wb.getSheet("Sheet1");

for(int i=334; i<=2000; i++)
{



Row r=xs.getRow(i);
long mobile= (long) r.getCell(0).getNumericCellValue();
if(mobile==0) {
	break;
}
String mob=Long.toString(mobile);
System.out.println("mob"+mob);


String name=r.getCell(2).getStringCellValue();

String address=r.getCell(3).getStringCellValue();


long Pincode=(long) r.getCell(4).getNumericCellValue();

String pin=Long.toString(Pincode);


String State=r.getCell(5).getStringCellValue();

String District=r.getCell(6).getStringCellValue();

String Loksabha=r.getCell(7).getStringCellValue();

String Vidhansabha=r.getCell(8).getStringCellValue();

String Mandal=r.getCell(9).getStringCellValue();

String SaktiKendra=r.getCell(10).getStringCellValue();

long BoothNumber=(long) r.getCell(11).getNumericCellValue();

String bootno=Long.toString(BoothNumber);

String RefferedBy=r.getCell(12).getStringCellValue();


long MobileNumber=(long) r.getCell(13).getNumericCellValue();

String mno=Long.toString(MobileNumber);






 
			 {  
//driver.navigate().refresh();
System.out.println("PASS");
r.createCell(14).setCellValue("PASS");
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='RegistrationExistingmember0']")).click();
System.out.println("Clicked on radio button");

driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(mob);
driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);

driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);

driver.findElement(By.xpath("//input[@id='pincode']")).sendKeys(pin);

element=driver.findElement(By.xpath("//select[@id='state_id']"));
s=new org.openqa.selenium.support.ui.Select(element);

s.selectByVisibleText(State);
waitUnitlSelectOptionsPopulated(s);

driver.findElement(By.xpath("//input[@id='district']")).sendKeys(District);

element=driver.findElement(By.xpath("//select[@id='loksabha_id']"));
s=new org.openqa.selenium.support.ui.Select(element);
s.selectByVisibleText(Loksabha);
waitUnitlSelectOptionsPopulated(s);

element=driver.findElement(By.xpath("//select[@id='ac_id']"));
s=new org.openqa.selenium.support.ui.Select(element);
s.selectByVisibleText(Vidhansabha);
waitUnitlSelectOptionsPopulated(s);
driver.findElement(By.xpath("//input[@id='mandal']")).sendKeys(Mandal);



driver.findElement(By.xpath("//input[@id='shaktikendra']")).sendKeys(SaktiKendra);

driver.findElement(By.xpath("//input[@id='boothno']")).sendKeys(bootno);

driver.findElement(By.xpath("//input[@id='ref_name']")).sendKeys(RefferedBy);

driver.findElement(By.xpath("//input[@id='ref_mobile']")).sendKeys(mno);  



element=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/form[1]/div[2]/div[6]/div[15]/div[1]/label[1]"));
System.out.println(element.getText());

//String s1=element.getText();   
String[] substr = element.getText().split(" ");
int ss=Integer.parseInt(substr[2]);
int s2=Integer.parseInt(substr[4]);
int sum=ss+s2;
String som=Integer.toString(sum);
System.out.println(som);


driver.findElement(By.xpath("//input[@id='captcha_sum']")).sendKeys(som);

driver.findElement(By.xpath("//input[@id='RegistrationFamily0']")).click();

driver.findElement(By.xpath("//button[@class='btn btn-lg pull-left submitForm']")).click();
FileOutputStream fo=new FileOutputStream("C:\\Users\\Danish\\Desktop\\BJPWORK.xlsx");
wb.write(fo);
fo.close();
Thread.sleep(1000);

}
				 
			
	 
	
	  
	  
    }






 
}

private void waitUnitlSelectOptionsPopulated(org.openqa.selenium.support.ui.Select s2) 
{

    }
@AfterTest
public void closeapp()
{
	driver.quit();
	System.out.println("All Data Uploaded");
	}


}