package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driver.WebDriverHome;


public class FacebookCommonElementsPage {

    private WebDriverHome webDriverHome;

    public FacebookCommonElementsPage (WebDriverHome webDriverHome) {
        this.webDriverHome = webDriverHome;
    }

    public Boolean validatePageUrl(String page){
        return webDriverHome.getCurrentUrl().equals(page);
    }

    public Boolean pageContainsText(String text){
        return webDriverHome.getPageSource().contains(text);
    }

}
