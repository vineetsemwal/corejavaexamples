package com.dxctraining.service;

import com.dxctraining.entities.BusinessCustomer;
import com.dxctraining.entities.Customer;
import com.dxctraining.entities.RegularCustomer;

import java.util.List;

public interface ICustomerService {

    Customer findById(String id);

    void add(Customer customer);

    void delete(String id);

    List<Customer> findAll();

    Customer updateName(String id, String name);

    RegularCustomer createRegularCustomer(String customername, String houseAddress, String pancard);

    BusinessCustomer createBusinessCustomer(String customerName, String office, String pancard);

    Customer addAmount(String id,double amount);

    Customer deductAmount(String id,double amount);



}
