package com.example.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.movies.data.ReviewRepository;
import com.example.movies.dto.Movie;
import com.example.movies.dto.Review;

@Service
public class ReviewService {
  @Autowired
  private ReviewRepository reviewRepository;
  @Autowired
  private MongoTemplate mongoTemplate;

  public Review createReview(String reviewBody, String imdbId) {
    Review review = reviewRepository.insert(new Review(reviewBody));

    mongoTemplate.update(Movie.class)
      .matching(Criteria.where("imdbId").is(imdbId))
      .apply(new Update().push("reviewIds").value(review))
      .first(); // Make sure we get only one Movie and update that

    return review;
  }
}
