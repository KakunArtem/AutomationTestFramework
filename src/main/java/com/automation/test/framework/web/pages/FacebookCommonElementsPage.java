package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driver.WebDriverHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacebookCommonElementsPage {
    @Autowired
    private WebDriverHome webDriverHome;

    public Boolean validatePageUrl(String page) {
        return webDriverHome.getCurrentUrl().toLowerCase().contains(page.toLowerCase());
    }

    public Boolean pageContainsText(String text) {
        return webDriverHome.getPageSource().contains(text.toLowerCase());
    }

}
