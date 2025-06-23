package com.bin.library.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Entity
public class Catalog {
    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CatalogEntry> entries = new ArrayList<>();
    @OneToOne
    User user;
    @Id
    @GeneratedValue
    UUID id;


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


    public List<CatalogEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<CatalogEntry> entries) {
        this.entries = entries;
    }
}
