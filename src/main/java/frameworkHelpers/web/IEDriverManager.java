package frameworkHelpers.web;

import java.util.Properties;

import org.openqa.selenium.ie.InternetExplorerDriver;

import frameworkHelpers.ReadProperties;

public class IEDriverManager extends DriverManagers{
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	@Override
	public void createDriver() {
		ReadProperties prop=new ReadProperties("web");
    	Properties props=prop.getProperty();
    	System.setProperty(IE_DRIVER_PROPERTY, props.getProperty("IEDriverPath"));
        driver = new InternetExplorerDriver();
	}
	
}
