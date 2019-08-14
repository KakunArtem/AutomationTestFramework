package stepDefinitions;

import com.automation.test.framework.api.client.CreateUserRestClient;
import com.automation.test.framework.api.dto.GeneratedUser;
import com.automation.test.framework.api.testContext.TestSession;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static com.automation.test.framework.api.testContext.Context.USER;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

@AllArgsConstructor
public class UserDefinitionsSteps {
    private CreateUserRestClient createUserRestClient;
    private static final String AVENGERS = "avengers";

    @Given("Create new user with parameters: '(.*)', '(.*)'")
    public void createUserWithParameters(String include, String format) {
        Response response = createUserRestClient.getDefaultTestUser(include,format);
        TestSession.storeValue(USER, response);


    }

    @Then("Verify that created user has First name, Last name, location, email, nationality")
    public void verifyThatCreatedUserHasFirstNameLastNameLocationEmailNationality() {
        GeneratedUser generatedUser = TestSession.getValueFromSession(USER, Response.class)
                                                 .then().statusCode(SC_OK).extract().as(GeneratedUser.class);

        assertThat(generatedUser.getResults().get(0)).isNotNull();
        assertThat(generatedUser.getResults().get(0).getLocation()).isNotNull();
        assertThat(generatedUser.getResults().get(0).getName().getFirst()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getName().getLast()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getEmail()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getNat()).isNotEmpty();
    }
}
