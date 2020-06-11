package com.hanaplibro.api.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hanaplibro.api.entities.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookMapperTests {
    @Test
    public void whenJsonResultIsMapped_ShouldReturnBook() {
        String json = "{\"ISBN:0851518672\": {\"publishers\": [{\"name\": \"Banner of Truth\"}], \"identifiers\": {\"openlibrary\": [\"OL8278892M\"], \"isbn_13\": [\"9780851518671\"], \"isbn_10\": [\"0851518672\"], \"oclc\": [\"54930191\"], \"goodreads\": [\"310016\"], \"librarything\": [\"127793\"]}, \"weight\": \"3.2 ounces\", \"title\": \"The Mortification of Sin\", \"url\": \"https://openlibrary.org/books/OL8278892M/The_Mortification_of_Sin\", \"number_of_pages\": 144, \"cover\": {\"small\": \"https://covers.openlibrary.org/b/id/648454-S.jpg\", \"large\": \"https://covers.openlibrary.org/b/id/648454-L.jpg\", \"medium\": \"https://covers.openlibrary.org/b/id/648454-M.jpg\"}, \"publish_date\": \"May 2004\", \"key\": \"/books/OL8278892M\", \"authors\": [{\"url\": \"https://openlibrary.org/authors/OL1475534A/John_Owen\", \"name\": \"John Owen\"}]}}";
        assertDoesNotThrow(() -> {
            BookMapper mapper = new BookMapper();
            Book book = mapper.mapJsonResultToBook(json);
            assertNotNull(book);
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

    @Test
    public void whenJsonResultIsInvalid_ShouldThrowException() {
        String json = "{\"foo\": \"bar\"}";
        BookMapper mapper = new BookMapper();
        assertThrows(JsonProcessingException.class, () -> mapper.mapJsonResultToBook(json));
    }
}
