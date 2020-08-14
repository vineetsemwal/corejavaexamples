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
            int addressId1=address1.getId();

            Employee employee1 = new Employee("vineel", 21, 5000, address1);
            employee1 = employeeService.save(employee1);
            address1.setEmployee(employee1);
            int emp1Id=employee1.getId();

           System.out.println("******fetched address*************");
           Address fetchedAddres1= addressService.findAddressById(addressId1);
           Employee living=fetchedAddres1.getEmployee();
           System.out.println("address="+fetchedAddres1.getCity()+" "+fetchedAddres1.getHouseAddress());
           System.out.println("employee living in address="+living.getName()+" "+living.getAge());

           System.out.println("**********fetching employee*********");
           Employee fetchedEmployee=employeeService.findEmployeeById(emp1Id);
           System.out.println("fetched employees="+fetchedEmployee.getName()+" "+fetchedEmployee.getAge());
           Address livingAddress=fetchedEmployee.getAddress();
           System.out.println("living address="+livingAddress.getCity());


        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
