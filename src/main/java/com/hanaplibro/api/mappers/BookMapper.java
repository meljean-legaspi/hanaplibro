package com.hanaplibro.api.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanaplibro.api.entities.Book;

import java.util.Map;

public class BookMapper {
    public Book mapJsonResultToBook(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Book> bookMap =
                mapper.readValue(json, new TypeReference<Map<String, Book>>() {});
        return bookMap.entrySet().iterator().next().getValue();
    }
}
