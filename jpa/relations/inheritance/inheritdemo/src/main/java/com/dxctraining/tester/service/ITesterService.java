package com.dxctraining.tester.service;

import com.dxctraining.tester.entities.Tester;

public interface ITesterService {

   Tester save(Tester tester);

   Tester findById(int id);

}
