package com.automation.test.framework.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement inputTextBar;

    @FindBy(xpath = "//div[3]/center/input[1]")
    private WebElement searchButton;

    public void searchSomething(String text){
        waiter.waitForElementToBeDisplayed(inputTextBar);
        enterText(inputTextBar, text);
        waiter.waitForElementToBeDisplayed(searchButton);
        clickOnElement(searchButton);
    }

}
