import com.automation.test.framework.AppConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"stepDefinitions"},
        tags = {"not @ignored"},
        junit = {"--step-notifications"},
        plugin = {
                "pretty",
                "json:target/json-report/CucumberTestReport.json"})
@ContextConfiguration(classes = AppConfig.class)
public class RunCucumberTest {
}


