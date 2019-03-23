package com.ivo.Task2.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivo.Task2.modelmapper.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Set<Role> findByRole(String Role);	
}
