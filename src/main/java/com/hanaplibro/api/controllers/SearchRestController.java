package com.hanaplibro.api.controllers;

import com.hanaplibro.api.entities.SearchRequest;
import com.hanaplibro.api.entities.SearchResponse;
import com.hanaplibro.api.services.BookFinderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SearchRestController {
    @GetMapping("/search")
    public Mono<SearchResponse> SearchBooks(@RequestParam String query,
                                            @RequestParam(defaultValue = "20") int limit,
                                            @RequestParam(defaultValue = "1") int page) {
        BookFinderService bookFinderService = new BookFinderService();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setQuery(query);
        searchRequest.setLimit(limit);
        searchRequest.setPage(page);
        return bookFinderService.getSearchResponse(searchRequest);
    }
}
