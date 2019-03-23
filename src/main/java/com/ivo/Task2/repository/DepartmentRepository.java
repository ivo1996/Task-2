package com.ivo.Task2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivo.Task2.modelmapper.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	List<Department> findAll();
	Optional<Department> findByName(String name);
	Optional<Department> findById(Long id);
}
