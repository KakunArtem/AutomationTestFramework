package com.automation.test.framework.web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public WebDriver initializeDriver(DriverType driverType) {
        switch (driverType) {
            case IE:
                return setupIE();
            case FIREFOX:
                return setupFirefox();
            case CHROME:
                return setupChrome();
        }
        throw new RuntimeException(driverType + " unsupported driver type.");
    }

    private WebDriver setupChrome() {
        WebDriverManager.chromedriver().arch32().setup();
        return new ChromeDriver();
    }

    private WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().arch32().setup();
        return new FirefoxDriver();
    }

    private WebDriver setupIE() {
        WebDriverManager.iedriver().arch32().setup();
        return new InternetExplorerDriver();
    }
}
