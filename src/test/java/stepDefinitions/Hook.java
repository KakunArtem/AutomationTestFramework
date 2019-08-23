package stepDefinitions;

import com.automation.test.framework.web.driver.DriverManager;
import com.automation.test.framework.web.driver.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {
//    static DriverManager driverManager;
//    static Waiters waiters;
    WebDriver driver;
    static DriverManager driverManager;


    @Before
    public static void setup() {
//        driverManager = DriverFactory.initializeDriver(CHROME);
//        driverManager.getDriver()
//                     .manage()
//                     .window()
//                     .maximize();
//        waiters = new Waiters(driverManager);
        driverManager = new DriverManager(DriverType.CHROME);
    }

    @After
    public static void teardown() {
//        driverManager.quitDriver();
        driverManager.quitDriver();

    }
}
