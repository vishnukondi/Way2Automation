package AppTest;

import org.testng.annotations.Test;

import DriverScript.DriverScript;

public class AppTesting {
	
	@Test
	public void startAppTest() throws Throwable {
		DriverScript ds = new DriverScript();
		ds.startTest();
	}

}
