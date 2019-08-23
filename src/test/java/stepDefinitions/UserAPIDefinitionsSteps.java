package stepDefinitions;

import com.automation.test.framework.api.service.UserService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;

public class UserAPIDefinitionsSteps {
    private UserService userService = new UserService();

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String parameters, String format) {
        userService.createAndStoreDefaultTestUser(USER, parameters, format);
        userService.storeUserFullName(USER, USER_FULL_NAME);
    }

    @Then("Verify that created user has First name, Last name")
    public void verifyThatCreatedUserHasFirstAndLastName() {
        userService.assertUserHasFirstAndLastName(USER);
    }

    @Then("parse Json")
    public void parseJson() {
        userService.storeUserFullName(USER, USER_FULL_NAME);
        userService.assertUserHasFirstAndLastName(USER);

    }
}
