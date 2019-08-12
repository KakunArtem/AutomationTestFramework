package stepDefinitions;

import cucumber.api.java.en.Given;
import lombok.AllArgsConstructor;

import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
public class UserDefinitionsSteps {
    private static final String AVENGERS = "avengers";

    @Given("Transmit string '(.*)'")
    public void transmitString(String string) {
      assertThat("String isn`t equals",string.equals(AVENGERS));
    }


}
