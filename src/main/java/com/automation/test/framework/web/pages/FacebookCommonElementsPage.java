package com.automation.test.framework.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookCommonElementsPage extends BasePage {

    @FindBy(xpath = "//div/input[2]")
    private WebElement headerSearchBar;

    @FindBy(xpath = "//div/h1/strong")
    private WebElement peoplesWithName;

    @FindBy(xpath = "//h1/span/a")
    private WebElement profileName;

    public void verifyHeaderSearchBarRequest(String request) {
        assertTextOnWebElement(headerSearchBar, request);
    }

    public void verifyThatUserProfileExists(String userName) {
        if (getCurrentUrl().contains("public/")) {
            waiter.waitForElementToBeDisplayed(peoplesWithName);
            assertTextOnWebElement(peoplesWithName, userName);
        } else {
            waiter.waitForElementToBeDisplayed(profileName);
            assertTextOnWebElement(profileName, userName);
        }
    }

    public void verifyThatUserProfileExistsSimplified(String userName) {
        assertPageContainsText(userName);
    }


}
