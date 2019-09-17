package stepDefinitions;

import com.automation.test.framework.web.driver.WebDriverHome;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

    private final  WebDriverHome webDriverHome;

    public Hook(WebDriverHome home) {
        webDriverHome = home;
    }

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @After(value = "@CloseWebDriver", order = 3)
    public void closeWebDriver() {
        Runtime.getRuntime()
               .addShutdownHook(new Thread(webDriverHome::closeDriver));
    }
}
