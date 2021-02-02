package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchDocument {
    private String title;
    private List<String> isbn;

    @JsonProperty("publish_date")
    private List<String> publishDates;

    @JsonProperty("publisher")
    private List<String> publishers;

    @JsonProperty("author_name")
    private List<String> authors;

    public String getTitle() {
        return title;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public List<String> getPublishDates() {
        return publishDates;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
