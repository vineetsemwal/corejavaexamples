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
            Employee employee1 = new Employee("vineel", 21, 5000, address1);
            employee1 = employeeService.save(employee1);


            Employee employee2 = new Employee("khadar", 22, 3000, address1);
            employee2 = employeeService.save(employee2);

            int id1 = employee1.getId();
            Employee fetched1 = employeeService.findEmployeeById(id1);
            System.out.println("fetcehd employee =" + fetched1.getName() + " " + fetched1.getAge() + " " + fetched1.getSalary());
            Address fetchedAddress = fetched1.getAddress();
            System.out.println("address details="+fetchedAddress.getCity()+" "+fetchedAddress.getHouseAddress());

        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
