package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driverV2.WebDriverHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleMainPage {

    @Autowired
    private WebDriverHome webDriverHome;

    @Autowired
    public GoogleMainPage(WebDriverHome webDriverHome) {
        this.webDriverHome = webDriverHome;
    }

    @FindBy(css = "input[class='gLFyf gsfi']")
    public WebElement inputTextBar;

    @FindBy(xpath = "(//input[@class='gNO89b'])[2]")
    public WebElement searchButton;

    @FindBy(xpath = "(//input[@class='gNO89b'])[1]")
    public WebElement searchButtonInDropDown;

    @FindBy(css = "div[class='aajZCb']")
    public WebElement suggestionDropdown;


    public void openURL(String url){
        webDriverHome.goToPage(url);
    }

    public void search(String searchRequest){
        webDriverHome.findElement(inputTextBar)
                     .sendKeys(searchRequest);
        webDriverHome.click(
            webDriverHome.waitForElementToBeClickable(searchButton), false);
    }

}
