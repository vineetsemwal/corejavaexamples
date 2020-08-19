package com.dxctraining.bootmvcjpa.controllers;

import com.dxctraining.bootmvcjpa.dto.CreateEmployeeRequest;
import com.dxctraining.bootmvcjpa.dto.SessionData;
import com.dxctraining.bootmvcjpa.entities.Employee;
import com.dxctraining.bootmvcjpa.service.IEmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private SessionData sessionData;


    @PostConstruct
    public void init(){
        Employee employee1=new Employee("vineel","abcd",21,5000);
        employee1=employeeService.save(employee1);

        Employee employee2=new Employee("fazil","1234",22,3000);
        employee2=employeeService.save(employee2);
    }


    /**
     *
     *  http://localhost:8585/profile?id=2
     */
    @GetMapping("/profile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
        if(!sessionData.isLoggedIn()){
            return new ModelAndView("login");
        }
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
        if(!sessionData.isLoggedIn()){
            return new ModelAndView("login");
        }
        List<Employee>values=employeeService.allEmployees();
        ModelAndView modelAndView=new ModelAndView("list","employees",values);
        return modelAndView;
    }

    /**
     *
     * for rendering register page
     */
    @GetMapping("/register")
    public ModelAndView registerPage(){
        System.out.println("inside registerpage method");
        ModelAndView mv=new ModelAndView("register");
        return mv;
    }

    /**
     *
     * processing register form submission here
     */
    @GetMapping("/processregister")
    public ModelAndView processRegister(@RequestParam("ename")String name,
                                        @RequestParam("salary")double salary,
                                        @RequestParam("age")int age,
                                        @RequestParam("password")String password){
        System.out.println("inside processregister method, name="+name+" age="+age+" salary="+salary);
        Employee employee=new Employee(name,password,age,salary);
        employee=employeeService.save(employee);
        ModelAndView mv=new ModelAndView("details","employee",employee);
        return mv;
    }


    /**
     *
     * for rendering register page
     */
    @GetMapping("/postregister")
    public ModelAndView postRegisterPage(){
        System.out.println("inside registerpage method");
        CreateEmployeeRequest requestData=new CreateEmployeeRequest();
        ModelAndView mv=new ModelAndView("postregister","employee",requestData);
        return mv;
    }

    /**
     *
     * processing register form submission here
     */
    @PostMapping("/processpostregister")
    public ModelAndView processRegister(@ModelAttribute("employee") CreateEmployeeRequest requestData){
        String name=requestData.getName();
        int age=requestData.getAge();
        double salary=requestData.getSalary();
        String password=requestData.getPassword();
        System.out.println("inside processregister method, name="+name+
                " age="+age+" salary="+salary);
        Employee employee=new Employee(name,password,age,salary);
        employee=employeeService.save(employee);
        ModelAndView mv=new ModelAndView("details","employee",employee);
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/processlogin")
    public ModelAndView processLogin(@RequestParam("id") int id, @RequestParam("password") String password){
         boolean correct=employeeService.authenticate(id,password);
         if(!correct){
          ModelAndView modelAndView= new ModelAndView("login");
          return modelAndView;
         }
         sessionData.saveLogin(id);
         Employee employee=employeeService.findEmployeeById(id);
         ModelAndView modelAndView=new ModelAndView("details","employee",employee);
         return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
       sessionData.clear();
       ModelAndView modelAndView=new ModelAndView("login");
       return modelAndView;
    }



}
