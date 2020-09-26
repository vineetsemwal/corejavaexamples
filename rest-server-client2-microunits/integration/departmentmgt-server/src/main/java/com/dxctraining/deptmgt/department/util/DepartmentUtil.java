package com.dxctraining.deptmgt.department.util;

import com.dxctraining.deptmgt.department.dto.DepartmentDto;
import com.dxctraining.deptmgt.department.entities.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentUtil {

    public Department newDepartment(){
        Department department=new Department();
        return department;
    }

    public DepartmentDto toDto(Department department) {
        DepartmentDto dto = new DepartmentDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        return dto;
    }


}


