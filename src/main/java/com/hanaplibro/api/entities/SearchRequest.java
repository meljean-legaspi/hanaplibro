package com.hanaplibro.api.entities;

import lombok.Data;

@Data
public class SearchRequest {
    private String query;
    private int limit;
    private int page;

    public SearchRequest(){
        page = 1;
        limit = 20;
    }
}
