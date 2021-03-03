package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifier {
    @JsonProperty("isbn_13")
    private List<String> isbn13;

    @JsonProperty("isbn_10")
    private List<String> isbn10;
}
