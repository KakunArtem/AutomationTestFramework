package com.automation.test.framework.web.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static com.automation.test.framework.configs.ConfigConstants.CHROME_BROWSER;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;

@Component
public class WebDriverBeans {
    @Bean
    @Scope("prototype")
    @Lazy
    protected ChromeDriver chromeDriver(ChromeOptions chromeOptions) {
        System.setProperty("webdriver.chrome.driver", getConfiguration().getString(CHROME_BROWSER));
        return new ChromeDriver(chromeOptions);
    }

    @Bean
    protected ChromeOptions chromeOptions() {
        return new ChromeOptions();
    }
}
