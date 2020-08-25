package com.dxctraining.hotelmgt.customermgt.controller;

import com.dxctraining.hotelmgt.customermgt.dto.CreateBookRequest;
import com.dxctraining.hotelmgt.customermgt.dto.CreateCustomer;
import com.dxctraining.hotelmgt.customermgt.dto.CustomerDto;
import com.dxctraining.hotelmgt.customermgt.dto.RoomDto;
import com.dxctraining.hotelmgt.customermgt.entities.Customer;
import com.dxctraining.hotelmgt.customermgt.service.ICustomerService;
import com.dxctraining.hotelmgt.customermgt.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    @Autowired
    private ICustomerService service;

    @Autowired
    private CustomerUtil util;

    @Value("${room.baseurl}")
    private String roomBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CustomerDto create(@RequestBody CreateCustomer requestData) {
        Customer customer = new Customer(requestData.getName());
        customer = service.save(customer);
        CustomerDto dto = util.toDto(customer,null);
        return dto;
    }

    @GetMapping("/get/{id}")
    public CustomerDto getCustomer(@PathVariable("id") int id) {
        Customer customer = service.findById(id);
        RoomDto roomDto=fetchRoomById(customer.getRoomId());
        CustomerDto dto = util.toDto(customer,roomDto);
        return dto;
    }

    @PutMapping("/book")
    public CustomerDto bookRoom(@RequestBody CreateBookRequest requestData){
      Customer customer  =service.bookRoom(requestData.getCustomerId(),requestData.getRoomId());
      RoomDto roomDto=fetchRoomById(requestData.getRoomId());
      CustomerDto dto=  util.toDto(customer,roomDto);
      return dto;
    }


    public RoomDto fetchRoomById(String id){
        if(id==null ||id.isEmpty()){
            return null;
        }
        String url=roomBaseUrl+"/get/"+id;
        RoomDto roomDto=restTemplate.getForObject(url,RoomDto.class);
       return roomDto;
    }



}
