package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions",monochrome=true,strict=true,tags= "@RegressionTest",
plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"})

public class TestRunner {
//dryRun=true
}
