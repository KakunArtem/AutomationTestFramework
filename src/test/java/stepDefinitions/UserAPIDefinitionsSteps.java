package stepDefinitions;

import com.automation.test.framework.api.client.UserRestClient;
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
    private UserRestClient userRestClient = new UserRestClient();
    private DataStoreUtils dataStoreUtils = new DataStoreUtils();

    private static final String FIRST_NAME_FIELD = "first";
    private static final String LAST_NAME_FIELD = "last";

    @Given("New user with parameters: '(.*)', '(.*)' was created")
    public void createUserWithParameters(String parameters, String format) {
        Response response = userRestClient.getDefaultTestUser(parameters, format);
        storeValue(USER, response);
    }

    @Then("Verify that created user has first name and last name")
    public void verifyThatCreatedUserHasFirstAndLastName() {
        assertThat("Field 'first' is empty! ",
                dataStoreUtils.getFieldValueAsString(USER, FIRST_NAME_FIELD).isEmpty(), is(false));
        assertThat("Field 'last' is empty! ",
                dataStoreUtils.getFieldValueAsString(USER, LAST_NAME_FIELD).isEmpty(), is(false));

    }

    @And("Save user`s full name")
    public void saveUserFullName() {
        String fullName = new StringBuilder()
                .append(dataStoreUtils.getFieldValueAsString(USER, FIRST_NAME_FIELD))
                .append(" ")
                .append(dataStoreUtils.getFieldValueAsString(USER, LAST_NAME_FIELD))
                .toString();
        storeValue(USER_FULL_NAME, fullName);
    }
}
