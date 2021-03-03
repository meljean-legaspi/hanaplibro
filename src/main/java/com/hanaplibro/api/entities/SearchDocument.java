package com.hanaplibro.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SearchDocument {
    private String title;
    private List<String> isbn;

    @JsonProperty("publish_date")
    private List<String> publishDates;

    @JsonProperty("publisher")
    private List<String> publishers;

    @JsonProperty("author_name")
    private List<String> authors;
}
