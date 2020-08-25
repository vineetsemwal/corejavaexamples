package com.dxctraining.hotelmgt.customermgt.service;

import com.dxctraining.hotelmgt.customermgt.dao.ICustomerDao;
import com.dxctraining.hotelmgt.customermgt.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer findById(Integer id) {
        Customer customer = dao.findById(id);
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        customer = dao.save(customer);
        return customer;
    }

    @Override
    public Customer bookRoom(Integer customerId, String roomId) {
        Customer customer = findById(customerId);
        customer.setRoomId(roomId);
        customer = save(customer);
        return customer;
    }

}
