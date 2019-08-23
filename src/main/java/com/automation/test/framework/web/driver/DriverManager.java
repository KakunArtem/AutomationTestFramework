package com.automation.test.framework.web.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final int WAIT_MILLS = 10000;
    private static final int POLLING_MILLS = 1000;

    private DriverFactory driverFactory = new DriverFactory();
    private static WebDriver driver;
    private static FluentWait<WebDriver> wait;

    public DriverManager() {
    }

    public DriverManager(DriverType driverType) {
        driver = driverFactory.initializeDriver(driverType);
        driver.manage().window().maximize();
        wait = new FluentWait<>(driver).withTimeout(Duration.ofMillis(WAIT_MILLS))
                                       .pollingEvery(Duration.ofMillis(POLLING_MILLS))
                                       .ignoring(NoSuchElementException.class);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void loadPage(String url) {
        driver.get(url);
    }

    public String getPageSource() {
        return driver.getPageSource().toLowerCase();
    }

    public WebElement waitForElementToBeDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitPageLoad() {
        wait.until(
            driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }

    public WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void click(WebElement element, boolean clickButton) {
        if (clickButton) {
            element.click();
        } else {
            element.sendKeys(Keys.ENTER);
        }
    }

    public void storeElementsToList(By locator, List<WebElement> elements) {
        elements.addAll(findElements(locator));
    }

    public WebElement getMatchedElement(List<WebElement> elements, String match) {
        return elements.stream().filter(n -> n.getText().toLowerCase().contains(match.toLowerCase())).findFirst()
                       .orElseThrow(() -> new NotFoundException(match + " is missing in the result"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
