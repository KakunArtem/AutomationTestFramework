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
        "seed",
        "results",
        "page",
        "version"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    @JsonProperty("seed")
    private String seed;
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
