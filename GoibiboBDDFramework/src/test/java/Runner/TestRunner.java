package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			features = "C:\\Users\\Prati\\eclipse-workspace\\GoibiboBDDFramework\\src\\test\\java\\Feature\\MyHoliday.feature", 
			glue={"StepDefinations"},
			tags="@Smoke",
			plugin = {"pretty",
					"html:target/cucumber-reports/cucumber.html",
					"json:target/cucumber-reports/cucumber.json"}		
			)

public class TestRunner extends AbstractTestNGCucumberTests {

}
