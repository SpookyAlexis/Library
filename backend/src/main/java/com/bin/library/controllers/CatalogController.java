package com.bin.library.controllers;

import com.bin.library.dto.BookDTO;
import com.bin.library.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class CatalogController {
    @Autowired
    CatalogService catalogService;
    @PostMapping("/catalog/{catalogID}/books")
    public String addBookToCatalog(String catalogID, String title, String author) throws IOException, InterruptedException {
        catalogService.addBookToCatalog(catalogID,title, author);
        return "Book added to catalog successfully";
    }
}
