package com.dxctraining.bootmvcjpa.employee.dao;


import com.dxctraining.bootmvcjpa.employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstName(String name);

    List<Employee> findByLastName(String name);

    @Query("from Employee where firstName=:first and lastName=:last")
    List<Employee> findByFullName(@Param("first") String firstName, @Param("last") String lastName);
}
