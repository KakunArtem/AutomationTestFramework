package com.automation.test.framework.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class WebDriverFactory {
    @Autowired
    private ChromeOptions chromeOptions;

    @Autowired
    private BeanFactory beanFactory;

    WebDriver driverFactory(String browserType) {
        switch (browserType) {
            case ("Chrome"):
                return setupChrome();
            default:
                throw new RuntimeException(browserType + " is unsupported driver type.");
                //todo rest of browsers
        }
    }

    private WebDriver setupChrome() {
        chromeOptions.addArguments("--disable-extensions");
        return beanFactory.getBean(ChromeDriver.class, chromeOptions);
    }

}
