package com.dxctraining.hotelmgt.zuulservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    @Autowired
    private Counter counter;

    @GetMapping("/requestscount")
    public int getRequestsCount(){
        return counter.getAppRequestsCount();
    }


}
