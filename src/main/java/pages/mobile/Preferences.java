package pages.mobile;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Preferences {
	
		AndroidDriver<AndroidElement> driver;
		Logger log = Logger.getLogger("Logger");
		
		@FindBy(xpath="//android.widget.TextView[@text='2. Launching preferences']")
		WebElement launchPreferences;
		
		public Preferences(AndroidDriver<AndroidElement> driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
}

