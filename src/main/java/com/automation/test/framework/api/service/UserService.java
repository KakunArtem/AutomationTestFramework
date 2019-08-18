package com.automation.test.framework.api.service;

import com.automation.test.framework.api.client.UserRestClient;
import com.automation.test.framework.api.dto.GeneratedUser;
import com.automation.test.framework.api.dto.Name;
import com.automation.test.framework.api.testContext.Context;
import io.restassured.response.Response;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.Context.USER_FULL_NAME;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
import static com.automation.test.framework.api.testContext.TestSession.storeValue;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class UserService {
    private UserRestClient userRestClient = new UserRestClient();

    public static void storeUserFullName(Context userFromDataStore, Context newDataStore) {
        GeneratedUser generatedUser = getValueFromSession(userFromDataStore, Response.class)
                .then().extract().as(GeneratedUser.class);

        Name getName = generatedUser.getResults().get(0).getName();
        String fullName = getName.getFirst() + " " + getName.getLast();
        storeValue(newDataStore, fullName);
    }

    public void createAndStoreDefaultTestUser(String parameters, String format) {
        Response response = userRestClient.getDefaultTestUser(parameters, format);
        storeValue(USER, response);
        storeUserFullName(USER, USER_FULL_NAME);
    }

    public void assertDefaultTestUserCreated() {
        GeneratedUser generatedUser = getValueFromSession(USER, Response.class).then()
                .statusCode(SC_OK)
                .extract().as(GeneratedUser.class);

        assertThat(generatedUser.getResults().get(0)).isNotNull();
        assertThat(generatedUser.getResults().get(0).getLocation()).isNotNull();
        assertThat(generatedUser.getResults().get(0).getName().getFirst()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getName().getLast()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getEmail()).isNotEmpty();
        assertThat(generatedUser.getResults().get(0).getNat()).isNotEmpty();
    }
}
