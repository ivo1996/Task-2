package com.ivo.Task2.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ivo.Task2.modelmapper.model.Role;
import com.ivo.Task2.modelmapper.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String key);

	Page<User> findById(Pageable pageable, Long Id);

	Page<User> findAll(Pageable pageable);

	@Query(value = "SELECT * FROM person u WHERE" + " u.first_name like ?1 or" + " u.last_name like ?1 or"
			+ " u.birth_date like ?1 or" + " u.email like ?1 or" + " u.username like ?1 or"
			+ " u.phone like ?1", nativeQuery = true)
	Page<User> search(Pageable pageable, String key);

	Page<User> findAllByRoles(Pageable pageable, Set<Role> role);
}
