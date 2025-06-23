package com.bin.library.repositories;

import com.bin.library.entities.Catalog;
import com.bin.library.entities.CatalogEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CatalogEntryRepository extends CrudRepository<CatalogEntry, UUID> {
}
