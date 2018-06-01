package AppTest;

import org.testng.annotations.Test;

import DriverScript.DriverScript;

public class AppTest {
	
	@Test
	public void startAppTest() throws Throwable {
		DriverScript ds = new DriverScript();
		ds.startTest();
	}

}
