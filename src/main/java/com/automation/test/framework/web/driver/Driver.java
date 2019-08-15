package com.automation.test.framework.web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import static com.automation.test.framework.configs.ConfigConstants.WEB_HOST;

public class Driver {
    private static final String host = WEB_HOST;

    public static WebDriver driver;

    public void initializeDriver(String driverType) {
        if (driver != null) {
            return;
        }
        getDriver(driverType);
    }

    private WebDriver setupFirefox() {
        WebDriverManager.firefoxdriver().arch32().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    private WebDriver setupChrome() {
        WebDriverManager.chromedriver().arch32().setup();
        driver = new ChromeDriver();
        return driver;
    }

    private WebDriver setupIE() {
        WebDriverManager.iedriver();
        driver = new InternetExplorerDriver();
        return driver;
    }

    private WebDriver getDriver(String driverType) {
        switch (driverType.toLowerCase()) {
            case BrowserType.IE:
                setupIE();
                break;
            case BrowserType.FIREFOX:
                setupFirefox();
                break;
            default:
                setupChrome();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
