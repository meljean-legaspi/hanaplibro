package com.hanaplibro.api.entities;

public class SearchRequest {
    private String query;
    private int limit;
    private int page;

    public SearchRequest(){
        page = 1;
        limit = 20;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }
}
