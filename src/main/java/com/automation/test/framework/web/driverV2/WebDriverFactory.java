package com.automation.test.framework.web.driverV2;

import com.automation.test.framework.web.driver.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.stereotype.Service;

import static com.automation.test.framework.configs.ConfigConstants.BROWSER_TYPE;
import static com.automation.test.framework.configs.ConfigConstants.BROWSER_VERSION;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;

@Service
public class WebDriverFactory {

    public WebDriver initializeDriver(){
        DriverType browserType = DriverType.valueOf(getConfiguration().getString(BROWSER_TYPE));
        String browserVersion = getConfiguration().getString(BROWSER_VERSION);
        switch (browserType) {
            case IE:
                return setupIE(browserVersion);
            case FIREFOX:
                return setupFireFox(browserVersion);
            case CHROME:
                return setupChrome(browserVersion);
        }
        throw new RuntimeException(browserType + " is unsupported driver type.");
    }

    private WebDriver setupChrome(String version){
        if(version != null){
            WebDriverManager.chromedriver().version(version).setup();
            return new ChromeDriver();
        }else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }

    private WebDriver setupFireFox(String version){
        if(version != null){
            WebDriverManager.firefoxdriver().version(version).setup();
            return new FirefoxDriver();
        }else {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    }

    private WebDriver setupIE(String version){
        if(version != null){
            WebDriverManager.iedriver().version(version).setup();
            return new InternetExplorerDriver();
        }else {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
    }

}
