package stepDefinitions;

import com.automation.test.framework.api.client.UserCreationRestClient;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;

import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
public class UserDefinitionsSteps {
    private UserCreationRestClient userCreationRestClient;
    private static final String AVENGERS = "avengers";

    @Given("Transmit string '(.*)'")
    public void transmitString(String string) {
      assertThat("String isn`t equals",string.equals(AVENGERS));
        Response response = userCreationRestClient.getUser();
    }


}
