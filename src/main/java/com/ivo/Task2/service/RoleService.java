package com.ivo.Task2.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivo.Task2.modelmapper.model.Role;
import com.ivo.Task2.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Set<Role> findByName(String role) {
		return roleRepository.findByRole(role);
	}

}
