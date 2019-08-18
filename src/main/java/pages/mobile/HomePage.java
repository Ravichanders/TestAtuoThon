package pages.mobile;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseClass {
	AndroidDriver<AndroidElement> driver;
	Logger log = Logger.getLogger("Logger");
	
	@FindBy(xpath="//android.widget.TextView[@text='Preference']")
	WebElement preferecnceMenu;
	
	@FindBy(xpath="//android.widget.TextView[@text='Views']")
	WebElement viewsMenu;
	
	public HomePage(AndroidDriver<AndroidElement> driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Preferences navigateToPreferencesPage(){
		preferecnceMenu.click();
		log.info("Clicked on [preference] link");
		return new Preferences(driver);
	}
	
	
}
