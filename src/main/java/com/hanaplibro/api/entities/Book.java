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

    public void setTitle(String title) {
        this.title = Optional.of(title).orElse("");
    }

    public String getTitle() {
        return title;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Cover getCover() {
        return cover;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
