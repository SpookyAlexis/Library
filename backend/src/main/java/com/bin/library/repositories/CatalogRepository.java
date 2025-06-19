package com.bin.library.repositories;

import com.bin.library.entities.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog, UUID> {

}
