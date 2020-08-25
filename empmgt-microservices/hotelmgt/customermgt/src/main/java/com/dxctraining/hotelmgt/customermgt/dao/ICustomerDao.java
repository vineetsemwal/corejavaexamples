package com.dxctraining.hotelmgt.customermgt.dao;

import com.dxctraining.hotelmgt.customermgt.entities.Customer;

public interface ICustomerDao {

    Customer findById(Integer id);

    Customer save(Customer customer);


}
