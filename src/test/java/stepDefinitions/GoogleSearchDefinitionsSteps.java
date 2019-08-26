package stepDefinitions;

import com.automation.test.framework.web.driver.DriverManager;
import com.automation.test.framework.web.pages.GoogleMainPage;
import com.automation.test.framework.web.pages.GoogleResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;

public class GoogleSearchDefinitionsSteps {
    private DriverManager driverManager = new DriverManager();
    private GoogleMainPage googleMainPage =
            PageFactory.initElements(driverManager.getDriver(), GoogleMainPage.class);
    private GoogleResultsPage googleResultsPage =
            PageFactory.initElements(driverManager.getDriver(), GoogleResultsPage.class);

    @Then("Go to page: '(.*)'")
    public void goToSite(String site) {
        driverManager.goToPage(site);
    }

    @And("Search for user`s full name")
    public void searchForUsersFullName() {
        driverManager.findElement(googleMainPage.inputTextBar)
                .sendKeys(getValueFromSession(USER_FULL_NAME));
        driverManager.click(
                driverManager.waitForElementToBeClickable(googleMainPage.searchButton), false);
    }

    @Then("Go to '(.*)' from the results page")
    public void goToPageFromResults(String page) {
        List<WebElement> webElementsList = new ArrayList<>();
        webElementsList.addAll(driverManager.findElements(googleResultsPage.searchResultLinks));
        driverManager.getMatchedElement(webElementsList, page).click();
    }

}
