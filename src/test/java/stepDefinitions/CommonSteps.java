package stepDefinitions;

import com.automation.test.framework.web.driver.WebDriverHome;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonSteps {

    @Autowired
    WebDriverHome webDriverHome;

    @When("I print something")
    public void soutSomething() {
        System.out.println("Browser didn`t start");
    }

    @Then("Close Driver")
    public void stopDriver() {
        webDriverHome.quitDriver();
    }
}

//this class will be deleted