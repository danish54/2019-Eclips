package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import luxeregister.baseclassluxe;


public class TestUtility  
{
	public static String ScreenshotName;
	public static String ScreenshotPath;
	
	// screenshot first method using FileHandler
	public static void capturescreenshot() throws IOException{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		 ScreenshotName = sdf.format(d) + ".jpg";
		 ScreenshotPath =  "C:\\Users\\ACER.NITRO 5\\git\\2019-Eclips\\Automation2020\\extentreport\\" + ScreenshotName;
		File ssFile = ((TakesScreenshot) (baseclassluxe.driver)).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		FileHandler.copy(ssFile, new File(ScreenshotPath));
		
	}

	// screenshot first method using FileUtils
		public static void captureSnapShot() throws IOException {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			File ssFile = ((TakesScreenshot) (baseclassluxe.driver)).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ssFile, new File(
					"C:\\Users\\ACER.NITRO 5\\git\\2019-Eclips\\Automation2020\\extentreport\\" + sdf.format(d) + ".jpg"));
		}

}
