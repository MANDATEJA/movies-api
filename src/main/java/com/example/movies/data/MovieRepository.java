package com.example.movies.data;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.movies.dto.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
  // We are not writing function body for this method
  // MongoRepository is intelligent enough to find movie by imdbId by analysing the method name.
  // It will search collection of type Movie by imdbId as those are the types passed to MongoRepository interface
  Optional<Movie> findMovieByImdbId(String imdbId);
}
