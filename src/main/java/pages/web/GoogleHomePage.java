package pages.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BaseClass {
	
	private WebDriver driver;
	private Logger log = Logger.getLogger("BaseClass.class");
	
	@FindBy(className = "topic-html-content-header")
	private WebElement headerText; 
	
	@FindBy(xpath="//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")
	private WebElement searchTextbox;
	
	@FindBy(xpath="//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")
	private WebElement googleSearchButton;
	
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchGoogle(String searchText){
		driver.get("http://www.google.com");
		searchTextbox.sendKeys(searchText);
		googleSearchButton.click();
	}
	
	
}
