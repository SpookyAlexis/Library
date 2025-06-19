package com.bin.library.services;

import com.bin.library.entities.Book;
import com.bin.library.entities.Catalog;
import com.bin.library.repositories.BookRepository;
import com.bin.library.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private BookService bookService;
    public void addBookToCatalog(String catalogID, String title, String author) throws IOException, InterruptedException {
        Optional<Catalog> catalog = catalogRepository.findById(UUID.fromString(catalogID));
        if(catalog.isPresent()){
            Book book = bookService.getBookByTitleAndAuthor(title,author);
            catalog.get().getBooks().add(book);
        }else throw  new RuntimeException("Le catalogue n'existe pas.");
    }
}
