import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriverWait wait;
	
		// Auto-generated method stub
		@Test
		public void homepage() throws InterruptedException, SikuliException
		{
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\driverDependencies\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
	//home page
			driver.get("https:\\development.first-hold.net");
			//Thread.sleep(5000);
			driver.getCurrentUrl();
			driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//dont use thread sleep
			Thread.sleep(5000);
	//vertical scroll 		
			((JavascriptExecutor)driver).executeScript("scroll(0,600)");
			Thread.sleep(3000);
			
//Login
		//Enter email id
			driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
			driver.findElement(By.className("emailField")).sendKeys("testvenue25@yopmail.com");
			Thread.sleep(3000);
			
		//Enter password
			driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("12345678");
			Thread.sleep(3000);
		//Click on Login
			driver.findElement(By.xpath("//button[@id='']")).click();
			Thread.sleep(5000);
			
//Add venue
			 driver.findElement(By.xpath("//span[text()='+ Add Venue']")).click();
			
//Explicit wait until expected element is found			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //label[text()=\"NAME OF VENUE/BUILDING\"]")));
	//add-venue,step 1
			//add title
	        driver.findElement(By.xpath("//input[@name=\"venueName\" and @placeholder=\"The White House, The MOMA\"]")).sendKeys("Automate");
	        
	        //venue code
	        driver.findElement(By.xpath("//input[@name=\"venueCode\" and @placeholder=\"WTHS, MOMA, \"]")).sendKeys("AUTO");
	        //Thread.sleep(100000);
	        
            //drop down
	        driver.findElement(By.id("select-venueType")).click();
	        //Selecting values from dropdown
	       driver.findElement(By.xpath("//li[contains(text(),'Boat / Yacht')]")).click();
	     
	       //Next
	       driver.findElement(By.xpath("//button[@class='jss161 jss323 jss331 jss276']")).click();
	  
	//STEP2
	       
	          driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Address Line 1");
	          driver.findElement(By.xpath("//input[@name='address2' and @placeholder='Address #2']")).sendKeys("Address Line 2");
	          driver.findElement(By.xpath("//input[@id='city' and @placeholder='City Name']")).sendKeys("San Francisco");
	          driver.findElement(By.xpath("//input[@name='zipcode' and @placeholder='12345']")).sendKeys("55555");
	          driver.findElement(By.xpath("//div[@id='select-state']")).click();
	          driver.findElement(By.xpath("//li[contains(text(),'California')]")).click();
	          driver.findElement(By.xpath("//input[@id='airport' and @placeholder='Airport closest to venue (including regional)']")).sendKeys("Napa, CA");
	          
	          Thread.sleep(2000);
	        
	         driver.findElement(By.xpath("//span[contains(@class,'jss324')][contains(text(),'Next')]")).click(); 
	         
	    // this was success
		
	//STEP3
		      driver.findElement(By.xpath("//input[@name='contactName' and @placeholder='First Last']")).sendKeys("Garima");
		      driver.findElement(By.xpath("//input[@name='contactEmail' and @placeholder='email@domain.com']")).sendKeys("garima@yopmail.com");
		      driver.findElement(By.xpath("//input[@name='contactPhoneNumber' and @placeholder='(000)-000-0000']")).sendKeys("9998887765");
			  driver.findElement(By.xpath("//input[@name='contactJobTitle' and @placeholder='Venue Manager']")).sendKeys("Quality analyst");
              driver.findElement(By.xpath("//span[@class='material-icons jss164 icon' and @aria-hidden='true' ]")).click();
		      
		      
		     //upload image
		     Pattern fileNameInput=new Pattern("C:\\Users\\hipster\\git\\2019-Eclips\\Automation2020\\Sukuli\\UploadBox.jpg"); 
		     Pattern fileNameInput1=new Pattern("C:\\Users\\hipster\\git\\2019-Eclips\\Automation2020\\Sukuli\\Open.jpg"); 
		    Screen screen=new Screen();
		      screen.type(fileNameInput,"C:\\Users\\hipster\\Pictures\\Luxe Upload Imag\\16445.jpg");
		     screen.click(fileNameInput1);
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//span[contains(text(),'Crop')]")).click();
		    		 
		     Thread.sleep(3000);
		     driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		     //as NEXT button is partially hidden under header we need to scroll up then click
		     
		     JavascriptExecutor js = (JavascriptExecutor) driver;
		     js.executeScript("window.scrollBy(0,-30)", "");
		     driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		     
		}	      
	}


