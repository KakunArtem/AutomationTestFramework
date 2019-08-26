package com.automation.test.framework.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookCommonElementsPage {

    @FindBy(xpath = "//div/input[@class='_1frb']")
    public WebElement headerSearchBar;

    @FindBy(css = "h1[class='__ck']")
    public WebElement peoplesWithName;

    @FindBy(css = "a[class='_2nlw _2nlv']")
    public WebElement profileName;
}
