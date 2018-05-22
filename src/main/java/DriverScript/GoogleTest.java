package DriverScript;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class GoogleTest implements Comparator {

	String[] names = { "vishnu", "vardhan", "Kondi", "Testing" };
	static int[] numbersarray = {1,2,5,3,7,5};

	public boolean findName(Object nameToSearch) {
		System.out.println(nameToSearch.getClass().getName());
		if (nameToSearch instanceof String) {
			String name = (String) nameToSearch;
			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(name)) {
					System.out.println("Element Found at location : " + i);
					return true;
				}
				

			}

		} else {
			System.out.println("Please Enter a name (String) to search");
			return false;
		}
		System.out.println("Name not found in array");
		return false;
	}
	
	 
	

	
	

	public static void main(String[] args) throws Exception {

		GoogleTest test = new GoogleTest();
	
		System.out.println(test.findName("Testing"));
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Testing\\HybridFrameWork_CRM\\Automation\\Drivers\\chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(); driver.get("http://www.google.com");
		 * System.out.println(driver.getCurrentUrl());
		 * System.out.println(driver.getClass().getName()); Class c = driver.getClass();
		 * Method[] m = c.getMethods(); for(Method m1:m) {
		 * System.out.println(m1.getName()); }
		 * System.out.println(driver.getWindowHandle());
		 * 
		 * Set<String> windowHandles = driver.getWindowHandles();
		 * System.out.println(windowHandles); for(String windows : windowHandles) {
		 * System.out.println(windows.hashCode()); }
		 * 
		 * //driver.findElement(By.tagName(null));
		 * 
		 * List<WebElement> elements = driver.findElements(By.tagName("dfgg"));
		 * System.out.println(elements); for(WebElement w : elements){
		 * System.out.println(w.getText()); }
		 * 
		 * driver.switchTo().window(nameOrHandle)
		 */

	}



}
