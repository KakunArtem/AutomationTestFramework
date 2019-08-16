package stepDefinitions;

import com.automation.test.framework.api.client.UserRestClient;
import com.automation.test.framework.api.dto.GeneratedUser;
import com.automation.test.framework.api.testContext.TestSession;
import com.automation.test.framework.web.pages.BasePage;
import com.automation.test.framework.web.pages.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.openqa.selenium.support.PageFactory;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static com.automation.test.framework.web.driver.Driver.driver;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDefinitionsSteps {
    private UserRestClient userRestClient = new UserRestClient();

    BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String include, String format) {
        Response response = userRestClient.getDefaultTestUser(include, format);
        TestSession.storeValue(USER, response);
        TestSession.storeUserFullName(USER, USER_FULL_NAME);
    }

    @Then("Verify that created user has First name, Last name, location, email, nationality")
    public void verifyThatCreatedUserHasFirstNameLastNameLocationEmailNationality() {
        GeneratedUser generatedUser = getValueFromSession(USER, Response.class).then()
                                                 .statusCode(SC_OK)
                                                 .extract().as(GeneratedUser.class);

        assertThat(generatedUser.getResults().get(0)).isNotNull();
        assertThat(generatedUser.getResults().get(0).getLocation()).isNotNull();
        assertThat(generatedUser.getResults().get(0).getName().getFirst()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getName().getLast()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getEmail()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getNat()).isNotEmpty();
    }

    @Then("Go to site: '(.*)'")
    public void goToSite(String site) {
        basePage.goToPage(site);
    }


    @And("Search for user`s full name")
    public void searchForUserSFullName() {
        searchPage.makeSearchRequest(getValueFromSession(USER_FULL_NAME));
    }

}
