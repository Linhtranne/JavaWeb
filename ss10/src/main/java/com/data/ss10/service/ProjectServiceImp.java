package com.data.ss10.service;

import com.data.ss10.repository.ProjectDao;
import com.data.ss10.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public void createProject(Project project) {
        projectDao.createProject(project);
    }
}
