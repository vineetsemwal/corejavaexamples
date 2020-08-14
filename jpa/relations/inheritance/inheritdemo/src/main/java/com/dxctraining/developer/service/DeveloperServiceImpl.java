package com.dxctraining.developer.service;

import com.dxctraining.developer.entities.Developer;
import com.dxctraining.developer.dao.IDeveloperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DeveloperServiceImpl implements IDeveloperService {

    @Autowired
    private IDeveloperDao dao;

    @Override
    public Developer save(Developer developer) {
        developer = dao.save(developer);
        return developer;
    }

    @Override
    public Developer findById(int id) {
        Developer developer = dao.findById(id);
        return developer;
    }
}
