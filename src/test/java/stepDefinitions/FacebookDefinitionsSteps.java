package stepDefinitions;

import com.automation.test.framework.api.testContext.Context;
import com.automation.test.framework.web.driver.DriverManager;
import com.automation.test.framework.web.pages.FacebookCommonElementsPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.PageFactory;

import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static org.hamcrest.MatcherAssert.assertThat;

public class FacebookDefinitionsSteps {
    private DriverManager driverManager = new DriverManager();
    private FacebookCommonElementsPage facebookCommonElementsPage =
        PageFactory.initElements(driverManager.getDriver(), FacebookCommonElementsPage.class);


    @And("As an unregistered user verify that '(.*)' has a profile for the current user name")
    public void verifyThatUserProfileExists(String page) {
        assertThat("Current page is not: " + page, driverManager.getCurrentUrl().toLowerCase().
            contains(page.toLowerCase()));
        assertThat(page + " does not contains current user name.",
                   driverManager.getPageSource().contains(getValueFromSession(Context.USER_FULL_NAME)));
    }
}
