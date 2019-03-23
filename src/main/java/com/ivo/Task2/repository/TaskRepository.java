package com.ivo.Task2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ivo.Task2.modelmapper.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	Page<Task> findAll(Pageable pageable);
	List<Task> findAll();
	Optional<Task> findById(Long id);
	Optional<Task> findByTitle(String name);
}
