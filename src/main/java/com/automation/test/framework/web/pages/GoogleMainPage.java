package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driver.WebDriverHome;

public class GoogleMainPage {
    private final WebDriverHome webDriverHome;

    public GoogleMainPage(WebDriverHome webDriverHome) {
        this.webDriverHome = webDriverHome;
    }

    public void openURL(String url){
        webDriverHome.goToPage(url);
    }

    public void search(String searchRequest){
        webDriverHome.findElement(GoogleMainPageSelectors.INPUT_TEXT_BAR)
                     .sendKeys(searchRequest);
        webDriverHome.click(
            webDriverHome.waitForElementToBeClickable(GoogleMainPageSelectors.SEARCH_BUTTON), false);
    }

}
