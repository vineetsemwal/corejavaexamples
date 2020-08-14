package com.dxctraining.developer.dao;


import com.dxctraining.developer.entities.Developer;

public interface IDeveloperDao {


    Developer save(Developer tester);

    Developer findById(int id);


}
