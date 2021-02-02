package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cover {
    @JsonProperty("small")
    private String smallUrl;

    @JsonProperty("medium")
    private String mediumUrl;

    @JsonProperty("large")
    private String largeUrl;

    public String getSmallUrl() {
        return smallUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }
}
