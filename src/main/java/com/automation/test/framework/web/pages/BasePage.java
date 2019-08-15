package com.automation.test.framework.web.pages;

import java.util.concurrent.TimeUnit;

import static com.automation.test.framework.web.driver.Driver.driver;

public class BasePage {

    public void goToPage(String page) throws InterruptedException {
        driver.get(page);
        TimeUnit.SECONDS.sleep(10);
    }

}
