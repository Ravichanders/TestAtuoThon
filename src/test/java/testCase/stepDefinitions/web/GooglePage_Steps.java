package testCase.stepDefinitions.web;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;

import pages.web.GoogleHomePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import frameworkHelpers.web.TestContext;

public class GooglePage_Steps {
	 
	private Logger logger = Logger.getLogger("GooglePage.class");
	private GoogleHomePage googleHomePage;
	private TestContext testContext;
	
	public GooglePage_Steps(TestContext context){
		testContext = context;
		googleHomePage = testContext.getPageObjectManager().getGoogleHomePage();
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\Log4j.properties");
	}
	
	@Given("I am at the google search page")
	public void i_am_at_the_google_search_page() {
	    System.out.println("on google home page");
	    logger.info("on google home page");
	}
	
	@When("I enter text at {string} option")
	public void i_enter_text_at_option(String searchWord) {
		 googleHomePage.searchGoogle(searchWord);
		 System.out.println("Entered string");
		 logger.info("Entered text");
	}
	
	@When("I click on {string} button")
	public void i_click_on_button(String string) {
	   System.out.println("clicked on search button");
	   logger.info("click on search button");
	
	}

	 @Before
     public void beforeScenario(Scenario scenario) {
         System.out.println("********************************************************");
         logger.info("********************************************************");
         System.out.println("Scenario: " + scenario.getName());
         logger.info("Scenario: " + scenario.getName());
         System.out.println("********************************************************");
         logger.info("********************************************************");
     }

     @After
     public void afterScenario(Scenario scenario) {
    	 if (scenario.isFailed()) {
    		 googleHomePage.captureScreenshot(scenario);
    		 testContext.getDriverManagers().closeDriver();
    	 }
    	 
     }
     
}