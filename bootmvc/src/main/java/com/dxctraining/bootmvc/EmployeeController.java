package com.dxctraining.bootmvc;

import com.dxctraining.bootmvc.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
public class EmployeeController {

    private Map<Integer, Employee> store =new HashMap<>();

    @PostConstruct
    public void init(){
        Employee employee1=new Employee("vineel",21,5000);
        employee1.setId(1);
        store.put(1,employee1);

        Employee employee2=new Employee("fazil",22,3000);
        employee2.setId(2);
        store.put(2,employee2);

    }



    @GetMapping("/profile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
       Employee emp=findEmployeeById(id);
       // details is name of view
        // employee is name of model object
        // emp is model data
       ModelAndView modelAndView=new ModelAndView("details","employee",emp);
       return modelAndView;
    }

    @GetMapping("/listall")
    public ModelAndView all(){
       Collection<Employee>values=findAll();
        ModelAndView modelAndView=new ModelAndView("list","employees",values);
        return modelAndView;
    }


    public Employee findEmployeeById(int id){
       Employee employee= store.get(id);
       return employee;
    }


    public Collection<Employee>findAll() {
        Collection<Employee> values = store.values();
        return values;
    }



}
