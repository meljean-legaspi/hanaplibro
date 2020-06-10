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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setIsbn(List<String> isbn) {
        this.isbn = isbn;
    }

    public List<String> getIsbn() {
        return isbn;
    }

    public void setPublishDates(List<String> publishDates) {
        this.publishDates = publishDates;
    }

    public List<String> getPublishDates() {
        return publishDates;
    }

    public void setPublishers(List<String> publishers) {
        this.publishers = publishers;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
