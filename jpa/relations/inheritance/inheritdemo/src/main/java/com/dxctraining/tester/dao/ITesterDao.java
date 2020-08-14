package com.dxctraining.tester.dao;

import com.dxctraining.tester.entities.Tester;

public interface ITesterDao {
       
   Tester save(Tester tester);
   
   Tester findById(int id);
   
   
   
}
