package com.dxctraining.hotelmgt.customermgt.dao;

import com.dxctraining.hotelmgt.customermgt.entities.Customer;
import com.dxctraining.hotelmgt.customermgt.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer findById(Integer id) {
        Customer customer = entityManager.find(Customer.class, id);
        if (customer == null) {
            throw new CustomerNotFoundException("customer not found for id=" + id);
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        customer = entityManager.merge(customer);
        return customer;
    }
}
