package com.ivo.Task2.service;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ivo.Task2.modelmapper.model.CustomUserDetails;
import com.ivo.Task2.modelmapper.model.Role;
import com.ivo.Task2.modelmapper.model.User;
import com.ivo.Task2.repository.UserRepository;


@Service
@Transactional
public class UserService implements UserDetailsService{
	
	
	@Autowired private PasswordEncoder passwordEncoder;
	 
	
	@Autowired
	private UserRepository userRepository;
	
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public void update(User user) {
		userRepository.save(user);
	}
	
	public Page<User> getAll(int page, Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	
	public Optional<User> findById(Long id) { 
		return userRepository.findById(id); 
	}
	
	public Optional<User> findByUsername(String username) { 
		return userRepository.findByUsername(username); 
	}
	
	public Optional<User> findByEmail(String email) { 
		return userRepository.findByEmail(email); 
	}
	 
	public void deleteUserById(Long id){
		userRepository.deleteById(id); 	
	}
	
	public Page<User> findById(Pageable pageable, Long Id){
		return userRepository.findById(pageable, Id);
	}
	
	public Page<User> search(Pageable pageable, String key){
		Page<User> found = userRepository.search(pageable, key);
		return found;
	}
	
	public Page<User> findByRole(Pageable pageable, Set<Role> role){
		return userRepository.findAllByRoles(pageable, role);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		Optional<User> optionalUsers = userRepository.findByUsername(username);
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
	}

	 	
}
