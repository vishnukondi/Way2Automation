package DriverScript;

import org.testng.annotations.Test;



public class AppTesting {
	
	@Test
	public void startAppTest() throws Throwable {
		DriverScript ds = new DriverScript();
		ds.startTest();
	}

}
