package com.dxctraining.address.dao;

import com.dxctraining.address.entities.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AddressDaoImpl implements IAddressDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address save(Address address) {
        address=entityManager.merge(address);
        return address;
    }
}
