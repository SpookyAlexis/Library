package com.bin.library.dto;

import com.bin.library.entities.Book;
import com.bin.library.entities.BookGenre;

import java.util.Date;
import java.util.List;

public class BookDTO {
    Date publicationDate;
    String title;
    String author;
    List<BookGenre> bookGenres;
    String publisher;
    int pageCount;
    String description;
    String coverUrl;

    public BookDTO() {
    }

    public BookDTO(Book book) {
        this.publicationDate = book.getPublicationDate();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.bookGenres = book.getBookGenres();
        this.publisher = book.getPublisher();
        this.pageCount = book.getPageCount();
        this.description = book.getDescription();
        this.coverUrl = book.getCoverUrl();
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<BookGenre> getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(List<BookGenre> bookGenres) {
        this.bookGenres = bookGenres;
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
}
