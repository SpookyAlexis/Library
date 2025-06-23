package com.bin.library.controllers;

import com.bin.library.dto.BookDTO;
import com.bin.library.entities.Book;
import com.bin.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/books")
    UUID createBook(@RequestBody BookDTO bookDTO){
        return bookService.addBook(bookDTO);
    }

    @GetMapping("/books")
    List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/search")
    Book getAllBooks(@RequestParam String title,@RequestParam String author) throws IOException, InterruptedException {
        return bookService.getBookByTitleAndAuthor(title,author);
    }



}
