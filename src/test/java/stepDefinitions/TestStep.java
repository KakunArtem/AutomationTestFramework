package stepDefinitions;

import cucumber.api.java.en.When;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestStep {

    @When("always true")
    public void alwaysTrue(){
        Boolean truth = true;
        assertThat(" does not contains user`s full name.", true, is(true));
    }

    @When("Fifty fifty true")
    public void fiftyTrue(){
        Boolean truth = true;
        assertThat(" does not contains user`s full name.", true, is(true));
        Random s = new Random();
        Boolean random = s.nextBoolean();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Random test");
        System.out.println("------------------------------------------------------------------------------------------");
        assertThat("Rundom boolean",
                   random, is(true));
    }







}
