package com.hanaplibro.api.entities;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {
    private int numFound;
    private int start;
    private List<SearchDocument> docs;
}
