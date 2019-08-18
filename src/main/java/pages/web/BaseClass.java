package pages.web;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;

public class BaseClass {
	WebDriver driver;
	Logger log = Logger.getLogger("BaseClass.class");
	
	public BaseClass(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public static String getCurrentDateTime(){
	    Format formatter = new SimpleDateFormat("YYYYMMdd_HHmmssSSS");
	    Date date = new Date(System.currentTimeMillis());
	    return formatter.format(date);
	}
	
	public static void selectFromListBox(WebElement listBox,String listItem){
		Select privacySettings=new Select(listBox);
		privacySettings.selectByVisibleText(listItem);
	}
	
	public static void selectDateFromDatePicker(WebElement dateWidget, String dateToSelect){
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
		for (WebElement cell: columns){
		   if (cell.getText().equals(dateToSelect)){
		      cell.findElement(By.linkText(dateToSelect)).click();
		      break;
		   }
		}
	
	}
	public void captureScreenshot(Scenario scenario){
		 byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        if (screenshot != null ) {
            scenario.embed(screenshot, "image/png");
        }
	}
}
