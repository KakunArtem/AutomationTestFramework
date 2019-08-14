package com.automation.test.framework.api.client;

import io.restassured.specification.RequestSpecification;

import static com.automation.test.framework.configs.ConfigConstants.API_URI;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;
import static com.automation.test.framework.api.utils.RestAssuredConfig.getHttpClient;

public class BaseRestClient {

    private String getBaseUri() {
        return getConfiguration().getString(API_URI);
    }

    protected RequestSpecification getRequest() {
        return getHttpClient().baseUri(getBaseUri());
    }
}
