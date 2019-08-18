package testCase.stepDefinitions.mobile;

import java.util.prefs.Preferences;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.mobile.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworkHelpers.Mobile.AndroidDriverManager;
import frameworkHelpers.Mobile.PageObjectManager;
import frameworkHelpers.Mobile.TestContext;

public class HomePage_Steps {
	
	private HomePage homePage;
	private pages.mobile.Preferences preferences ;
	private TestContext testContext;
	
	Logger log = Logger.getLogger(HomePage_Steps.class);
	
	public HomePage_Steps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
		 PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\Log4j.properties");
	}
	
	@Given("^I am at the home page$")
	public void i_am_at_the_home_page() throws Throwable {
		 System.out.println("In start page");
		 log.info("In start page");
	}

	@When("^I click \"([^\"]*)\" option$")
	public void i_click_option(String arg1) throws Throwable {
		preferences=homePage.navigateToPreferencesPage();
	}

	
	 @Before
     public void beforeScenario(Scenario scenario) {
         System.out.println("********************************************************");
         log.info("********************************************************");
         System.out.println("Scenario: " + scenario.getName());
         log.info("Scenario: " + scenario.getName());
         System.out.println("********************************************************");
         log.info("********************************************************");
     }

     @After
     public void afterScenario(Scenario scenario) {
    	 if (scenario.isFailed()) {
    		 homePage.captureScreenshot(scenario);
    	 }
     }
     
     @AfterClass
     public void tearDown(Scenario scenario) {
    	 testContext.getAndroidDriverManager().closeDriver();
     }
}
