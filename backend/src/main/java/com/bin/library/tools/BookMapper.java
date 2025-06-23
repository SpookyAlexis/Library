package com.bin.library.tools;

import com.bin.library.entities.Book;
import com.bin.library.entities.BookGenre;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.util.*;
import java.text.SimpleDateFormat;

@Component
public class BookMapper {

    public static Book fromJson(JsonNode item) {
        JsonNode volume = item.path("volumeInfo");

        Book book = new Book();
        book.setTitle(volume.path("title").asText(null));
        book.setAuthor(getFirst(volume.path("authors")));
        book.setDescription(volume.path("description").asText(null));
        book.setPublisher(volume.path("publisher").asText(null));
        book.setPageCount(volume.path("pageCount").asInt(0));
        book.setCoverUrl(volume.path("imageLinks").path("thumbnail").asText(null));
        book.setPublicationDate(parseDate(volume.path("publishedDate").asText(null)));
        book.setBookGenres(getGenres(volume.path("categories")));

        return book;
    }

    private static String getFirst(JsonNode array) {
        if (array != null && array.isArray() && array.size() > 0) {
            return array.get(0).asText();
        }
        return null;
    }

    private static List<BookGenre> getGenres(JsonNode categories) {
        List<BookGenre> genres = new ArrayList<>();
        if (categories != null && categories.isArray()) {
            for (JsonNode cat : categories) {
                try {
                    genres.add(BookGenre.valueOf(cat.asText().toUpperCase().replace(" ", "_")));
                } catch (IllegalArgumentException ignored) {
                    // Skip unknown genres
                }
            }
        }
        return genres;
    }

    private static Date parseDate(String rawDate) {
        if (rawDate == null) return null;
        try {
            if (rawDate.length() == 4) {
                return new SimpleDateFormat("yyyy").parse(rawDate);
            } else if (rawDate.length() == 7) {
                return new SimpleDateFormat("yyyy-MM").parse(rawDate);
            } else {
                return new SimpleDateFormat("yyyy-MM-dd").parse(rawDate);
            }
        } catch (Exception e) {
            return null;
        }
    }
}

