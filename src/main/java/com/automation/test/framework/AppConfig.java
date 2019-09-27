package com.automation.test.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static com.automation.test.framework.configs.ConfigConstants.CHROME_BROWSER;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;


@Configuration
@ImportResource("classpath:cucumber.xml")
public class AppConfig {

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
