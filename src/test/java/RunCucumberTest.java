import com.automation.test.framework.AppConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.reducers.ReducingMethod;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"stepDefinitions"},
        tags = {"not @ignored"},
        junit = {"--step-notifications"},
        plugin = {"pretty", "json:target/json-report/CucumberTestReport.json"})
@ContextConfiguration(classes = AppConfig.class)
public class RunCucumberTest {
    @BeforeClass
    public static void setUp() {
    }

    @AfterClass
    public static void tearsDown() {
        createReport();
    }

    private static void createReport() {
        File reportOutputDirectory = new File("target/json-report");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/json-report/CucumberTestReport.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "Automation test framework");
        configuration.setBuildNumber(System.getProperty("library.version"));
        configuration.addClassifications("OS", System.getProperty("os.name"));
        configuration.addReducingMethod(ReducingMethod.SKIP_EMPTY_JSON_FILES);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
}


