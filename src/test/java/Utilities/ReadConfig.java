package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	String path = "Config.properties";
	//constructor
	public ReadConfig() {
		try {
			properties = new Properties();
			// To open config.properties file in input mode and load file
			FileInputStream  fis = new FileInputStream(path);
			properties.load(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}

}
