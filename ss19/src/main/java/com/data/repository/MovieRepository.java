package com.data.repository;

import com.data.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();

    Movie findById(Long id);

    void save(Movie movie);

    void delete(Long id);
}
