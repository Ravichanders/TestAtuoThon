package frameworkHelpers.web;

import org.openqa.selenium.WebDriver;
import pages.web.GoogleHomePage;

public class PageObjectManager {
	 
	 private WebDriver driver;
	 private GoogleHomePage googleHomePage;
	 
	 public PageObjectManager(WebDriver  driver) {
		 this.driver = driver;
	 }
	 
	 public GoogleHomePage getGoogleHomePage(){
		 return (googleHomePage == null) ? googleHomePage = new GoogleHomePage(driver) : googleHomePage;
	 }
	 
	
}
