package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driverV2.WebDriverHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookCommonElementsPage {

    @Autowired
    private WebDriverHome webDriverHome;

    @Autowired
    public FacebookCommonElementsPage (WebDriverHome webDriverHome) {
        this.webDriverHome = webDriverHome;
    }

    @FindBy(xpath = "//div/input[@class='_1frb']")
    public WebElement headerSearchBar;

    @FindBy(css = "h1[class='__ck']")
    public WebElement peoplesWithName;

    @FindBy(css = "a[class='_2nlw _2nlv']")
    public WebElement profileName;

    public Boolean validatePageUrl(String page){
        return webDriverHome.getCurrentUrl().equals(page);
    }

    public Boolean pageContainsText(String text){
        return webDriverHome.getPageSource().contains(text);
    }

}
