package frameworkHelpers.web;

import java.util.Properties;

import frameworkHelpers.ReadProperties;

public class TestContext {
	
	 private DriverManagers driverManager;
	 private PageObjectManager pageObjectManager;
	 public TestContext(){
		 ReadProperties prop=new ReadProperties("web");
	     Properties props=prop.getProperty();
		 driverManager = DriverManagerFactory.getManager(props.getProperty("browser"));
		 pageObjectManager = new PageObjectManager(driverManager.getDriver());
	 }
	 
	 public DriverManagers getDriverManagers() {
		 return driverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
	 }
	 
}

