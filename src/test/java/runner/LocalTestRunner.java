package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features", 
		glue = { "stepDefinitions" }, 
		monochrome = true,
		plugin = {"pretty", "junit:target/JUnitReports.xml", "html:target/HtmlReports.html" , "json:target/JSONReports.json"})
public class LocalTestRunner {

}
