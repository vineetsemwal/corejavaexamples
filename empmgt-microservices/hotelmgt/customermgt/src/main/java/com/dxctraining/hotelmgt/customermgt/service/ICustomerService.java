package com.dxctraining.hotelmgt.customermgt.service;

import com.dxctraining.hotelmgt.customermgt.entities.Customer;

public interface ICustomerService {

    Customer findById(Integer id);

    Customer save(Customer customer);

    Customer bookRoom(Integer customerId, String roomId);
}
