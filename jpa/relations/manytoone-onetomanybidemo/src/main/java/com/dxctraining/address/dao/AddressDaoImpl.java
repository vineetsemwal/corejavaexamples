package com.dxctraining.address.dao;

import com.dxctraining.address.entities.Address;
import com.dxctraining.employee.entities.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Repository
public class AddressDaoImpl implements IAddressDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Address save(Address address) {
        address=entityManager.merge(address);
        return address;
    }

    @Override
    public Address findAddressById(int id) {
      Address address=  entityManager.find(Address.class,id);
      Set<Employee> employees=address.getEmployees();
      employees.size();
      return address;
    }
}
