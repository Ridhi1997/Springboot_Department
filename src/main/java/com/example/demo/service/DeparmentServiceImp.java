package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DeparmentServiceImp implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		 
		return  departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		 
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		 
//		return departmentRepository.findById(departmentId).get(); // it'll work for fetch the data
		
		/*Logic to handle custom exception */
		 Optional<Department>  department = departmentRepository.findById(departmentId);
		 if(!department .isPresent()) {
			 throw new DepartmentNotFoundException("Department not avaliable.");
		 }
		 return department .get();
	}

	@Override
	public void deleteDeapartmentById(Long departmentId) {
		   departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		 
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		 
		 
		return departmentRepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		 
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public List<Department> fetchDepartmentByAddress(String departmentAddress) {
		 
		return departmentRepository.findByDepartmentAddress(departmentAddress);
	}

	 

	 
}
