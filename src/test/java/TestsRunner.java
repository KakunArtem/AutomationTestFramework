
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import lombok.AllArgsConstructor;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepDefinitions",
        plugin = {
            "pretty",
            "json:build/cucumber-report/cucumber.json",
            "html:build/cucumber-report/cucumber.html"})
@AllArgsConstructor
public class TestsRunner {

}


