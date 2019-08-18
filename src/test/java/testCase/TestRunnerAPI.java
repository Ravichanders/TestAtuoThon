package testCase;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/API"},
    plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
    glue={"testCase.stepDefinitions.API"},
    monochrome = true
)

public class TestRunnerAPI {
	
    @BeforeClass
    public static void initialSetup() throws Exception{                                              
    	PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\Log4j.properties");
    }                              
}
