package com.bin.library.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Catalog {
    @ManyToMany
    List<Book> books;
    @ManyToMany
    List<Review> reviews;
    @OneToOne
    User user;
    @Id
    @GeneratedValue
    UUID id;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
