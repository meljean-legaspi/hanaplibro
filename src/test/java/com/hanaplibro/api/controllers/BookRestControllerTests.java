package com.hanaplibro.api.controllers;

import com.hanaplibro.api.entities.Book;
import com.hanaplibro.api.entities.SearchResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookRestControllerTests {
    @Test
    public void givenBookIsbn_ShouldReturnBookDetails(@Autowired TestRestTemplate testRestTemplate){
        ResponseEntity<Book> bookResponseEntity = testRestTemplate
                .getForEntity("/book?isbn=9780851518671", Book.class);
        assertEquals(HttpStatus.OK, bookResponseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, bookResponseEntity.getHeaders().getContentType());
        Book book = bookResponseEntity.getBody();
        assertEquals("The Mortification of Sin", book.getTitle());
        assertEquals(144, book.getNumberOfPages());
        assertEquals("9780851518671", book.getIdentifier().getIsbn13().get(0));
        assertEquals("0851518672", book.getIdentifier().getIsbn10().get(0));
    }
}
