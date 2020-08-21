package com.dxctraining.bootmvcjpa.employee.util;

import com.dxctraining.bootmvcjpa.department.entities.Department;
import com.dxctraining.bootmvcjpa.employee.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class EmployeeUtil {


    public EmployeeDto employeeDto(Employee employee){
        Department department=employee.getDepartment();
        EmployeeDto dto=new EmployeeDto(employee.getId(),employee.getName(),employee.getPassword(),employee.getSalary(),employee.getAge());
        dto.setDepartmentId(department.getId());
        dto.setDepartmentName(department.getName());
        return dto;
    }

    public List<EmployeeDto> employeeDto(Collection<Employee> employees){
        List<EmployeeDto>dtos=new ArrayList<>();
        for (Employee employee:employees){
            EmployeeDto dto=employeeDto(employee);
            dtos.add(dto);
        }
        return dtos;
    }
}
