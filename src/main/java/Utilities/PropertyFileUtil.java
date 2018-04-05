package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil {
	
	
	public static String getValueForKey(String Key) throws Throwable, Exception {
		Properties propertyConfig = new Properties();
		propertyConfig.load(new FileInputStream(new File("D:\\Testing\\HybridFrameWork_CRM\\Automation\\PropertiesFile\\Properties.properties")));
		return propertyConfig.getProperty(Key);
	}

}
 