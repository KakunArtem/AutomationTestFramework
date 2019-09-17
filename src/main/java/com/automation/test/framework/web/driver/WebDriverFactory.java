package com.automation.test.framework.web.driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static com.automation.test.framework.configs.ConfigConstants.BROWSER_TYPE;
import static com.automation.test.framework.configs.ConfigConstants.BROWSER_VERSION;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;


public class WebDriverFactory {
    private static final String browserType = getConfiguration().getString(BROWSER_TYPE);
    private static final String browserVersion = getConfiguration().getString(BROWSER_VERSION);

    public WebDriver initializeDriver() {
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
