package com.dxctraining.consoleapp.ui;

import com.dxctraining.consoleapp.entities.Employee;
import com.dxctraining.consoleapp.exceptions.EmployeeNotFoundException;
import com.dxctraining.consoleapp.exceptions.InvalidArgumentException;
import com.dxctraining.consoleapp.service.IEmployeeService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployeeUi {
    private static final Logger Log= LoggerFactory.getLogger(EmployeeUi.class);

    @Autowired
    private IEmployeeService service;


    @PostConstruct
    public void runUi() {
        try {
            Employee employee1 = new Employee("vineel", 21, 5000);
            Employee employee2 = new Employee("khadar", 22, 3000);
            employee1 = service.save(employee1);
            employee2 = service.save(employee2);

            int id1 = employee1.getId();
            Employee fetched1 = service.findEmployeeById(78776);
            System.out.println("fetcehd employee =" + fetched1.getName() + " " + fetched1.getAge() + " " + fetched1.getSalary());

            Employee fetched2 = service.findEmployeeByName("vineel");
            System.out.println("fetched by name=" + fetched2.getName() + " " + fetched2.getId());
        } catch (EmployeeNotFoundException e) {
            Log.error("exception caught for employee not found, employee not found",e);
        } catch (InvalidArgumentException e) {
            Log.error("exception caught for invalid arg ",e);
        }
    }


}
