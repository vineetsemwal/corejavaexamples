package com.dxctraining.bootmvcjpa.controllers;

import com.dxctraining.bootmvcjpa.dto.CreateEmployeeRequest;
import com.dxctraining.bootmvcjpa.dto.EmployeeDto;
import com.dxctraining.bootmvcjpa.dto.SessionData;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    @Autowired
    private SessionData sessionData;

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl="http://localhost:8585/employees";

    /**
     *
     *  http://localhost:8585/profile?id=2
     */
    @GetMapping("/profile")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
        if(!sessionData.isLoggedIn()){
            return new ModelAndView("login");
        }
        EmployeeDto employeeDto=findEmployeeById(id);
        // details is name of view
        // employee is name of model object
        // emp is model data
       ModelAndView modelAndView=new ModelAndView("details","employee",employeeDto);
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
        String url=baseUrl;
        EmployeeDto[] array=restTemplate.getForObject(url,EmployeeDto[].class);
    //    List<EmployeeDto>list=Arrays.stream(array).collect(Collectors.toList());
        List<EmployeeDto>list= Arrays.asList(array);
        ModelAndView modelAndView=new ModelAndView("list","employees",list);
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
        CreateEmployeeRequest employee=new CreateEmployeeRequest(name,password,age,salary);
        String url=baseUrl+"/add";
        EmployeeDto employeeDto=restTemplate.postForObject(url,employee,EmployeeDto.class);
        ModelAndView mv=new ModelAndView("details","employee",employeeDto);
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
        String url=baseUrl+"/add";
        EmployeeDto employeeDto=restTemplate.postForObject(url,requestData,EmployeeDto.class);
        ModelAndView mv=new ModelAndView("details","employee",employeeDto);
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/processlogin")
    public ModelAndView processLogin(@RequestParam("id") int id, @RequestParam("password") String password){
        String url=baseUrl+"/authenticate/"+id+"/"+password;
        boolean correct=restTemplate.getForObject(url,Boolean.class);
         if(!correct){
          ModelAndView modelAndView= new ModelAndView("login");
          return modelAndView;
         }
         sessionData.saveLogin(id);
         EmployeeDto employee=findEmployeeById(id);
         ModelAndView modelAndView=new ModelAndView("details","employee",employee);
         return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(){
       sessionData.clear();
       ModelAndView modelAndView=new ModelAndView("login");
       return modelAndView;
    }

    public EmployeeDto findEmployeeById(int id){
        String url=baseUrl+"/get/"+id;
        EmployeeDto employeeDto=restTemplate.getForObject(url, EmployeeDto.class);
        return employeeDto;
    }


}
