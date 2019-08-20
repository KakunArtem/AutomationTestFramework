package com.automation.test.framework.api.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;

import java.io.IOException;

import static com.automation.test.framework.api.testContext.Context.USER;
import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;

public class JsonParser {
    public String getFieldValueAsString(String fieldName) {
        try {
            String generatedUser = getValueFromSession(USER, Response.class)
                .then()
                .extract()
                .asString();
            ObjectNode node = new ObjectMapper().readValue(generatedUser, ObjectNode.class);
            JsonNode fieldValue = node.findValue(fieldName.toLowerCase());
            if(fieldValue == null) {
                throw new NullPointerException();
            } else {
                return fieldValue.asText();
            }
        } catch (IOException | NullPointerException  e) {
            throw new RuntimeException(
                String.format("Field '%s' does not exist or does not contain a value. %s", fieldName, e));
        }
    }
}
