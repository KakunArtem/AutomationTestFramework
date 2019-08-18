package stepDefinitions;

import com.automation.test.framework.api.service.UserService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UserAPIDefinitionsSteps {
    private UserService userService = new UserService();

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String parameters, String format) {
        userService.createAndStoreDefaultTestUser(parameters, format);
    }

    @Then("Verify that created user has First name, Last name, location, email, nationality")
    public void verifyThatCreatedUserHasFirstNameLastNameLocationEmailNationality() {
        userService.assertDefaultTestUserCreated();
    }

}
