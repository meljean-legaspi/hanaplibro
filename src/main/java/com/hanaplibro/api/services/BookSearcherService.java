package com.hanaplibro.api.services;

import com.hanaplibro.api.entities.Book;
import com.hanaplibro.api.entities.BookRequest;
import com.hanaplibro.api.entities.SearchRequest;
import com.hanaplibro.api.entities.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class BookSearcherService {
    private WebClient webClient;
    private WebClient.Builder builder;

    @Autowired
    public BookSearcherService(){
        builder = WebClient.builder();
        webClient = builder.baseUrl("http://openlibrary.org").build();
    }

    public Mono<SearchResponse> getSearchResponse(SearchRequest searchRequest){
        String path = "/search.json";
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("q", searchRequest.getQuery())
                        .queryParam("limit", String.valueOf(searchRequest.getLimit()))
                        .queryParam("page", String.valueOf(searchRequest.getPage()))
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SearchResponse.class);
    }
}
