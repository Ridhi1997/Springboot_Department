package com.example.demo.Controller;

import java.util.List;

 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	private final org.slf4j.Logger logger =LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		  logger.info("Inside save department of DepartmentController");
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDeapartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDeapartmentById(departmentId);
		return "Department deleted successfully...!!!";
		
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
		
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name")  String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
		
	}
	
	@GetMapping("/departments/address/{address}")
	public List<Department> fetchDepartmentByAddress(@PathVariable("address") String departmentAddress) {
		return  departmentService.fetchDepartmentByAddress(departmentAddress);
		
	}
	
	
	
}
