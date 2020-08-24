package com.dxctraining.empmgt.employee.util;

import com.dxctraining.empmgt.employee.dto.EmployeeDto;
import com.dxctraining.empmgt.employee.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtil {


    public EmployeeDto employeeDto(Employee employee,int deptId, String deptName, double rating){
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getName(),employee.getPassword(),employee.getSalary(),employee.getAge());
        dto.setDepartmentId(deptId);
        dto.setDepartmentName(deptName);
        dto.setRating(rating);
        return dto;
    }

}
