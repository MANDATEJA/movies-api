package com.example.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.data.MovieRepository;
import com.example.movies.dto.Movie;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> allMovies() {
    return movieRepository.findAll();
  }

  public Optional<Movie> singleMovie(String id) {
    return movieRepository.findMovieByImdbId(id);
  }
}
