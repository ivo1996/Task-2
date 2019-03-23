package com.ivo.Task2.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivo.Task2.modelmapper.model.Task;
import com.ivo.Task2.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public void create(Task task) {
		taskRepository.save(task);
	}
	
	public Page<Task> findAll(Pageable pageable){
		return taskRepository.findAll(pageable);
	}
	
	public Optional<Task> findByName(String name){
		return taskRepository.findByTitle(name);
	}
	
	public Optional<Task> findById(Long id){
		return taskRepository.findById(id);
	}
	
	public List<Task> findAll(){
		return taskRepository.findAll();
	}
}
