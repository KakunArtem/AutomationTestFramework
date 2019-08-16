package com.automation.test.framework.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {

    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement inputTextBar;

    @FindBy(xpath = "//div[3]/center/input[1]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[2]/center/input[1]")
    private WebElement searchButtonInDropDown;

    public void makeSearchRequest(String text) {
        try {
            waiter.waitForElementToBeDisplayed(inputTextBar);
            enterText(inputTextBar, text);
            clickOnElement(searchButtonInDropDown);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }
}
