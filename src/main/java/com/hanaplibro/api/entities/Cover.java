package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cover {
    @JsonProperty("small")
    private String smallUrl;

    @JsonProperty("medium")
    private String mediumUrl;

    @JsonProperty("large")
    private String largeUrl;

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }
}
