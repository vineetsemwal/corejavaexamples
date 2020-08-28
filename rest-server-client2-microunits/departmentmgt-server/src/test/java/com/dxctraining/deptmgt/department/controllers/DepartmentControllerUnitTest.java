package com.dxctraining.deptmgt.department.controllers;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.ContentResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@WebMvcTest(DepartmentController.class)
@AutoConfigureMockMvc
public class DepartmentControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IDepartmentService service;// mocket object here


    @Test
    public void testGetDepartment_1() throws Exception {
        System.out.println("**********service="+service+"***********");
        int id=1;
        Department department=new Department();
        department.setName("dev");
        department.setId(id);
        Mockito.when(service.findById(id)).thenReturn(department);
        String jsonResult="{id:1, name:'dev'}";
        mockMvc.perform(get("/departments/get/1")).
                andExpect(status().is(200)).
                andExpect(content().json(jsonResult));
    }

    /*
    @Test
    public void testGetDepartment_2() throws Exception {
        System.out.println("**********service="+service+"***********");
        Mockito.doThrow(new DepartmentNotFoundException("department not found")).
                when(service).findById(1);
        //given()
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/departments/get/1");
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ContentResultMatchers resultMatchers=MockMvcResultMatchers.content();
        mockMvc.perform(requestBuilder).
                andExpect(status.is(404)).
                andExpect(resultMatchers.json("department not found"));
    }
    */


}
