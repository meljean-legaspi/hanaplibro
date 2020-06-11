package com.hanaplibro.api.services;

import com.hanaplibro.api.entities.Book;
import com.hanaplibro.api.entities.BookRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookRetrieverServiceTests {
    @Autowired
    private BookRetrieverService bookRetrieverService;

    @Test
    public void givenIsbn_ShouldReturnBookDetails(){
        assertDoesNotThrow(() -> {
            BookRequest bookRequest = new BookRequest();
            bookRequest.setIsbn("9780851518671");
            Book book = bookRetrieverService.getBook(bookRequest);

            assertEquals("The Mortification of Sin", book.getTitle());
            assertEquals("Banner of Truth", book.getPublishers().get(0).getName());
            assertEquals("9780851518671", book.getIdentifier().getIsbn13().get(0));
            assertEquals("0851518672", book.getIdentifier().getIsbn10().get(0));
            assertEquals(144, book.getNumberOfPages());
            assertEquals("John Owen", book.getAuthors().get(0).getName());
            assertEquals("https://covers.openlibrary.org/b/id/648454-M.jpg", book.getCover().getMediumUrl());
            assertEquals("May 2004", book.getPublishDate());
        });
    }
}
