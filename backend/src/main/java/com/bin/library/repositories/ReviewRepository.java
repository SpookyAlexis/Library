package com.bin.library.repositories;

import com.bin.library.entities.Catalog;
import com.bin.library.entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReviewRepository extends CrudRepository<Review, UUID> {

}
