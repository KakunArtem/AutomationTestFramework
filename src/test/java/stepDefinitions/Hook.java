package stepDefinitions;

import com.automation.test.framework.web.driver.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.automation.test.framework.configs.ConfigConstants.DEFAULT_BROWSER;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;

public class Hook {
    private static Driver driver = new Driver();
    private static String defaultBrowser = getConfiguration().getString(DEFAULT_BROWSER);

    @Before
    public static void setup() {
        driver.initializeDriver(defaultBrowser);
        driver.initializeActions();
    }

    @After
    public static void teardown() {
        if (Driver.driver != null) {
            Driver.driver.quit();
        }
    }
}
