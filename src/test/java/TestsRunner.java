import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = "stepDefinitions",
        plugin = {
            "pretty",
            "json:build/cucumber-report/cucumber.json",
            "html:build/cucumber-report/cucumber.html"})

public class TestsRunner {
//    private static Driver driver = new Driver();
//    private static String defaultBrowser = getConfiguration()
//        .getString(DEFAULT_BROWSER);
//
//
//    @Before
//    public static void setup() {
//        driver.initializeDriver(defaultBrowser);
//    }
//
//    @After
//    public static void teardown() {
//        if (Driver.driver != null) {
//            Driver.driver.quit();
//        }
//    }
}


