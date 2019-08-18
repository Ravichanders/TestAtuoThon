package pages.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.epam.reportportal.message.ReportPortalMessage;

import cucumber.api.Scenario;

public class BaseClass {
	AndroidDriver<AndroidElement> driver;
	Logger log = Logger.getLogger("BaseClass.class");
	
	public BaseClass(AndroidDriver<AndroidElement> driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void captureScreenshot(Scenario scenario){
		 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         if (screenshot != null ) {
             scenario.embed(screenshot, "image/png");
         }
		 driver.close();
	}
	
	public static String getCurrentDateTime(){
	    Format formatter = new SimpleDateFormat("YYYYMMdd_HHmmssSSS");
	    Date date = new Date(System.currentTimeMillis());
	    return formatter.format(date);
	}
}
