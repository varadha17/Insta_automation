package vivid.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="C:\\Users\\Abinash\\eclipse-workspace\\vivid_instagram\\src\\main\\java\\vivid\\feature\\SearchPage.feature",
		glue="vivid.test", // path of step definition files
		//format={"pretty","html:test-output", "junit:junit_xml/cucumber.xml"}, // to generate different types of reports
		tags={"@search"}, // It will execute the tagged scenarios mentioned inside tags
		monochrome=true, // It will display the console output in proper readable format
		strict = false, // It will check if any step is not defined in step definition file
		dryRun = false // It will check the mapping between feature file and step definition file
		
		)

public class RunnerTest {

}
