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
        userService.createAndStoreDefaultTestUser(parameters, format);
    }

    @Then("Verify that created user has First name, Last name, location, email, nationality")
    public void verifyThatCreatedUserHasFirstNameLastNameLocationEmailNationality() {
        userService.assertDefaultTestUserCreated();
    }

    @Given("parse json")
    public void parseJson() {
        userService.storeUserFullName(USER, USER_FULL_NAME);
//        System.out.println(TestSession.getValueFromSession(USER_FULL_NAME));




    }
}
