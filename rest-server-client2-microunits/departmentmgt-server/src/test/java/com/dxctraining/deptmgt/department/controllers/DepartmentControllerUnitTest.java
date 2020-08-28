package com.dxctraining.deptmgt.department.controllers;

import com.dxctraining.deptmgt.department.dto.CreateDepartmentRequest;
import com.dxctraining.deptmgt.department.entities.Department;
import com.dxctraining.deptmgt.department.service.IDepartmentService;
import com.dxctraining.deptmgt.exceptions.DepartmentNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.ContentResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.StatusResultMatchers.*;

@WebMvcTest(DepartmentController.class)
@AutoConfigureMockMvc
public class DepartmentControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IDepartmentService service;// mocked object here


    @Test
    public void testGetDepartment_1() throws Exception {
        int id = 1;
        Department department = new Department();
        department.setName("dev");
        department.setId(id);
        Mockito.when(service.findById(id)).thenReturn(department);
        String jsonResult = "{\"id\":1, \"name\":\"dev\"}";
/*
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments/get/1");
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ContentResultMatchers resultMatchers = MockMvcResultMatchers.content();
        mockMvc.perform(requestBuilder).
                andExpect(status.is(200)).
                andExpect(resultMatchers.json(jsonResult));

 */
       mockMvc.perform(get("/departments/get/1"))
       .andExpect(status().is(200))
       .andExpect(content().json(jsonResult));

    }

    @Test
    public void testAddDepartment_1() throws Exception {
        int id = 1;
        String deptName="dev";
        Department department = new Department();
        department.setName(deptName);
        department.setId(id);
        Mockito.when(service.findById(id)).thenReturn(department);
        String jsonResult = "{\"id\":1, \"name\":\"dev\"}";
        Mockito.when(service.save(Mockito.any(Department.class))).thenReturn(department);
        CreateDepartmentRequest requestData=new CreateDepartmentRequest();
        requestData.setName(deptName);

        mockMvc.perform(
                post("/departments/add")
                 .content("{\"name\" : \"dev\"}")
                 .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201))
                .andExpect(content().json(jsonResult));


    }
    
}
