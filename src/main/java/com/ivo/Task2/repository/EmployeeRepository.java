package com.ivo.Task2.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ivo.Task2.modelmapper.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Page<Employee> findAll(Pageable pageable);
	@Query(value = "SELECT * FROM employee u WHERE" + " u.id like ?1 and u.employer_id=?2", nativeQuery = true)
	Page<Employee> pageFindById(Pageable pageable, Long id, Long employerId);
	Page<Employee> findAllByEmployerId(Pageable pageable, Long id);
	Optional<Employee> findById(Long id);
	Optional<Employee> findByEmployerId(Long id);
	
	@Query(value = "SELECT * FROM employee u WHERE" + " u.hire_date like ?1 or" + " u.job like ?1 or"
			+ " u.middle_name like ?1 or u.sex like ?1 and u.employer_id = ?2", nativeQuery = true)
	Page<Employee> search(Pageable pageable, String key, Long employerId);
	
	@Query(value = "SELECT * FROM employee u WHERE" + " u.bonus like ?1 or" + " u.salary like ?1 or"
			+ " u.commission like ?1 and u.employer_id = ?2", nativeQuery = true)
	Page<Employee> search(Pageable pageable, int key, Long employerId);
}
