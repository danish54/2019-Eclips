package newcms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class newcms_base {
	
	public WebDriver driver;
	
	@Test
	public void testBrowser() {
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();

}
}