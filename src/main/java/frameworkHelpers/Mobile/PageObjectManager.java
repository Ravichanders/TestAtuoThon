package frameworkHelpers.Mobile;

import java.util.prefs.Preferences;

import pages.mobile.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageObjectManager {
	 
	 private AndroidDriver<AndroidElement> driver;
	 private HomePage homePage;
	 private Preferences preferences;
	 
	 public PageObjectManager(AndroidDriver<AndroidElement>  driver) {
		 this.driver = driver;
	 }
	 
	 public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	 }
	 
	 
	

}
