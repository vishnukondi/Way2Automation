package DriverScript;

import org.openqa.selenium.WebDriver;

import CommonFunctions.CommonFunctionality;
import CommonFunctions.ExcelUtilFile;

public class DriverScript {
	
	
	WebDriver driver;
	
	public void startTest() throws Throwable {
		ExcelUtilFile excel = new ExcelUtilFile();
		
		for(int i=1;i<=excel.rowCount("Modules");i++) {
			if(excel.getData("Modules", i, 2).equalsIgnoreCase("Y")) {
				String TCModule = excel.getData("Modules", i, 1);
				int rowCount = excel.rowCount(TCModule);
				for(int j=1;j<=rowCount;j++) {
					
					String Description =  excel.getData(TCModule, j, 0);
					String Object_Name =  excel.getData(TCModule, j, 1);
					String Locator_Type =  excel.getData(TCModule, j, 2);
					String Locator_Value =  excel.getData(TCModule, j, 3);
					String Test_Data =  excel.getData(TCModule, j, 4);
					
					if(Object_Name.equalsIgnoreCase("startBrowser")) {
						driver = CommonFunctionality.startBrowser(driver);
					}
					if(Object_Name.equalsIgnoreCase("openApplication")) {
						CommonFunctionality.openApplication(driver);
					}
					if(Object_Name.equalsIgnoreCase("clickAction")) {
						CommonFunctionality.clickAction(driver, Locator_Type, Locator_Value);
					}
					if(Object_Name.equalsIgnoreCase("typeAction")) {
						CommonFunctionality.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
					}
					if(Object_Name.equalsIgnoreCase("dropDown")) {
						CommonFunctionality.dropDown(driver, Locator_Type, Locator_Value, Test_Data);
					}
					if(Object_Name.equalsIgnoreCase("switchToWindow")) {
						CommonFunctionality.switchToWindow(driver, Integer.parseInt(Test_Data));
					}
					if(Object_Name.equalsIgnoreCase("countNoOfBoxes")) {
						CommonFunctionality.countNoOfBoxes(driver, Locator_Type, Locator_Value);
					}
					if(Object_Name.equalsIgnoreCase("countNoOfBoxesOfWidget")) {
						CommonFunctionality.countNoOfBoxesOfWidget(driver, Locator_Type, Locator_Value);
					}
					if(Object_Name.equalsIgnoreCase("dragBox")) {
						CommonFunctionality.dragBox(driver, Locator_Type, Locator_Value);
					}
					if(Object_Name.equalsIgnoreCase("scrollDown")) {
						CommonFunctionality.scrollDown(driver);
					}
					if(Object_Name.equalsIgnoreCase("switchToFrame")) {
						CommonFunctionality.switchToFrame(driver, Integer.parseInt(Test_Data));
					}
					if(Object_Name.equalsIgnoreCase("staleElementExceptionHandler")) {
						CommonFunctionality.staleElementExceptionHandler(driver, Locator_Type, Locator_Value);
					}
					//changs to secind
				}
			}
		}
	}

}
