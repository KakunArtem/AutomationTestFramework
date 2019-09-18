package stepDefinitions;

import com.automation.test.framework.web.driver.WebDriverHome;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.automation.test.framework.configs.ConfigConstants.BROWSER_TYPE;
import static com.automation.test.framework.configs.ConfigConstants.BROWSER_VERSION;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;

public class Hook {
    private static final String browserType = getConfiguration().getString(BROWSER_TYPE);
    private static final String browserVersion = getConfiguration().getString(BROWSER_VERSION);

    private final WebDriverHome webDriverHome;

    public Hook(WebDriverHome home) {
        webDriverHome = home;
    }

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Before(value = "@InitWebDriver", order = 0)
    public void startBrowser() {
        if (!webDriverHome.driverIsRunning()) {
            webDriverHome.initDriver(browserType, browserVersion);
        }
    }

    @After(value = "@CloseWebDriver", order = 3)
    public void closeWebDriver() {
        Runtime.getRuntime().addShutdownHook(new Thread(webDriverHome::closeDriver));
    }
}
