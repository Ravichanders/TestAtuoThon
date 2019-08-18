package frameworkHelpers.web;

import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;


import frameworkHelpers.ReadProperties;

public class ChromeDriverManager extends DriverManagers {
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    @Override
    public void createDriver() {
    	ReadProperties prop=new ReadProperties("web");
    	Properties props=prop.getProperty();
    	System.setProperty(CHROME_DRIVER_PROPERTY, props.getProperty("chromeDriverPath"));
    	driver = new ChromeDriver();
    }

}

