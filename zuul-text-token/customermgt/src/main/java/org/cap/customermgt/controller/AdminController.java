package org.cap.customermgt.controller;

import org.cap.customermgt.entities.Customer;
import org.cap.customermgt.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/customers")
public class AdminController {
    private static final Logger Log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ICustomerService service;


    @GetMapping
    public List<Customer> fetchAllCustomers() {
        List<Customer> customers = service.fetchAll();
       return customers;
    }






}
