package com.automation.test.framework.api.client;

import io.restassured.response.Response;

public class UserCreationRestClient extends BaseRestClient {
    public Response getUser(){
        return getRequest().get();
    }





}
