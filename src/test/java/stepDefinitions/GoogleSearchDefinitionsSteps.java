package stepDefinitions;

import com.automation.test.framework.web.pages.BasePage;
import com.automation.test.framework.web.pages.GoogleMainPage;
import com.automation.test.framework.web.pages.GoogleResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static com.automation.test.framework.web.driver.Driver.driver;

public class GoogleSearchDefinitionsSteps {
    private BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    private GoogleMainPage googleMainPage = PageFactory.initElements(driver, GoogleMainPage.class);
    private GoogleResultsPage googleResultsPage = PageFactory.initElements(driver, GoogleResultsPage.class);

    @Then("Go to site: '(.*)'")
    public void goToSite(String site) {
        basePage.goToPage(site);
    }


    @And("Search for user`s full name")
    public void searchForUsersFullName() {
        googleMainPage.makeSearchRequest(getValueFromSession(USER_FULL_NAME));
    }

    @Then("Go to '(.*)' from the results page")
    public void getResultFromList(String page) {
        googleResultsPage.goToPageFromResults(page);
    }

}
