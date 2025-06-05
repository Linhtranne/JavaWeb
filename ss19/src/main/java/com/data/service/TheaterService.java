package com.data.service;

import com.data.entity.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> getAllTheaters();

    Theater getTheaterById(Long id);

    void saveTheater(Theater theater);

    void deleteTheater(Long id);
}
