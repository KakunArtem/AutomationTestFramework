package com.automation.test.framework.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {
    private static By inputTextBarSelector = By.cssSelector("input[class='gLFyf gsfi']");
    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement inputTextBar;

    @FindBy(xpath = "//div[3]/center/input[1]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[2]/center/input[1]")
    private WebElement searchButtonInDropDown;

    @FindBy(xpath = "//div[@jscontroller='tg8oTe']")
    private WebElement suggestionDropdown;

    @FindBy(css ="div[class='aajZCb']")
    private WebElement smallSuggestionDropdown;

    public void makeSearchRequest(String text) {
        try {
            waiter.waitForElementToBeDisplayed(inputTextBar);
            enterText(inputTextBar, text);
            if (elementIsDisplayed(suggestionDropdown)||elementIsDisplayed(smallSuggestionDropdown)) {
                pressENTER(inputTextBarSelector);
            } else
                clickOnElement(searchButton);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException("Exception: " + e.getMessage());
        }
    }

//    We don`t check button in the test. So the simple version of the method can be applied.
//    public void makeSearchRequest(String text){
//        waiter.waitForElementToBeDisplayed(inputTextBar);
//        enterText(inputTextBar,text);
//        pressENTER(inputTextBarSelector);
//    }
}
