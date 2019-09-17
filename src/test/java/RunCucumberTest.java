import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"stepDefinitions"},
        tags = {"not @ignored"},
        junit = {"--step-notifications"},
        plugin = {
            "pretty",
            "json:target/json-report/CucumberTestReport.json"})

public class RunCucumberTest {
}

