package com.ivo.Task2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ivo.Task2.modelmapper.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
	
	Page<Employer> findAll(Pageable pageable);
	Page<Employer> findById(Pageable pageable, Long id);
	Optional<Employer> findById(Long id);
	Optional<Employer> findByEmployeeId(Long id);
	List<Employer> findAll();
}
