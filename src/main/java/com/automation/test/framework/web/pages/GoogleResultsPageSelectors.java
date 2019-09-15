package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.utils.Selectors;
import org.openqa.selenium.By;

public enum GoogleResultsPageSelectors implements Selectors {
    SEARCH_RESULT_LINKS(By.cssSelector("div[class='TbwUpd']"));

    private By locator;

    GoogleResultsPageSelectors (By locator){
        this.locator = locator;
    }

    public By getLocator(){
        return locator;
    }

}
