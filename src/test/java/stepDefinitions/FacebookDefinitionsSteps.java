package stepDefinitions;

import com.automation.test.framework.web.driver.WebDriverHome;
import com.automation.test.framework.web.pages.FacebookCommonElementsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FacebookDefinitionsSteps {
    private final FacebookCommonElementsPage facebookCommonElementsPage;

    public FacebookDefinitionsSteps(FacebookCommonElementsPage page) {
        facebookCommonElementsPage = page;
    }

    @And("As an unregistered user verify that current '(.*)' page contains user`s full name")
    public void verifyThatPageContainsName(String page) {
        assertThat("Current page is not: " + page,
                   facebookCommonElementsPage.validatePageUrl(page), is(true));

        assertThat(page + " does not contains user`s full name.",
                   facebookCommonElementsPage.pageContainsText(getValueFromSession(USER_FULL_NAME)), is(true));
    }


    private WebDriverHome webDriverHome;
    @Then("Close Driver")
    public void closeDriver(){
        webDriverHome.closeBrowser();
    }

}
