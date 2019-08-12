package com.automation.test.framework.dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    @JsonProperty("@gender")
    private String gender;
    @JsonProperty("@name")
    private Name name;
    @JsonProperty("@location")
    private Location location;
    @JsonProperty("@email")
    private String email;
    @JsonProperty("@nat")
    private String nat;
}
