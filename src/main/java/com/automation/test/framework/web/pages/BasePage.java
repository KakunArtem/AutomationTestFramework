package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.utils.Waiters;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.automation.test.framework.web.driver.Driver.actions;
import static com.automation.test.framework.web.driver.Driver.driver;

public class BasePage {
    Waiters waiter = new Waiters(driver);

    public void goToPage(String page) {
        driver.get(page);
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
            clickUsingActions(element);
        }
    }

    public void clickOnElement(By locator) {
        try {
            waiter.waitForElementToBeClickable(locator).click();
        } catch (WebDriverException e) {
            clickUsingActions(findElement(locator));
        }
    }

    public void clickUsingActions(WebElement element) {
        try {
            actions.click(element).build().perform();
        } catch (WebDriverException e) {
            throw new RuntimeException("Can't click on element: " + element);
        }
    }

    public boolean elementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean elementIsDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean elementIsEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean elementIsEnabled(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterText(WebElement element, String text) {
        waiter.waitForElementToBeClickable(element);
        element.clear();
        element.click();
        element.sendKeys(text);
    }

    public void storeElementsToList(By locator, List<WebElement> elements) {
        elements.addAll(findElements(locator));
    }

    public WebElement getMatchedElement(List<WebElement> elements, String match) {
        return elements
                .stream()
                .filter(n -> n.getText().toLowerCase().contains(match.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No matching element!"));
    }

    public void pressENTERButton(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
}
