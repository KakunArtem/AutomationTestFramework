package com.automation.test.framework.web.pages;

import com.automation.test.framework.web.utils.Selectors;
import org.openqa.selenium.By;

public enum FacebookCommonElementsPageSelectors implements Selectors {
    HEADER_SEARCH_BAR(By.xpath("//div/input[@class='_1frb']")),

    PROFILE_NAME(By.cssSelector("a[class='_2nlw _2nlv']"));

    private By locator;

    FacebookCommonElementsPageSelectors(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

}
