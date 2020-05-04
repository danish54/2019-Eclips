package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtility  
{
	public static String ScreenshotName;
	public static String ScreenshotPath;
	
	
	public static void capturescreenshot(WebDriver driver) throws IOException{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		 ScreenshotName = sdf.format(d) + ".jpg";
		 ScreenshotPath =  "E:\\eclipse-jee-neon-3-win32-x86_64\\New folder\\Automation\\src\\excel\\" + ScreenshotName;
		File ssFile = ((TakesScreenshot) (driver)).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileUtils.copyFile(ssFile, new File(ScreenshotPath));
		
	}

}
