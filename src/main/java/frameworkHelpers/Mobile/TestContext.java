package frameworkHelpers.Mobile;


public class TestContext {
	
	 private AndroidDriverManager androidDriverManager;
	 private PageObjectManager pageObjectManager;
	 public TestContext(){
		 androidDriverManager = new AndroidDriverManager();
		 pageObjectManager = new PageObjectManager(androidDriverManager.getDriver());
	 }
	 
	 public AndroidDriverManager getAndroidDriverManager() {
		 return androidDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
		 return pageObjectManager;
	 }
	 
}

