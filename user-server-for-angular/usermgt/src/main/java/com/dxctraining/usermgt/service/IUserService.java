package com.dxctraining.usermgt.service;


import com.dxctraining.usermgt.entities.User;

import java.util.List;

public interface IUserService {

    User findById(int id);

    User save(User employee);

    void remove(int id);

    List<User> allUsers();

}
