package stepDefinitions;

import com.automation.test.framework.web.pages.GoogleMainPage;
import com.automation.test.framework.web.pages.GoogleResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class GoogleSearchDefinitionsSteps {
    private final GoogleMainPage googleMainPage;
    private final GoogleResultsPage googleResultsPage;

    public GoogleSearchDefinitionsSteps(GoogleMainPage page, GoogleResultsPage resultsPage) {
        googleMainPage = page;
        googleResultsPage = resultsPage;
    }

    @Then("Go to page: '(.*)'")
    public void goToSite(String site) {
        googleMainPage.openURL(site);
    }

    @And("Search for user`s full name")
    public void searchForUsersFullName() {
//        googleMainPage.search(getValueFromSession(USER_FULL_NAME));
        googleMainPage.search("reddit");
    }


    @Then("Go to '(.*)' from the results page")
    public void goToPageFromResults(String page) {
        googleResultsPage.goToPageFromResult(page);
    }

}
