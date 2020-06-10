package com.hanaplibro.api.entities;

import java.util.List;

public class SearchResponse {
    private int numFound;
    private int start;
    private List<SearchDocument> docs;

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }

    public void setDocs(List<SearchDocument> docs) {
        this.docs = docs;
    }

    public List<SearchDocument> getDocs() {
        return docs;
    }
}
