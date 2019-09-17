package stepDefinitions;

import com.automation.test.framework.web.driver.WebDriverHome;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class Hook {
    @Autowired
    private WebDriverHome webDriverHome;

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @After(value = "@CloseWebDriver", order = 3)
    public void closeWebDriver() {
        Runtime.getRuntime()
               .addShutdownHook(new Thread(() -> webDriverHome.closeDriver()));
    }
}
