package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Cover {
    @JsonProperty("small")
    private String smallUrl;

    @JsonProperty("medium")
    private String mediumUrl;

    @JsonProperty("large")
    private String largeUrl;
}
