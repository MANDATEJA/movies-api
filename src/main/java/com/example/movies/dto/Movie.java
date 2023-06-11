package com.example.movies.dto;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
// Takes care of getter and setter methods
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
  @Id
  private ObjectId id;
  private String imdbId;
  private String title;
  private String releaseDate;
  private String trailerLink;
  private String poster;
  private List<String> genres;
  private List<String>backdrops;
  // Cause database store to only Ids of reviews and reviews will be stored in a separate collection
  // This design is called manual reference ralationship
  @DocumentReference
  private List<Review> reviewIds;
}
