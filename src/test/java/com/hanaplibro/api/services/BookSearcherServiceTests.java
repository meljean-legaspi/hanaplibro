package com.hanaplibro.api.services;

import com.hanaplibro.api.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookSearcherServiceTests {
    @Autowired
    private BookSearcherService bookSearcherService;

    @Test
    public void givenSearchString_ShouldReturnResponseWithNumFoundAndBooks(){
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setQuery("mortification of sin");
        Mono<SearchResponse> response = bookSearcherService.getSearchResponse(searchRequest);
        StepVerifier.create(response)
                .thenConsumeWhile(r -> {
                    assertNotNull(r.getDocs());
                    assertTrue(() -> {
                        SearchDocument searchDocument = r.getDocs().get(0);
                        return searchDocument.getIsbn().size() > 0
                                && !searchDocument.getTitle().isEmpty()
                                && searchDocument.getPublishDates().size() > 0
                                && searchDocument.getPublishers().get(0).equals("Banner of Truth")
                                && searchDocument.getAuthors().get(0).equals("John Owen");
                    });
                    assertEquals(14, r.getNumFound());
                    return true;
                })
                .verifyComplete();
    }

    @Test
    public void givenSearchStringWithLimit_ShouldReturnLimitedResponse(){
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setQuery("lord of the rings");
        searchRequest.setLimit(20);
        Mono<SearchResponse> response = bookSearcherService.getSearchResponse(searchRequest);
        StepVerifier.create(response)
                .thenConsumeWhile(r -> {
                    assertNotNull(r.getDocs());
                    assertEquals(20, r.getDocs().size());
                    return true;
                })
                .verifyComplete();
    }

    @Test
    public void givenSearchStringWithPageNumberAndLimitPerPage_ShouldReturnNextPageOfResponse(){
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setQuery("lord of the rings");
        searchRequest.setLimit(10);
        searchRequest.setPage(2);
        Mono<SearchResponse> response = bookSearcherService.getSearchResponse(searchRequest);
        StepVerifier.create(response)
                    .thenConsumeWhile(r -> {
                        assertNotNull(r.getDocs());
                        assertEquals(10, r.getDocs().size());
                        assertEquals(10, r.getStart());
                        return true;
                    })
                    .verifyComplete();
    }
}
