package com.data.ss9.service;
import com.data.ss9.dao.MovieDAO;
import com.data.ss9.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }
}
