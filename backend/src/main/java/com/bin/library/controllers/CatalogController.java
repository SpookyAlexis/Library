package com.bin.library.controllers;

import com.bin.library.dto.BookDTO;
import com.bin.library.dto.CatalogDTO;
import com.bin.library.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CatalogController {
    @Autowired
    CatalogService catalogService;
    @PostMapping("/catalog/{catalogID}/books")
    public String addBookToCatalog(@PathVariable String catalogID, @RequestBody CatalogDTO catalogDTO) throws IOException, InterruptedException {
        return catalogService.addBookToCatalog(catalogID,catalogDTO.getTitle(),catalogDTO.getAuthor(),catalogDTO.getRate(),catalogDTO.getComment()).toString();
    }
}
