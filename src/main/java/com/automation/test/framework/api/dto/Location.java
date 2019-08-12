package com.automation.test.framework.api.dto;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @JsonProperty("@street")
    private String street;
    @JsonProperty("@city")
    private String city;
    @JsonProperty("@state")
    private String state;
    @JsonProperty("@postcode")
    private String postcode;
    @JsonProperty("@coordinates")
    private Coordinates coordinates;
    @JsonProperty("@timezone")
    private Timezone timezone;

}
