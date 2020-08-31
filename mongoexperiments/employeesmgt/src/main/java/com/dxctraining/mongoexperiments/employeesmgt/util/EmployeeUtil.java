package com.dxctraining.mongoexperiments.employeesmgt.util;

import com.dxctraining.mongoexperiments.employeesmgt.dto.EmployeeDto;
import com.dxctraining.mongoexperiments.employeesmgt.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtil {

    public EmployeeDto employeeDto(Employee employee){
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getFirstName(), employee.getLastName(),employee.getAge());
        return dto;
    }

}
