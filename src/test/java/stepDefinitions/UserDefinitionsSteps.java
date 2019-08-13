package stepDefinitions;

import com.automation.test.framework.api.client.CreateUserRestClient;
import com.automation.test.framework.api.dto.GeneratedUser;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;

import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
public class UserDefinitionsSteps {
    private CreateUserRestClient createUserRestClient;
    private static final String AVENGERS = "avengers";

    @Given("Create new user with parameters: '(.*)', '(.*)'")
    public void createUserWithParameters(String include, String format) {
        Response response = createUserRestClient.getCustomUser(include,format);
        GeneratedUser generatedUser = response.then().statusCode(200).extract().as(GeneratedUser.class);

        generatedUser.getResults().get(0).getLocation().getCity();
        Assertions.assertThat(generatedUser).isNotNull();
    }


    @Given("Transmit string '(.*)'")
    public void transmitString(String string) {
      assertThat("String isn`t equals",string.equals(AVENGERS));
        Response response = createUserRestClient.getDefaultUser();


    }


}
