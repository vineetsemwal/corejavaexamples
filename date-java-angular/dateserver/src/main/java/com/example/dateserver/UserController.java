package com.example.dateserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/users")
public class UserController {

    private User user;

    @Autowired
    private DateUtil dateUtil;

    @PostMapping("/add")
    public UserDetails add(@RequestBody CreateUserRequest request){
       long millis= request.getMillis();
       LocalDateTime dateTime =dateUtil.toDateTime(millis);
       user=new User();
       user.setUsername(request.getUsername());
       user.setDateTime(dateTime);
       // after conversing logging,you can see in console, correctly accepted
       System.out.println("day="+dateTime.getDayOfMonth()+"-"+dateTime.getMonthValue()+"-"+dateTime.getYear()+" "+dateTime.getHour()+":"+dateTime.getMinute());
       // you can save user now , here not done
        UserDetails userDetails=toDetails(user);
        return userDetails;

    }

    public UserDetails toDetails(User user){
        UserDetails userDetails=new UserDetails();
        userDetails.setUsername(user.getUsername());
        LocalDateTime dateTime=user.getDateTime();
        long millis=dateUtil.toMillis(dateTime);
        userDetails.setMillis(millis);
        System.out.println("inside to details, millis="+millis);
         return userDetails;
    }

    @GetMapping("/get/{id}")
    public UserDetails getUser(@PathVariable("id") int id){
        // just returning field, not fetching from anywhere
        UserDetails userDetails=toDetails(user);
        return userDetails;
    }





}
