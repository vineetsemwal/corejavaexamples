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

@Component
public class EmployeeUi {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDepartmentService departmentService;


    @PostConstruct
    public void runUi() {
        try {
            Department department1 = new Department("development", "dxc");
            department1 = departmentService.save(department1);
            Employee employee1 = new Employee("vineel", 21, 5000, department1);
            employee1 = employeeService.save(employee1);


            Employee employee2 = new Employee("khadar", 22, 3000, department1);
            employee2 = employeeService.save(employee2);

            int id1 = employee1.getId();
            Employee fetched1 = employeeService.findEmployeeById(id1);
            System.out.println("fetcehd employee =" + fetched1.getName() + " " + fetched1.getAge() + " " + fetched1.getSalary());
            Department fetchedDept = fetched1.getDepartment();
            System.out.println("department details="+fetchedDept.getName()+" "+fetchedDept.getCompany());

        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }
    }


}
