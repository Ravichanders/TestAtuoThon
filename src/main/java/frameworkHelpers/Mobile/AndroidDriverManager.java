package frameworkHelpers.Mobile;

import frameworkHelpers.ReadProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverManager {
	
		private String apkFile;
		private String deviceName;
		private static String URL= "http://127.0.0.1:xxxx/wd/hub";
		private AndroidDriver<AndroidElement> driver;
		private String port;
		private Logger logger = Logger.getLogger("ReadProperties.class");
		 public AndroidDriver<AndroidElement> getDriver() {
			 if(driver == null) driver = createDriver();
			 	return driver;
		 }
		 
		 private AndroidDriver<AndroidElement> createDriver() {
			 ReadProperties prop=new ReadProperties("mobile");
			 Properties props=prop.getProperty();
			 deviceName=props.getProperty("deviceName");
			 String platformVersion=props.getProperty("platformVersion");
			 String platformName=props.getProperty("platformName");
			 String apkFile=props.getProperty("apkFile");
			 port=props.getProperty("port");
			 String apkFilePath=props.getProperty("apkFilePath");
			 int waitTime=Integer.parseInt(props.getProperty("waitTime"));
			
			 File appDir = new File(apkFilePath);
		     File app = new File(appDir, apkFile);
		     DesiredCapabilities capabilities = new DesiredCapabilities();
		     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		     capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
		     capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		     //capabilities.setCapability("browserName", "Chrome");
		     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		     URL=URL.replace("xxxx", port);
		     try {
				driver = new AndroidDriver<AndroidElement>(new URL(URL), capabilities);
			} catch (MalformedURLException e) {
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		     driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		     return driver;  
		 } 
		 
		 public void closeDriver() {
			 driver.close();
			 driver.quit();
		 }

		 
}


