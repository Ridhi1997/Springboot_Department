package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
 
 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() { 
    	Department department = new Department();
        department.setDepartmentName("IT");
        department.setDepartmentAddress("Ahmedabad");
        department.setDepartmentCode("IT-06");
        department.setDepartmentId(1L);

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
       

        assertEquals(departmentName,found.getDepartmentName());
    }
	 

}
