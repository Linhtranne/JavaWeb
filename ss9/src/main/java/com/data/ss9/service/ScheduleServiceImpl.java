package com.data.ss9.service;

import com.data.ss9.dao.ScheduleDAO;
import com.data.ss9.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Override
    public List<Schedule> findAllScheduleByMovie(Long movieId) {
        return scheduleDAO.findAllScheduleByMovie(movieId);
    }
}

