package com.data.repository;

import com.data.entity.Theater;

import java.util.List;

public interface TheaterRepository {
    List<Theater> findAll();

    Theater findById(Long id);

    void save(Theater theater);

    void delete(Long id);
}
