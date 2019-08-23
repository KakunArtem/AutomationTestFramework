package com.automation.test.framework.api.service;

import com.automation.test.framework.api.client.UserRestClient;
import com.automation.test.framework.api.testContext.Context;
import com.automation.test.framework.api.utils.DataStoreUtils;
import io.restassured.response.Response;

import static com.automation.test.framework.api.testContext.TestSession.storeValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserService {
    private static final String FIRST_NAME_FIELD = "first";
    private static final String LAST_NAME_FIELD = "last";

    private UserRestClient userRestClient = new UserRestClient();
    private DataStoreUtils dataStoreUtils = new DataStoreUtils();

    public void storeUserFullName(Context userFromDataStore, Context newDataStore) {
        String fullName =
            new StringBuilder().append(dataStoreUtils.getFieldValueAsString(userFromDataStore, FIRST_NAME_FIELD))
                               .append(" ")
                               .append(dataStoreUtils.getFieldValueAsString(userFromDataStore, LAST_NAME_FIELD))
                               .toString();

        storeValue(newDataStore, fullName);
    }

    public void createAndStoreDefaultTestUser(Context dataStore, String parameters, String format) {
        Response response = userRestClient.getDefaultTestUser(parameters, format);
        storeValue(dataStore, response);
    }

    public void assertUserHasFirstAndLastName(Context dataStore) {
        String firstName = dataStoreUtils.getFieldValueAsString(dataStore, FIRST_NAME_FIELD);
        String lastName = dataStoreUtils.getFieldValueAsString(dataStore, LAST_NAME_FIELD);

        assertThat("Field 'first' is empty! ", firstName.isEmpty(), is(false));
        assertThat("Field 'last' is empty! ", lastName.isEmpty(), is(false));
    }
}
