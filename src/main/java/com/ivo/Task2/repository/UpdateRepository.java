package com.ivo.Task2.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ivo.Task2.modelmapper.model.Update;

@Repository
public interface UpdateRepository extends JpaRepository<Update, Long>{
	Page<Update> findAll(Pageable pageable);
	Optional<Update> findByMessage(String string);
	Page<Update> findByEmployeeId(Pageable pageable, Long id);
	Page<Update> findByEmployerId(Pageable pageable, Long id);
	@Query(value = "SELECT * FROM update u WHERE" + " u.message like ?1  or u.task_title like ?1 and u.employee_id=?2", nativeQuery = true)
	Page<Update> search(Pageable pageable, String key, Long employerId);
}
