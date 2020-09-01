package com.dxctraining.bootmvcjpa.employee.util;

import com.dxctraining.bootmvcjpa.employee.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EmployeeUtil {


    public EmployeeDto employeeDto(Employee employee){
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName());
        return dto;
    }

}
