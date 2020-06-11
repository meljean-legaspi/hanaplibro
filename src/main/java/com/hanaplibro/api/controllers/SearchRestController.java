package com.hanaplibro.api.controllers;

import com.hanaplibro.api.entities.SearchRequest;
import com.hanaplibro.api.entities.SearchResponse;
import com.hanaplibro.api.services.BookSearcherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SearchRestController {
    @GetMapping("/search")
    public Mono<SearchResponse> searchBooks(@RequestParam String query,
                                            @RequestParam(defaultValue = "20") int limit,
                                            @RequestParam(defaultValue = "1") int page) {
        BookSearcherService bookSearcherService = new BookSearcherService();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setQuery(query);
        searchRequest.setLimit(limit);
        searchRequest.setPage(page);
        return bookSearcherService.getSearchResponse(searchRequest);
    }
}
