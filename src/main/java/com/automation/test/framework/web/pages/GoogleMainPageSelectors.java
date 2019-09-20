package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.utils.Selectors;
import org.openqa.selenium.By;

public enum GoogleMainPageSelectors implements Selectors {

    INPUT_TEXT_BAR(By.cssSelector("input[class='gLFyf gsfi']")),

    SEARCH_BUTTON(By.xpath("(//input[@class='gNO89b'])[2]")),

    SEARCH_BUTTON_IN_DROP_DOWN(By.xpath("(//input[@class='gNO89b'])[2]")),

    SUGGESTION_DROP_DOWN(By.cssSelector("div[class='aajZCb']"));

    private By locator;

    GoogleMainPageSelectors(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
