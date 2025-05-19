package com.data.ss10.repository;

import com.data.ss10.model.Document;
import com.data.ss10.model.Project;

public interface ProjectDao {
    int createProject(Project project);
    void insertDocument(Document document);
}
