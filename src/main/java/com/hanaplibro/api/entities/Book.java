package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
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
}
