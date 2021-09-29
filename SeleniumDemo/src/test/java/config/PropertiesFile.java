package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import test.TestNG_Demo;

public class PropertiesFile {
	
	private static Properties prop = new Properties();
	private static String projectPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}
	
	public static void getProperties() {
		try {				
			System.out.println("user.dir");			
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			//Load the properties file
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("This is my Browser: "+browser);
			TestNG_Demo.browserName=browser;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	
	public static void setProperties() {
		try {
			OutputStream out = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(out, "test");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}

}
