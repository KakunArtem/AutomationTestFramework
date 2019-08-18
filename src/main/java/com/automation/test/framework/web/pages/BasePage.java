package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.utils.Waiters;
import org.openqa.selenium.*;

import java.util.List;
import java.util.NoSuchElementException;

import static com.automation.test.framework.web.driver.Driver.actions;
import static com.automation.test.framework.web.driver.Driver.driver;
import static org.junit.Assert.assertTrue;

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

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void assertCurrentUrl(String url) {
        try {
            assertTrue(getCurrentUrl().toLowerCase().contains(url.toLowerCase()));
        } catch (AssertionError e) {
            throw new RuntimeException("Current url does not contains in url: " + url);
        }
    }

    public void assertTextOnWebElement(WebElement element, String expectedText) {
        try {
            String actualText = element.getText();
            assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()));
        } catch (AssertionError e) {
            throw new RuntimeException(element + " does not contains text: " + expectedText);
        }
    }

    public void assertPageContainsText(String text) {
        try {
            assertTrue(driver.getPageSource().toLowerCase().contains(text.toLowerCase()));
        } catch (AssertionError e) {
            throw new RuntimeException("Page does not contains text:" + text);
        }
    }


}
