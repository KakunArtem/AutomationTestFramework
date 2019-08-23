package com.automation.test.framework.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookCommonElementsPage {

    @FindBy(xpath = "//div/input[2]")
    public WebElement headerSearchBar;

    @FindBy(xpath = "//div/h1/strong")
    public WebElement peoplesWithName;

    @FindBy(xpath = "//h1/span/a")
    public WebElement profileName;
}
