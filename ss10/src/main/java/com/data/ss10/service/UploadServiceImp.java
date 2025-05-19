package com.data.ss10.service;

import com.data.ss10.repository.UploadDao;
import com.data.ss10.model.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImp implements UploadService {

    @Autowired
    private UploadDao uploadDao;

    @Override
    public void save(UploadFile uploadFile) {
        uploadDao.save(uploadFile);
    }
}
