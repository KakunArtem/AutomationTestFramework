package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driver.WebDriverHome;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleResultsPage {

    @Autowired
    private WebDriverHome webDriverHome;

    @Autowired
    public GoogleResultsPage(WebDriverHome webDriverHome) {
        this.webDriverHome = webDriverHome;
    }

    public List<WebElement> storeSearchResults(){
        List<WebElement> webElementsList = new ArrayList<>();
        webElementsList.addAll(webDriverHome.findElements(GoogleResultsPageSelectors.SEARCH_RESULT_LINKS));
        return webElementsList;
    }

    public void goToPageFromResult(String page){
        List<WebElement> results = storeSearchResults();
        webDriverHome.getMatchedElement(results, page);
    }

}
