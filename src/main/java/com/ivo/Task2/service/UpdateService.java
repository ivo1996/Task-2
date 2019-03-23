package com.ivo.Task2.service;

import java.sql.Timestamp;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ivo.Task2.modelmapper.model.Update;
import com.ivo.Task2.repository.UpdateRepository;

@Service
@Transactional
public class UpdateService {
	
	@Autowired
	UpdateRepository updateRepository;
	
	public void create(Update update) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		update.setTime(timestamp);
		updateRepository.save(update);
	}
	
	public Page<Update> findAll(int page, Pageable pageable){
		return updateRepository.findAll(pageable);
	}
	
	public Page<Update> findByEmployeeId(int page, Pageable pageable, Long id){
		return updateRepository.findByEmployeeId(pageable,id);
	}
	
	public Page<Update> findByEmployerId(int page, Pageable pageable, Long id){
		return updateRepository.findByEmployerId(pageable,id);
	}
	
	public Optional<Update> findByMessage(String message){
		return updateRepository.findByMessage(message);	
	}
	
	public Page<Update> search(int page, Pageable pageable, String key, Long id){
		return updateRepository.search(pageable, key, id);
	}
}
