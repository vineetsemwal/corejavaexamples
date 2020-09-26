package com.dxctraining.bootmvcjpa.employee.util;

import com.dxctraining.bootmvcjpa.employee.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EmployeeUtil {


    public EmployeeDto employeeDto(Employee employee,int deptId, String deptName){
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getName(),employee.getPassword(),employee.getSalary(),employee.getAge());
        dto.setDepartmentId(deptId);
        dto.setDepartmentName(deptName);
        return dto;
    }

}
