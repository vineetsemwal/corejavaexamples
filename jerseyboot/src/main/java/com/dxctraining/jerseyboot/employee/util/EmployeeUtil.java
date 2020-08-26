package com.dxctraining.jerseyboot.employee.util;

import com.dxctraining.jerseyboot.employee.dto.EmployeeDto;
import com.dxctraining.jerseyboot.employee.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtil {



    public EmployeeDto employeeDto(Employee employee){
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getName(),employee.getPassword(),employee.getSalary(),employee.getAge());
           return dto;
    }

}
