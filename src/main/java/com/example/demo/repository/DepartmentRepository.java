package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long>{
	
	public Department findByDepartmentName(String departmentName);
	public  Department findByDepartmentNameIgnoreCase(String  departmentName);
	
	public List<Department> findByDepartmentAddress(String departmentAddress);
}
