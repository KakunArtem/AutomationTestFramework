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
    "large",
    "medium",
    "thumbnail"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Picture {
    @JsonProperty("large")
    private String large;
    @JsonProperty("medium")
    private String medium;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
