package com.automation.test.framework.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultsPage extends BasePage {
    private List<WebElement> webElementsList = new ArrayList<>();

    private By searchResultLinks = By.xpath("//div[@class='r']/a[@href][1]");

    public void goToPageFromResults(String pageName) {
        try {
            storeElementsToList(searchResultLinks, webElementsList);
            clickOnElement(getMatchedElement(webElementsList, pageName));
            waiter.sleep(10);
        } catch (RuntimeException exception) {
            throw new RuntimeException(pageName + " is missing in a results. " + exception.getMessage());
        }
    }
}
