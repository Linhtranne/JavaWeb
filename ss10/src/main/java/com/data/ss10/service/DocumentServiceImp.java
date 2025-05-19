package com.data.ss10.service;

import com.data.ss10.repository.DocumentDao;
import com.data.ss10.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImp implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public void save(Document document) {
        documentDao.save(document);
    }
}
