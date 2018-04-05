package CommonFunctions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyFileUtil;

public class CommonFunctionality {

	// static WebDriver driver;
	public static WebDriver startBrowser(WebDriver driver) throws Exception, Throwable {

		if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Testing\\HybridFrameWork_CRM\\Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.geckodriver.driver",
					"D:\\Testing\\HybridFrameWork_CRM\\Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;

	}

	public static void openApplication(WebDriver driver) throws Exception, Throwable {
		driver.manage().window().maximize();
		driver.get(PropertyFileUtil.getValueForKey("URL"));
	}

	public static void clickAction(WebDriver driver, String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();

		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();

		}

	}

	public static void typeAction(WebDriver driver, String locatorType, String locatorValue, String data) {
		if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(data);

		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).clear();
			driver.findElement(By.name(locatorValue)).sendKeys(data);

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).clear();
			driver.findElement(By.xpath(locatorValue)).sendKeys(data);

		}
	}

	public static void waitForElement(WebDriver driver, String locatorType, String locatorValue, String waitTime) throws Throwable {

		
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waitTime));
		if (locatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		} else if (locatorType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		}
	}
	
	public static void staleElementExceptionHandler(WebDriver driver, String locatorType, String locatorValue) {
		
		if(locatorType.equalsIgnoreCase("xpath")) {
			driver.navigate().refresh();
			WebElement draggable = driver.findElement(By.xpath(locatorValue));
	//you can remove it...................
			//..............
			draggable.click();
		
			
			}
			}
			
		
	

	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	public void registrationTestValidation(WebDriver driver, String validTitle) {

		String actula_title = driver.getTitle();
		String expected_title = validTitle;
		Assert.assertEquals(actula_title, expected_title);

	}

	public static void dropDown(WebDriver driver, String locatorType, String locatorValue, String data) {

		if (locatorType.contentEquals("id")) {
			Select select = new Select(driver.findElement(By.id(locatorValue)));
			select.selectByVisibleText(data);
		}
		if (locatorType.contentEquals("xpath")) {
			Select select = new Select(driver.findElement(By.xpath(locatorValue)));
			select.selectByVisibleText(data);
		}
	}

	public static void switchToWindow(WebDriver driver, int windowNum) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(windowNum));
	}

	public static void switchToFrame(WebDriver driver, int frameNum) {

		driver.switchTo().frame(frameNum);
	}

	public static void countNoOfBoxes(WebDriver driver, String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("xpath")) {
			ArrayList<WebElement> noOfBoxes = new ArrayList<WebElement>(driver.findElements(By.xpath(locatorValue)));
			System.out.println("No of Boxes in Way2Auomation " + noOfBoxes.size());
		}
	}

	public static void countNoOfBoxesOfWidget(WebDriver driver, String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("xpath")) {
			ArrayList<WebElement> noOfBoxes = new ArrayList<WebElement>(driver.findElements(By.xpath(locatorValue)));
			System.out.println("No of Boxes in Way2Auomation of Widget " + noOfBoxes.size());
		}
	}

	public static void dragBox(WebDriver driver, String locatorType, String locatorValue) {
		Actions action = new Actions(driver);
		if (locatorType.equalsIgnoreCase("xpath")) {
			WebElement source = driver.findElement(By.xpath(locatorValue));
			action.dragAndDropBy(source, 250, 0).build().perform();
			System.out.println(driver.getPageSource());
		}
	}

	public static void scrollDown(WebDriver driver) {

			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,550)");
			
			
	}

}
