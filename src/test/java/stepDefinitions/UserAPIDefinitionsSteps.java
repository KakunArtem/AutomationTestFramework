package stepDefinitions;

import com.automation.test.framework.api.client.UserRestClient;
import com.automation.test.framework.api.service.UserService;
import com.automation.test.framework.api.utils.DataStoreUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.storeValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserAPIDefinitionsSteps {
    private UserService userService = new UserService();

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String parameters, String format) {
        userService.createAndStoreDefaultUser(USER, parameters, format);
    }

    @And("Store user`s full name")
    public void saveUserFullName() {
        userService.storeUserFullName(USER_FULL_NAME);
    }
}
