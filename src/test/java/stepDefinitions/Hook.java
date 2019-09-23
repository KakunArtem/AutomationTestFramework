package stepDefinitions;

import com.automation.test.framework.web.driver.WebDriverHome;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static com.automation.test.framework.configs.ConfigConstants.BROWSER_TYPE;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;

public class Hook {
    private static final String browserType = getConfiguration().getString(BROWSER_TYPE);

    @Autowired
    WebDriverHome webDriverHome;

    @Before(value = "@InitWebDriver", order = 0)
    public void startBrowser() {
        if (!webDriverHome.driverIsRunning()) {
            webDriverHome.setupWebDriver(browserType);
        }
    }

    @After(value = "@QuitWebDriver", order = 3)
    public void closeWebDriver() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                webDriverHome.quitDriver();
            }
        });
    }
}
