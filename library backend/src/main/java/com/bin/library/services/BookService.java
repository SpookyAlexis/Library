package com.bin.library.services;

import com.bin.library.dto.BookDTO;
import com.bin.library.entities.Book;
import com.bin.library.entities.Review;
import com.bin.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public UUID addBook(BookDTO bookDTO){
        Book book = new Book(
                bookDTO.getPublicationDate(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getBookGenres(),
                bookDTO.getPublisher(),
                bookDTO.getPageCount(),
                bookDTO.getDescription(),
                bookDTO.getCoverUrl()
        );
        return bookRepository.save(book).getId();
    }
    float getRating(UUID bookID){
        Book book = checkExistingBook(bookID);
        return book.getAverageRating();
    }
    List<Review> getReviews(UUID bookID){
        Book book = checkExistingBook(bookID);
        return book.getReviews();
    }
    private Book checkExistingBook(UUID bookID){
        Optional<Book> book =bookRepository.findById(bookID);
        if (book.isEmpty()){
            throw new RuntimeException("Le livre n'existe pas.");
        }else return book.get();
    }

    public List<BookDTO> getAllBooks() {
        Iterable<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book book : books){
            bookDTOS.add(new BookDTO(book));
        }
        return bookDTOS;
    }
}
