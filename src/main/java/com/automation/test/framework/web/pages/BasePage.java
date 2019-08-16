package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.utils.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.automation.test.framework.web.driver.Driver.actions;
import static com.automation.test.framework.web.driver.Driver.driver;

public class BasePage {
    Waiters waiter = new Waiters(driver);

    public void goToPage(String page) {
        try {
            driver.get(page);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void clickOnElement(WebElement element) {
        try {
            waiter.waitForElementToBeClickable(element).click();
        } catch (WebDriverException e) {
            actions.moveToElement(element).click().build().perform();
        }
    }

    public void clickOnElement(By locator) {
        try {
            waiter.waitForElementToBeDisplayed(locator).click();
        } catch (WebDriverException e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public void enterText(WebElement element, String text) {
        waiter.waitForElementToBeClickable(element);
        element.clear();
        element.click();
        element.sendKeys(text);
    }
}
