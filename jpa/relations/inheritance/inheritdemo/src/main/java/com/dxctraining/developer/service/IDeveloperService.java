package com.dxctraining.developer.service;

import com.dxctraining.developer.entities.Developer;

public interface IDeveloperService {

   Developer save(Developer developer);

   Developer findById(int id);

}
