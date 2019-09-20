package com.automation.test.framework.api.utils;

import com.automation.test.framework.api.testContext.Context;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.automation.test.framework.api.testContext.TestSession.getValueFromSession;
@Component
public class DataStoreUtils {

    public String convertDataStoreToString(Context dataStore) {
        try {
            return getValueFromSession(dataStore, Response.class).then().extract().asString();
        } catch (NullPointerException e) {
            throw new RuntimeException(
                String.format("Data store '%s' is empty. %s", dataStore, e));
        }
    }

    public String getFieldValueAsString(Context dataStore, String fieldName) {
        try {
            String generatedDataStore = convertDataStoreToString(dataStore);
            JsonNode fieldValue =
                new ObjectMapper().readTree(generatedDataStore)
                                  .findValue(fieldName.toLowerCase());
            if (ObjectUtils.isEmpty(fieldValue)) {
                throw new NullPointerException();
            }
            return fieldValue.asText();
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(
                String.format("Field '%s' does not exist or does not contain a value. %s", fieldName, e));
        }
    }


}
