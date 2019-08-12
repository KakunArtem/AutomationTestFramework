package com.automation.test.framework.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestAssuredConfig {
    public static RequestSpecification getHttpClient(){
        return given().spec(new RequestSpecBuilder()
                                .addFilter(new ResponseLoggingFilter())
                                .addFilter(new RequestLoggingFilter()).build());
    }

}
