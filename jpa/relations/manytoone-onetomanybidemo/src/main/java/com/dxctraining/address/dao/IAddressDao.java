package com.dxctraining.address.dao;

import com.dxctraining.address.entities.Address;

public interface IAddressDao {

    Address save(Address address);


    Address findAddressById(int id);

}
