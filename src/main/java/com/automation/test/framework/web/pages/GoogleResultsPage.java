package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.driverV2.WebDriverHome;
import org.openqa.selenium.By;
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

    public By searchResultLinks = By.cssSelector("div[class='TbwUpd']");

    public List<WebElement> storeSearchResults(){
        List<WebElement> webElementsList = new ArrayList<>();
        webElementsList.addAll(webDriverHome.findElements(searchResultLinks));
        return webElementsList;
    }

    public void goToPageFromResult(String page){
        List<WebElement> results = storeSearchResults();
        webDriverHome.getMatchedElement(results, page);
    }

}
