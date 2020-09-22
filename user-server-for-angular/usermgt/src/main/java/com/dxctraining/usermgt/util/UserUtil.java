package com.dxctraining.usermgt.util;

import com.dxctraining.usermgt.dto.UserDetails;
import com.dxctraining.usermgt.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {


    public UserDetails userDto(User user){
        UserDetails details=new UserDetails(user.getId(),user.getName(),user.getAge(),user.getSalary());
        return details;
    }

}
