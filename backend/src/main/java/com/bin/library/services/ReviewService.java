package com.bin.library.services;

import com.bin.library.entities.Book;
import com.bin.library.entities.Review;
import com.bin.library.entities.User;

public class ReviewService {

    public Review addReview(Float score, String comment, Book book, User user){
        Review review = new Review(score,comment,book,user);
        return review;
    }
}
