package com.data.ss9.service;

import com.data.ss9.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}
