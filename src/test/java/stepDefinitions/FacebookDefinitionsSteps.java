package stepDefinitions;

import com.automation.test.framework.web.pages.BasePage;
import com.automation.test.framework.web.pages.FacebookCommonElementsPage;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.PageFactory;

import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static com.automation.test.framework.web.driver.Driver.driver;

public class FacebookDefinitionsSteps {
    private BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    private FacebookCommonElementsPage facebookCommonElementsPage = PageFactory.initElements(driver, FacebookCommonElementsPage.class);

    @And("As an unregistered user verify that '(.*)' has a profile for the current user name")
    public void verifyThatUserProfileExists(String page) {
        basePage.assertCurrentUrl(page);
//        facebookCommonElementsPage.verifyThatUserProfileExists(getValueFromSession(USER_FULL_NAME));
        facebookCommonElementsPage.verifyThatUserProfileExistsSimplified(getValueFromSession(USER_FULL_NAME));
    }
}
