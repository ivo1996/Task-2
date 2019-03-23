package com.ivo.Task2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivo.Task2.modelmapper.model.Department;
import com.ivo.Task2.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
	
	public Optional<Department> findByName(String name) {
		return departmentRepository.findByName(name);
	}
	
	public void create(Department department) {
		departmentRepository.save(department);
	}

	public Optional<Department> findById(Long id) {
		return departmentRepository.findById(id);
	}
}
