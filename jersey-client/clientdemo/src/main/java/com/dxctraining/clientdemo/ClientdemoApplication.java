package com.dxctraining.clientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

@SpringBootApplication
public class ClientdemoApplication {
    RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        ClientdemoApplication app = new ClientdemoApplication();
        app.fireRequests();
    }

    public void fireRequests() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter name");
        String name=scanner.next();
        CreateEmployeeRequest requestData = new CreateEmployeeRequest(name, "123", 21, 99999);
        int id=addEmployee(requestData);
        displayEmployee(id);

    }

    public void displayEmployee(int id) {
        String url = "http://localhost:8585/employees/get/"+id;
        EmployeeDto dto = restTemplate.getForObject(url, EmployeeDto.class);
        System.out.println("******employee fetched=" + dto.getId() + " name=" + dto.getName());

    }

    public int addEmployee(CreateEmployeeRequest requestData) {
        String url = "http://localhost:8585/employees/add";
        EmployeeDto dto = restTemplate.postForObject(url, requestData, EmployeeDto.class);
        int id= dto.getId();
        System.out.println("*******employee created with id="+id);
        return id;
    }


}
