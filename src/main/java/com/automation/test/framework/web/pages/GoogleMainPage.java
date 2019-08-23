package com.automation.test.framework.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMainPage {

    @FindBy(css = "input[class='gLFyf gsfi']")
    public WebElement inputTextBar;

    @FindBy(xpath = "(//input[@class='gNO89b'])[2]")
    public WebElement searchButton;

    @FindBy(xpath = "(//input[@class='gNO89b'])[1]")
    public WebElement searchButtonInDropDown;

    @FindBy(css = "div[class='aajZCb']")
    public WebElement suggestionDropdown;
}
