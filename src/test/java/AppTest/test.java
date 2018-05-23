package AppTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {
	@Test
	public void testing() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\HybridFrameWork_CRM\\Automation\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		System.out.println(driver.getPageSource());
		Thread.sleep(10000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		//System.out.println(driver.switchTo().frame(1).getPageSource());
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath(".//*[@class='fancybox-inner']/div/form/fieldset[1]/input")).sendKeys("33333");
		
	}

}
