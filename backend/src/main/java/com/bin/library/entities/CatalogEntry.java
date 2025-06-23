package com.bin.library.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CatalogEntry {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    private Review review;

    @ManyToOne
    private Catalog catalog;

    public CatalogEntry(){}

    public CatalogEntry(Book book, Review review, Catalog catalog) {
        this.book = book;
        this.review = review;
        this.catalog = catalog;
    }
}