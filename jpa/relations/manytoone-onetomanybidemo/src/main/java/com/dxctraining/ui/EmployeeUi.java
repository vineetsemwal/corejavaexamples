package com.dxctraining.ui;

import com.dxctraining.address.entities.Address;
import com.dxctraining.address.service.IAddressService;
import com.dxctraining.employee.entities.Employee;
import com.dxctraining.exceptions.EmployeeNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class EmployeeUi {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IAddressService addressService;


    @PostConstruct
    public void runUi() {
        try {
            Address address1 = new Address("hyderabad", "madhavpur a1");
            address1 = addressService.save(address1);
            int addressId1 = address1.getId();
            Employee employee1 = new Employee("vineel", 21, 5000, address1);
            employee1 = employeeService.save(employee1);


            Employee employee2 = new Employee("khadar", 22, 5000, address1);
            employee2 = employeeService.save(employee2);


            Address fetchedAddres1 = addressService.findAddressById(addressId1);
            Set<Employee> livingEmployees = fetchedAddres1.getEmployees();

            System.out.println("address=" + fetchedAddres1.getCity() + " " + fetchedAddres1.getHouseAddress());

            System.out.println("living employees size="+livingEmployees.size());

            for(Employee living:livingEmployees)
            {
                System.out.println("employee living in address=" + living.getName() + " " + living.getAge());
            }

        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
