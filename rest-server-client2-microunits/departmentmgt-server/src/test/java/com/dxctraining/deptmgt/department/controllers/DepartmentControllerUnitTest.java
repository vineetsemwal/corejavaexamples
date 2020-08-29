package com.dxctraining.deptmgt.department.controllers;

import com.dxctraining.deptmgt.department.dto.CreateDepartmentRequest;
import com.dxctraining.deptmgt.department.dto.DepartmentDto;
import com.dxctraining.deptmgt.department.entities.Department;
import com.dxctraining.deptmgt.department.service.IDepartmentService;
import com.dxctraining.deptmgt.department.util.DepartmentUtil;
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

    @MockBean
    private DepartmentUtil departmentUtil;

    @Test
    public void testGetDepartment_1() throws Exception {
        int id = 1;
        Department department = new Department();
        department.setName("dev");
        department.setId(id);
        Mockito.when(service.findById(id)).thenReturn(department);
        String jsonResult = "{\"id\" : 1 , \"name\" : \"dev\" }";
                //{"id":1 , "name" : "dev"}
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
        Department departmentBeforeSave = new Department();
        departmentBeforeSave.setName(deptName);
        Department departmentAfterSave=new Department();
        departmentAfterSave.setName(deptName);
        departmentAfterSave.setId(id);

        String jsonResult = "{\"id\" : 1 , \"name\" : \"dev\" }";
        Mockito.when(departmentUtil.newDepartment()).thenReturn(departmentBeforeSave);
        Mockito.when(service.save(departmentBeforeSave)).thenReturn(departmentAfterSave);
        DepartmentDto dto=new DepartmentDto();
        dto.setId(id);
        dto.setName(deptName);
        Mockito.when(departmentUtil.toDto(departmentAfterSave)).thenReturn(dto);

        String requestBody="{\"name\" : \"dev\"}";
        mockMvc.perform(
                post("/departments/add")
                 .content(requestBody)
                 .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(201))
                .andExpect(content().json(jsonResult));


    }
    
}
