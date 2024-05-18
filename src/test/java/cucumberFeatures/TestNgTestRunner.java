package cucumberFeatures;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumberFeatures",glue="stepDefinations",monochrome=true,plugin={"html:target/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests{

	
}
//tags="@Regression"