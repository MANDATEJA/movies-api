package com.example.movies.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movies.dto.Movie;
import com.example.movies.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/movies")
public class MovieController {
  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
  }

  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
    return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
  }
}
