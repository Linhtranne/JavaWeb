package com.data.service;

import com.data.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    void saveMovie(Movie movie);

    void deleteMovie(Long id);
}
