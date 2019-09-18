package com.automation.test.framework.web.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {

    WebDriver initializeDriver(String browserType, String browserVersion) {
        switch (browserType) {
            case ("IE"):
                return setupIE(browserVersion);
            case ("Firefox"):
                return setupFireFox(browserVersion);
            case ("Chrome"):
                return setupChrome(browserVersion);
        }
        throw new RuntimeException(browserType + " is unsupported driver type.");
    }

    private WebDriver setupChrome(String version) {
        if (version != null) {
            WebDriverManager.chromedriver()
                            .version(version)
                            .setup();
            return new ChromeDriver();
        } else {
            WebDriverManager.chromedriver()
                            .setup();
            return new ChromeDriver();
        }
    }

    private WebDriver setupFireFox(String version) {
        if (version != null) {
            WebDriverManager.firefoxdriver()
                            .version(version)
                            .setup();
            return new FirefoxDriver();
        } else {
            WebDriverManager.firefoxdriver()
                            .setup();
            return new FirefoxDriver();
        }
    }

    private WebDriver setupIE(String version) {
        if (version != null) {
            WebDriverManager.iedriver()
                            .version(version)
                            .setup();
            return new InternetExplorerDriver();
        } else {
            WebDriverManager.iedriver()
                            .setup();
            return new InternetExplorerDriver();
        }
    }

}
