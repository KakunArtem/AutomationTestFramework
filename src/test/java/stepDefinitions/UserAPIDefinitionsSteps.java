package stepDefinitions;

import com.automation.test.framework.api.service.UserService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;

public class UserAPIDefinitionsSteps {
    private final UserService userService;

    public UserAPIDefinitionsSteps(UserService service) {
        userService = service;
    }

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String parameters, String format) {
        userService.createAndStoreDefaultUser(USER, parameters, format);
    }

    @And("Store user`s full name")
    public void saveUserFullName() {
        userService.storeUserFullName(USER_FULL_NAME);
    }
}
