package com.bin.library.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue
    UUID id;
    String author;
    String title;
    Date publicationDate;
    private String publisher;
    private int pageCount;
    @Column(length = 2000)
    private String description;
    private String coverUrl;
    @OneToMany
    List<Review> reviews;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "book_types", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "type")
    List<BookGenre> bookGenres;


    public Book(Date publicationDate, String title, String author, List<BookGenre> bookGenres,
                String publisher, int pageCount, String description, String coverUrl) {
        this.publicationDate = publicationDate;
        this.title = title;
        this.author = author;
        this.bookGenres = bookGenres;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.description = description;
        this.coverUrl = coverUrl;
    }

    public Book() {
    }

    public float getAverageRating(){
        float rating = 0;
        for (Review review : reviews){
            rating+=review.getRating();
        }
        return rating/reviews.size();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<BookGenre> getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(List<BookGenre> bookGenres) {
        this.bookGenres = bookGenres;
    }
}
