package frameworkHelpers.web;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.firefox.FirefoxDriver;

import frameworkHelpers.ReadProperties;

public class FirefoxDriverManager extends DriverManagers {
	private static final String Firefox_DRIVER_PROPERTY = "webdriver.gecko.driver";
    @Override
    public void createDriver() {
    	ReadProperties prop=new ReadProperties("web");
    	Properties props=prop.getProperty();
    	System.setProperty(Firefox_DRIVER_PROPERTY, props.getProperty("geckoDriverPath"));
    	driver = new FirefoxDriver();
    }
}

