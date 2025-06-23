package com.bin.library.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Review {

    @Id
    @GeneratedValue
    UUID id;
    Float rating;
    String comment;
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Review() {
    }
    public Review(Float rating, String comment, Book book,User user) {
        this.rating = rating;
        this.comment = comment;
        this.book = book;
        this.user = user;
    }

    public Review(Float rate, String comment, Book book) {
        this.rating = rate;
        this.comment = comment;
        this.book = book;
    }


    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
