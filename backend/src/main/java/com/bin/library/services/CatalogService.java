package com.bin.library.services;

import com.bin.library.entities.Book;
import com.bin.library.entities.Catalog;
import com.bin.library.entities.CatalogEntry;
import com.bin.library.entities.Review;
import com.bin.library.repositories.BookRepository;
import com.bin.library.repositories.CatalogRepository;
import com.bin.library.repositories.ReviewRepository;
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
    private ReviewRepository creviewRepository;
    @Autowired
    private BookService bookService;
        public UUID addBookToCatalog(String catalogID, String title, String author,Float rate, String comment) throws IOException, InterruptedException {
            Optional<Catalog> catalog = catalogRepository.findById(UUID.fromString(catalogID));

            if (catalog.isPresent()) {
                Catalog catalogToUpdate = catalog.get();
                Book book = bookService.getBookByTitleAndAuthor(title, author);
                Review review = new Review(rate, comment,book);
                CatalogEntry catalogEntry = new CatalogEntry(book, review, catalogToUpdate);
                catalogToUpdate.getEntries().add(catalogEntry);
                catalogRepository.save(catalogToUpdate);
                return catalogToUpdate.getId();
            } else throw new RuntimeException("Le catalogue n'existe pas.");

    }
}
