package com.dxctraining.bootmvcjpa;

import com.dxctraining.bootmvcjpa.entities.Employee;
import com.dxctraining.bootmvcjpa.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostConstruct
    public void init(){
        Employee employee1=new Employee("vineel",21,5000);
        employee1=employeeService.save(employee1);

        Employee employee2=new Employee("fazil",22,3000);
        employee2=employeeService.save(employee2);
    }


    /**
     *
     *  http://localhost:8585/profile?id=2
     */
    @GetMapping("/profile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
       Employee emp=employeeService.findEmployeeById(id);
       // details is name of view
        // employee is name of model object
        // emp is model data
       ModelAndView modelAndView=new ModelAndView("details","employee",emp);
       return modelAndView;
    }

    /**
     *  http://localhost:8585/listall
     */
    @GetMapping("/listall")
    public ModelAndView all(){
       List<Employee>values=employeeService.allEmployees();
        ModelAndView modelAndView=new ModelAndView("list","employees",values);
        return modelAndView;
    }



}
