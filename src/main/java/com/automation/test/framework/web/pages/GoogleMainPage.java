package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driver.WebDriverHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleMainPage {
    @Autowired
    private WebDriverHome webDriverHome;

    public void openURL(String url) {
        webDriverHome.goToPage(url);
    }

    public void search(String searchRequest) {
        webDriverHome.findElement(GoogleMainPageSelectors.INPUT_TEXT_BAR)
                .sendKeys(searchRequest);
        webDriverHome.click(
                webDriverHome.waitForElementToBeClickable(GoogleMainPageSelectors.SEARCH_BUTTON), false);
    }

}
