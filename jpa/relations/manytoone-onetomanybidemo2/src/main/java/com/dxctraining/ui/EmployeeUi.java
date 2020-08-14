package com.dxctraining.ui;

import com.dxctraining.department.entities.Department;
import com.dxctraining.department.service.IDepartmentService;
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
    private IDepartmentService departmentService;


    @PostConstruct
    public void runUi() {
        try {
            Department department1 = new Department("hyderabad", "madhavpur a1");
            department1 = departmentService.save(department1);
            int addressId1 = department1.getId();
            Employee employee1 = new Employee("vineel", 21, 5000, department1);
            employee1 = employeeService.save(employee1);


            Employee employee2 = new Employee("khadar", 22, 5000, department1);
            employee2 = employeeService.save(employee2);


            Department fetchedDept1 = departmentService.findDepartmentById(addressId1);
            Set<Employee> members = fetchedDept1.getEmployees();

            System.out.println("department=" + fetchedDept1.getCompany()+ " " + fetchedDept1.getName());

            System.out.println("living employees size="+members.size());

            for(Employee member:members)
            {
                System.out.println("employee living in address=" + member.getName() + " " + member.getAge());
            }

        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
