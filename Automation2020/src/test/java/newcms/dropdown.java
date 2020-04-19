package newcms;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class dropdown extends newcms_base{
	
	newcms_base base = new newcms_base();
	
	@Test
	public void clickdropdown() throws IOException, InterruptedException{
		
		base.login();
		
		base.driver.findElement(By.xpath("//a[@class='dropdown-toggle cstm-dropdown-toggle']")).click();
		base.driver.close();
	}
	
	

}

