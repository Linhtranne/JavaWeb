package com.data.service;

import com.data.entity.Theater;
import com.data.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImp implements TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterServiceImp(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }
    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }
    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id);
    }
    @Override
    public void saveTheater(Theater theater) {
        theaterRepository.save(theater);
    }
    @Override
    public void deleteTheater(Long id) {
        theaterRepository.delete(id);
    }
}