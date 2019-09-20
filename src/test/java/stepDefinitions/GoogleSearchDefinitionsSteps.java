package stepDefinitions;

import com.automation.test.framework.web.pages.GoogleMainPage;
import com.automation.test.framework.web.pages.GoogleResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;

public class GoogleSearchDefinitionsSteps {
    @Autowired
    private GoogleMainPage googleMainPage;

    @Autowired
    private GoogleResultsPage googleResultsPage;

    @Then("Go to page: '(.*)'")
    public void goToSite(String site) {
        googleMainPage.openURL(site);
    }

    @And("Search for user`s full name")
    public void searchForUsersFullName() {
        googleMainPage.search(getValueFromSession(USER_FULL_NAME));
    }

    @Then("Go to '(.*)' from the results page")
    public void goToPageFromResults(String page) {
        googleResultsPage.goToPageFromResult(page);
    }
}
