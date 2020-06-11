package com.hanaplibro.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanaplibro.api.entities.Book;
import com.hanaplibro.api.entities.BookRequest;
import com.hanaplibro.api.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class BookRetrieverService {
    private WebClient webClient;
    private WebClient.Builder builder;

    @Autowired
    public BookRetrieverService() {
        builder = WebClient.builder();
        webClient = builder.baseUrl("http://openlibrary.org").build();
    }

    public Book getBook(BookRequest bookRequest) throws JsonProcessingException {
        String path = "/api/books";
        return new BookMapper().mapJsonResultToBook(webClient.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("bibkeys", String.format("ISBN:%s", bookRequest.getIsbn()))
                        .queryParam("format", "json")
                        .queryParam("jscmd", "data")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block(Duration.ofSeconds(10)));
    }
}
