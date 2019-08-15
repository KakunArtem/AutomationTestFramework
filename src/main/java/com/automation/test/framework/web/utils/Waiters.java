package com.automation.test.framework.web.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiters {
    private static final int WAIT_MILLS = 10000;
    private static final int POLLING_MILLS = 1000;

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public Waiters(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(this.driver)
            .withTimeout(Duration.ofMillis(WAIT_MILLS))
            .pollingEvery(Duration.ofMillis(POLLING_MILLS))
            .ignoring(NoSuchElementException.class);
    }

    public FluentWait<WebDriver> getWait(){
        return wait;
    }

    public FluentWait<WebDriver> getCustomWait(int durationMills){
        return new FluentWait<>(driver).withTimeout(Duration.ofMillis(durationMills))
                                       .pollingEvery(Duration.ofMillis(POLLING_MILLS))
                                       .ignoring(NoSuchElementException.class);
    }

    public FluentWait<WebDriver> getCustomWait(int durationMills, int poolingMills){
        return new FluentWait<>(driver).withTimeout(Duration.ofMillis(durationMills))
                                       .pollingEvery(Duration.ofMillis(poolingMills))
                                       .ignoring(NoSuchElementException.class);
    }
}
