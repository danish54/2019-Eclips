package newcms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomLocator {

	public class GerneralFunc {
		WebDriver driver;
		Actions action;

		// method input URL
		public void startBrowserFirefox(String url) {
			driver = new FirefoxDriver();
			driver.navigate().to(url);
		}

		public void maximixeBrowser() {
			driver.manage().window().maximize();
		}

		public int locatorType(String identifier) {
			int id = 1;
			if (identifier == "id") {
				id = 1;
			} else if (identifier == "className") {
				id = 2;
			} else if (identifier == "cssSelector") {
				id = 3;
			} else if (identifier == "tagName") {
				id = 4;
			} else if (identifier == "partialLinkText") {
				id = 5;
			} else if (identifier == "name") {
				id = 6;
			} else if (identifier == "linkText") {
				id = 7;
			} else if (identifier == "xpath") {
				id = 8;
			} else {
				id = 0;
				System.out.println("Locator type invalid");

			}

			return id;
		}

		public WebElement webelementId(String identifier, String locator) {
			int id = locatorType(identifier);

			WebElement e = null;
			switch (id) {
			case 1:
				e = driver.findElement(By.id(locator));
				break;

			case 2:

				e = driver.findElement(By.className(locator));
				break;

			case 3:
				e = driver.findElement(By.cssSelector(locator));
				break;

			case 4:
				e = driver.findElement(By.tagName(locator));
				break;

			case 5:
				e = driver.findElement(By.partialLinkText(locator));

				break;

			case 6:
				e = driver.findElement(By.name(locator));

				break;

			case 7:
				e = driver.findElement(By.linkText(locator));
				break;

			case 8:
				e = driver.findElement(By.xpath(locator));
				break;
			default:
				System.out.println("locator not found");

				break;
			}

			return e;
		}

		public void sendKeys(String identifier, String locator, String content) {
			WebElement e = webelementId(identifier, locator);
			e.sendKeys(content);

		}

		public void click(String identifier, String locator) {
			WebElement e = webelementId(identifier, locator);
			e.click();
		}

		public void selectByValue(String identifier, String locator, String value) {
			WebElement e = webelementId(identifier, locator);
			Select osSelect = new Select(e);

			osSelect.selectByValue(value);
		}

		public void selectByIndex(String identifier, String locator, int index) {
			WebElement e = webelementId(identifier, locator);
			Select osSelect = new Select(e);
			osSelect.selectByIndex(index);
		}

		public void selectByVisibletext(String identifier, String locator, String utext) {
			WebElement e = webelementId(identifier, locator);
			Select osSelect = new Select(e);
			osSelect.deselectByVisibleText(utext);
		}

		public void VerifyTitle(String title) {
			if (driver.getTitle().equals(title)) {
				System.out.println(title + "displayed");
			} else {
				System.out.println("failed to display" + title);
			}
		}

		public void verifyText(String identifier, String locator, String text) {
			WebElement e = webelementId(identifier, locator);
			if (e.isDisplayed()) {
				System.out.println("text is prswent");
			} else {
				System.out.println("text is not found");
			}
		}

		public void VerifyElementPresent(String Identifier, String locator) {
			WebElement e = webelementId(Identifier, locator);
			if (e.isDisplayed()) {
				System.out.println("Element is present ");
			} else {
				System.out.println("element is ot found");
			}
		}

		public void selectalert() {
			Alert a = driver.switchTo().alert();
			a.accept();
		}

		public void waitforFindElement(long waittime) {
			try {
				driver.wait(waittime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void waituntilElementPresent(String Elementpath) {

			WebElement elementPresent = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Elementpath)));
		}

		public void waitforPageToLoad() {
			try {
				for (int i = 0; i < 50;) {
					if (driver.getTitle().length() != 0) {
						System.out.println("page load");
						i = 51;
						break;
					} else {
						Thread.sleep(3000);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public void sleepThread(long sleeptime) {
			try {
				Thread.sleep(sleeptime);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		public void closeBrowser() {
			driver.close();
		}

		public void quitBrowser() {
			driver.quit();
		}
	}

}
