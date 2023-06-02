package com.example.movies.data;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.dto.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
