package com.dxctraining.tester.service;


import com.dxctraining.tester.dao.ITesterDao;
import com.dxctraining.tester.entities.Tester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TesterServiceImpl implements ITesterService {

    @Autowired
    private ITesterDao dao;

    @Override
    public Tester save(Tester tester) {
        tester = dao.save(tester);
        return tester;
    }

    @Override
    public Tester findById(int id) {
        Tester tester = dao.findById(id);
        return tester;
    }
}
