package stepDefinitions;

import com.automation.test.framework.web.driver.DriverManager;
import com.automation.test.framework.web.driver.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {
    private static DriverManager driverManager;

    @Before
    public static void setup() {
        driverManager = new DriverManager(DriverType.CHROME);
    }

    @After
    public static void teardown() {
        driverManager.quitDriver();
    }
}
