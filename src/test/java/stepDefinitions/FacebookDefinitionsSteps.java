package stepDefinitions;

import com.automation.test.framework.web.driver.DriverManager;
import com.automation.test.framework.web.pages.FacebookCommonElementsPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.PageFactory;

import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FacebookDefinitionsSteps {
    private DriverManager driverManager = new DriverManager();
    private FacebookCommonElementsPage facebookCommonElementsPage =
        PageFactory.initElements(driverManager.getDriver(), FacebookCommonElementsPage.class);

    @And("As an unregistered user verify that current '(.*)' page contains user`s full name")
    public void verifyThatPageContainsName(String page) {
        assertThat("Current page is not: " + page,
                driverManager.getCurrentUrl().toLowerCase().contains(page.toLowerCase()), is(true));
        assertThat(page + " does not contains user`s full name.",
                driverManager.getPageSource().contains(getValueFromSession(USER_FULL_NAME)), is(true));
    }

}
