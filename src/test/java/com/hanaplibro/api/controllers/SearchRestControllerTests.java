package com.hanaplibro.api.controllers;

import com.hanaplibro.api.entities.SearchResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchRestControllerTests {
    @Test
    public void givenSearchQuery_ShouldReturnResponse(@Autowired TestRestTemplate testRestTemplate){
        ResponseEntity<SearchResponse> monoResponseEntity = testRestTemplate
                .getForEntity("/search?query=slavery", SearchResponse.class);
        assertEquals(HttpStatus.OK, monoResponseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, monoResponseEntity.getHeaders().getContentType());
        SearchResponse searchResponse = monoResponseEntity.getBody();
        assertEquals(0, searchResponse.getStart());
    }

    @Test
    public void givenSearchQueryAndLimitAndPage_ShouldReturnLimitedResponse(@Autowired TestRestTemplate testRestTemplate){
        ResponseEntity<SearchResponse> monoResponseEntity = testRestTemplate
                .getForEntity("/search?query=slavery&limit=5&page=2", SearchResponse.class);
        assertEquals(HttpStatus.OK, monoResponseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, monoResponseEntity.getHeaders().getContentType());
        SearchResponse searchResponse = monoResponseEntity.getBody();
        assertEquals(5, searchResponse.getStart());
        assertEquals(5, searchResponse.getDocs().size());
    }
}
