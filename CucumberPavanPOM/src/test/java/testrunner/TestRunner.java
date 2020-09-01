package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Customers.feature" 
		//features = ".//Features/"   //It will execute all the feature files
		//features = ".//Features/login.feature"   //It will execute particular feature file
		//features = {".//Features/login.feature",".//Features/Customers.feature"}
		,glue= {"stepdefinitions"} 
		,monochrome = true
		,plugin={"pretty","html:target/cucumber-reports", "json:target/JsonReports/cucumber.json"}
		,dryRun = false
		
		)

public class TestRunner {

}
