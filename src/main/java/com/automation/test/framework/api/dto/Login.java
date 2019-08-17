package com.automation.test.framework.api.dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnore;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonInclude;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "uuid",
        "username",
        "password",
        "salt",
        "md5",
        "sha1",
        "sha256"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {
    @JsonProperty("uuid")
    private String uuid;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("salt")
    private String salt;
    @JsonProperty("md5")
    private String md5;
    @JsonProperty("sha1")
    private String sha1;
    @JsonProperty("sha256")
    private String sha256;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
