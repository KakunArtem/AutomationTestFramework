package com.automation.test.framework.api.client;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class UserRestClient extends BaseRestClient {
    private static final String INCLUDE_FIELDS_PARAM = "inc";
    private static final String EXCLUDE_FIELDS_PARAM = "exc";
    private static final String MULTIPLE_USERS_PARAM = "results";
    private static final String CERTAIN_GENDER_USER_PARAM = "gender";
    private static final String PASSWORD_PARAM = "password";
    private static final String SEEDS_PARAM = "seed";
    private static final String FORMAT_PARAM = "format";
    private static final String NATIONALITY_PARAM = "format";

    public Response getDefaultUser() {
        return getRequest().get();
    }

    public Response getDefaultTestUser(String params, String format) {
        return getRequest().queryParam(INCLUDE_FIELDS_PARAM, params)
                .queryParam(FORMAT_PARAM, format)
                .get();
    }

    public Response getUserIncludeFields(String fields) {
        return getRequest().queryParam(INCLUDE_FIELDS_PARAM, fields).get();
    }

    public Response getUserExcludeFields(String fields) {
        return getRequest().queryParam(EXCLUDE_FIELDS_PARAM, fields).get();
    }

    public Response getMultipleUsers(int users) {
        return getRequest().queryParam(MULTIPLE_USERS_PARAM, users).get();
    }

    public Response getUserCertainGender(String gender) {
        return getRequest().queryParam(CERTAIN_GENDER_USER_PARAM, gender).get();
    }

    public Response getUserWithPasswordParams(String params) {
        return getRequest().queryParam(PASSWORD_PARAM, params).get();
    }

    public Response getUserWithSeeds(String seeds) {
        return getRequest().queryParam(SEEDS_PARAM, seeds).get();
    }

    public Response getUserInFormat(String format) {
        List<String> availableFormats = Arrays.asList(
                "json", "PrettyJSON", "Pretty",
                "CSV", "YAML", "XML");

        Boolean formatIsPresent = availableFormats.stream()
                .anyMatch(n -> n.equalsIgnoreCase(format));
        if (!formatIsPresent) {
            throw new NoSuchElementException("This format is not supported.");
        } else {
            return getRequest().queryParam(FORMAT_PARAM, format).get();
        }
    }

    public Response getUserWithNationality(String nationality) {
        List<String> availableNationalities = Arrays.asList(
                "AU", "BR", "CA", "CH", "DE", "DK",
                "ES", "FI", "FR", "GB", "IE", "IR",
                "NO", "NL", "NZ", "TR", "US");

        Boolean nationalityIsPresent = availableNationalities.stream()
                .anyMatch(n -> n.equalsIgnoreCase(nationality));
        if (!nationalityIsPresent) {
            throw new NoSuchElementException("This nationality is not supported.");
        } else {
            return getRequest().queryParam(NATIONALITY_PARAM, nationality).get();
        }
    }

}
