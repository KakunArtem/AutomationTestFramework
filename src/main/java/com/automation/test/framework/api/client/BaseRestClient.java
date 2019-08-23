package com.automation.test.framework.api.client;

import com.automation.test.framework.api.utils.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

import static com.automation.test.framework.configs.ConfigConstants.API_HOST;
import static com.automation.test.framework.configs.ConfigProvider.getConfiguration;

class BaseRestClient extends RestAssuredConfig {

    private String getBaseUri() {
        return getConfiguration().getString(API_HOST);
    }

    protected RequestSpecification getRequest() {
        return  getHttpClient().baseUri(getBaseUri());
    }
}
