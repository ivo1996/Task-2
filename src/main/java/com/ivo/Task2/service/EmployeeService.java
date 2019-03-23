package com.ivo.Task2.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.ivo.Task2.modelmapper.model.Employee;
import com.ivo.Task2.modelmapper.model.User;
import com.ivo.Task2.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	TaskService taskService;
	
//--------------------------------------manual set for the id, so user and employee ids match--------------------------------------
	public void create(Employee employee) {
		User user = employee.getUser();
		employee.setId(user.getEmployee_id());
		employeeRepository.save(employee);
	}
	
	public void update(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteUserById(Long id){
		employeeRepository.deleteById(id); 	
	}
	
	public Page<Employee> findAll(int page, Pageable pageable){
		return employeeRepository.findAll(pageable);
	}
	
	public Page<Employee> pageFindById(int page, Pageable pageable, Long id, Long employerId){
		return employeeRepository.pageFindById(pageable, id, employerId);
	}
	
	public Page<Employee> findbyEmployer(int page, Pageable pageable, Long id){
		return employeeRepository.findAllByEmployerId(pageable, id);
	}
	
	public Optional<Employee> findById(Long id){
		return employeeRepository.findById(id);
	}
	
	public Page<Employee> search(Pageable pageable, String key, Long employerId){
		return employeeRepository.search(pageable, key, employerId);
	}
	
	public Page<Employee> search(Pageable pageable, int key, Long employerId){
		return employeeRepository.search(pageable, key, employerId);
	}
}
