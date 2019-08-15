package stepDefinitions;

import com.automation.test.framework.api.client.CreateUserRestClient;
import com.automation.test.framework.api.dto.GeneratedUser;
import com.automation.test.framework.api.testContext.TestSession;
import com.automation.test.framework.web.pages.BasePage;
import com.automation.test.framework.web.pages.SearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import org.openqa.selenium.support.PageFactory;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.web.driver.Driver.driver;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class UserDefinitionsSteps {
    private CreateUserRestClient createUserRestClient = new CreateUserRestClient();

    BasePage basePage = PageFactory.initElements(driver, BasePage.class);
    SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String include, String format) {
        Response response = createUserRestClient.getDefaultTestUser(include, format);
        TestSession.storeValue(USER, response);
    }

    @Then("Verify that created user has First name, Last name, location, email, nationality")
    public void verifyThatCreatedUserHasFirstNameLastNameLocationEmailNationality() {
        GeneratedUser generatedUser =
            TestSession.getValueFromSession(USER, Response.class).then()
                       .statusCode(SC_OK)
                       .extract().as(GeneratedUser.class);

        assertThat(generatedUser.getResults().get(0)).isNotNull();
        assertThat(generatedUser.getResults().get(0).getLocation()).isNotNull();
        assertThat(generatedUser.getResults().get(0).getName().getFirst()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getName().getLast()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getEmail()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getNat()).isNotEmpty();
    }

    @Then("Go to '(.*)' and search for user`s name and second name")
    public void goToSite(String site) throws InterruptedException {
        basePage.goToPage(site);
        searchPage.searchSomething(" tako");



    }

}
