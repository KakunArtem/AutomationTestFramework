package com.automation.test.framework.api.service;

import com.automation.test.framework.api.client.UserRestClient;
import com.automation.test.framework.api.testContext.Context;
import com.automation.test.framework.api.utils.DataStoreUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.TestSession.storeValue;
@Component
public class UserService {
    @Autowired
    private UserRestClient userRestClient;
    @Autowired
    private DataStoreUtils dataStoreUtils;

    private static final String FIRST_NAME_FIELD = "first";
    private static final String LAST_NAME_FIELD = "last";

    public void createAndStoreDefaultUser(Context storage, String parameters, String format){
        Response response = userRestClient.getDefaultTestUser(parameters, format);
        storeValue(storage, response);
    }

    public void storeUserFullName(Context storage){
        String fullName = new StringBuilder()
                .append(dataStoreUtils.getFieldValueAsString(USER, FIRST_NAME_FIELD))
                .append(" ")
                .append(dataStoreUtils.getFieldValueAsString(USER, LAST_NAME_FIELD))
                .toString();
        storeValue(storage, fullName);
    }

}
