package introduction;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstclass {

	public static void main(String[] args) throws InterruptedException {
		
		  WebDriver driver; 
		  
		  System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32_2\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
			 driver.get("https://opensource-demo.orangehrmlive.com/");
			 driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
			 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
			 driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			 
			 
		        List<WebElement> elements = driver.findElements(By.tagName("a"));
				
				System.out.println("No of Links = "+elements.size() );
        
				
				for(int i=0;i<elements.size(); i++)
				{
					
					
						  String ss = elements.get(i).getAttribute("href");
						  System.out.println(ss);
        
	}
				driver.close();
    }
	
	}
