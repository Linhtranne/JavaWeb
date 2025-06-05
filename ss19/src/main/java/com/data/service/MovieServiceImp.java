package com.data.service;

import com.data.entity.Movie;
import com.data.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImp(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id);
    }
    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
    @Override
    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }
}