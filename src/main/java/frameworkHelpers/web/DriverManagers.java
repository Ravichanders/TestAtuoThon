package frameworkHelpers.web;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class DriverManagers {

	protected WebDriver driver;
	Logger logger = Logger.getLogger("ReadProperties.class");
	protected abstract void createDriver();
	
	public WebDriver getDriver() {
		 if(driver == null){ 
			 createDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 }
		 return driver;
	 }
	 public void closeDriver() {
		 driver.close();
		 driver.quit();
	 }

}


