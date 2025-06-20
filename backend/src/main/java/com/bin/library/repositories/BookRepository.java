package com.bin.library.repositories;

import com.bin.library.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends CrudRepository<Book, UUID> {

    boolean existsByTitle(String title);

    Optional<Book> findByTitleAndAuthor(String title, String author);
}
