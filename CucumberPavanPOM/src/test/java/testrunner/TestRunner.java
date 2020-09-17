package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//Features/Customers.feature" 
		//features = ".//Features/"   //It will execute all the feature files
		//features = ".//Features/login.feature"   //It will execute particular feature file
		//features = {".//Features/login.feature",".//Features/Customers.feature"}
		,glue= {"stepdefinitions"} 
		,monochrome = false
		,plugin={"pretty","html:target/cucumber-reports", "json:target/JsonReports/cucumber.json"}
		,dryRun = false
		//,tags = {"@sanity", "@regression"}
		)

public class TestRunner {

}
