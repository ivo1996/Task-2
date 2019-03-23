package com.ivo.Task2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivo.Task2.modelmapper.model.Employer;
import com.ivo.Task2.modelmapper.model.User;
import com.ivo.Task2.repository.EmployerRepository;

@Service
@Transactional
public class EmployerService {

	@Autowired
	EmployerRepository employerRepository;

//--------------------------------------manual id set, so user and employer ids match--------------------------------------
	public void create(Employer employer) {
		User user = employer.getUser();
		employer.setId(user.getEmployer_id());
		employerRepository.save(employer);
		}
	
	public Page<Employer> findAll(int page, Pageable pageable){
		return employerRepository.findAll(pageable);	
	}
	
	public Page<Employer> findById(int page, Pageable pageable, Long id){
		return employerRepository.findById(pageable, id);
	}
		
	public List<Employer> findAll() {
		return employerRepository.findAll();
	}

	public Optional<Employer> findById(Long id) {
		// TODO Auto-generated method stub
		return employerRepository.findById(id);
	}
	
	public Optional<Employer> findByEmployeeId(Long id) {
		// TODO Auto-generated method stub
		return employerRepository.findByEmployeeId(id);
	}
	
	public void deleteById(Long id){
		employerRepository.deleteById(id); 	
	}
}
