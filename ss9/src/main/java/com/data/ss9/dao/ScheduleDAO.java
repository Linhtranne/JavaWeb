package com.data.ss9.dao;

import com.data.ss9.model.Schedule;

import java.util.List;

public interface ScheduleDAO {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}

