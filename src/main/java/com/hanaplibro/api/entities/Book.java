package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String title;
    private List<Publisher> publishers;

    @JsonProperty("identifiers")
    private Identifier identifier;

    @JsonProperty("number_of_pages")
    private int numberOfPages;

    private List<Author> authors;
    private Cover cover;

    @JsonProperty("publish_date")
    private String publishDate;

    public String getTitle() {
        return title;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Cover getCover() {
        return cover;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
