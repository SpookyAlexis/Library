package com.bin.library.tools;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.bin.library.entities.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleBooksClient {

    private static final String BASE_URL = "https://www.googleapis.com/books/v1/volumes";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Value("${api.key}")
    String key;
    public JsonNode searchBooks(String title, String author) throws IOException, InterruptedException {
        title = URLEncoder.encode(title, StandardCharsets.UTF_8);
        author = URLEncoder.encode(author, StandardCharsets.UTF_8);
        String uri = BASE_URL +
                "?q=" + title +
                "+inauthor:" + author +
                "&maxResults=1" +
                "&startIndex=0"  +
                "&printType=books" +
                "&key=" + key;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readTree(response.body());
    }

}
