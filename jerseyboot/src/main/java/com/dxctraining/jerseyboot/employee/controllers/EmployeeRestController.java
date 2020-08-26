package com.dxctraining.jerseyboot.employee.controllers;

import com.dxctraining.jerseyboot.employee.dto.CreateEmployeeRequest;
import com.dxctraining.jerseyboot.employee.dto.EmployeeDto;
import com.dxctraining.jerseyboot.employee.entities.Employee;
import com.dxctraining.jerseyboot.employee.service.IEmployeeService;
import com.dxctraining.jerseyboot.employee.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/employees")
@Component
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private EmployeeUtil util;

    @Produces("application/json")
    @GET
    public List<EmployeeDto> allEmployees() {
        List<Employee> employees = service.allEmployees();
        List<EmployeeDto>dtos=new ArrayList<>();
        for (Employee e:employees){
           EmployeeDto dto =util.employeeDto(e);
           dtos.add(dto);
        }
        return dtos;
    }

    @Path("/add")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public EmployeeDto add(CreateEmployeeRequest requestData) {
        System.out.println("inside add");
        Employee employee = new Employee(requestData.getName(),
                requestData.getPassword(), requestData.getAge(), requestData.getSalary());
        employee=service.save(employee);
        EmployeeDto dto = util.employeeDto(employee);
        return dto;
    }


    @Path("/get/{id}")
    @Produces("application/json")
    @GET
    public Response getEmployee(@PathParam("id") int id) {
        Employee employee = service.findEmployeeById(id);
        EmployeeDto dto = util.employeeDto(employee);
        /*
        Response.ResponseBuilder builder =Response.status(Response.Status.OK);
        builder=builder.entity(dto);
        Response response=builder.build();
        */
        Response response=Response.status(Response.Status.OK)
                .entity(dto)
                .build();
        return response;
    }


}
