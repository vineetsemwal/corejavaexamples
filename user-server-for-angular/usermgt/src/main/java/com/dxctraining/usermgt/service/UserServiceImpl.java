package com.dxctraining.usermgt.service;

import com.dxctraining.usermgt.dao.IUserDao;
import com.dxctraining.usermgt.entities.User;
import com.dxctraining.usermgt.exceptions.InvalidArgumentException;
import com.dxctraining.usermgt.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// transactional will inform spring that it has to open transaction at every method in this class
@Transactional
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;

    @Override
    public User findById(int id) {
       Optional<User> optional= dao.findById(id);
       if(!optional.isPresent()){
           throw new UserNotFoundException("user not found for id="+id);
       }
        return optional.get();
    }

    @Override
    public User save(User user) {
        validate(user);
        user=dao.save(user);
        return user;
    }

    @Override
    public void remove(int id) {
       dao.deleteById(id);
    }

    public void validate(Object arg){
        if(arg==null){
            throw new InvalidArgumentException("argument is null");
        }
    }

    @Override
    public List<User> allUsers(){
        List<User>employees=dao.findAll();
        return employees;
    }


}
