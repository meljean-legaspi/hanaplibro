package com.hanaplibro.api.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanaplibro.api.entities.Book;
import com.hanaplibro.api.entities.BookRequest;
import com.hanaplibro.api.services.BookRetrieverService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    @GetMapping("/book")
    public Book getBook(@RequestParam String isbn) throws JsonProcessingException {
        BookRetrieverService bookRetrieverService = new BookRetrieverService();
        BookRequest bookRequest = new BookRequest();
        bookRequest.setIsbn(isbn);
        return bookRetrieverService.getBook(bookRequest);
    }
}
