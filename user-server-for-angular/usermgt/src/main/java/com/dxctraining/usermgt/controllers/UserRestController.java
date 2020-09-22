package com.dxctraining.usermgt.controllers;

import com.dxctraining.usermgt.dto.CreateUserRequest;
import com.dxctraining.usermgt.dto.UserDetails;
import com.dxctraining.usermgt.entities.User;
import com.dxctraining.usermgt.service.IUserService;
import com.dxctraining.usermgt.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private RestTemplate restTemplate;

    /*
      uri is /employees/add
      url http://localhost:8585/employees/add
   */
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetails create(@RequestBody  CreateUserRequest requestData) {
        String name = requestData.getName();
        int age = requestData.getAge();
        double salary = requestData.getSalary();
        User user = new User(name,  age, salary);
        user = userService.save(user);
        UserDetails response = userUtil.userDto(user);
        return response;
    }


    @GetMapping("/get/{id}")
    public UserDetails findEmployee(@PathVariable("id") int id) {
        User user = userService.findById(id);
        UserDetails response = userUtil.userDto(user);
        return response;
    }


    @GetMapping
    public List<UserDetails> fetchAll() {
        List<User> list = userService.allUsers();
        List<UserDetails>response=new ArrayList<>();
        for (User user:list){
            UserDetails dto= userUtil.userDto(user);
            response.add(dto);
        }
        return response;
    }




}




