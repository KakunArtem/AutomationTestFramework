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
    "gender",
    "name",
    "location",
    "email",
    "login",
    "dob",
    "registered",
    "phone",
    "cell",
    "id",
    "picture",
    "nat"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("email")
    private String email;
    @JsonProperty("login")
    private Login login;
    @JsonProperty("dob")
    private Dob dob;
    @JsonProperty("registered")
    private Registered registered;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("cell")
    private String cell;
    @JsonProperty("id")
    private Id id;
    @JsonProperty("picture")
    private Picture picture;
    @JsonProperty("nat")
    private String nat;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
