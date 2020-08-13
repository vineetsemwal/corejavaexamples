package com.dxctraining.address.service;

import com.dxctraining.address.dao.IAddressDao;
import com.dxctraining.address.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressDao addressDao;

    @Override
    public Address save(Address address) {
        address=addressDao.save(address);
        return address;
    }

    @Override
    public Address findAddressById(int id) {
        Address address=addressDao.findAddressById(id);
        return address;
    }
}
