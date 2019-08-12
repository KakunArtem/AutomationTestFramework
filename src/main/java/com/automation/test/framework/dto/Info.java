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
public class Info extends GeneratedUser {
    @JsonProperty("@seed")
    private String seed;
    @JsonProperty("@page")
    private String page;
    @JsonProperty("@version")
    private String version;
}
