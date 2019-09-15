package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driver.WebDriverHome;
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

    public Boolean validatePageUrl(String page){
        return webDriverHome.getCurrentUrl().equals(page);
    }

    public Boolean pageContainsText(String text){
        return webDriverHome.getPageSource().contains(text);
    }

}
