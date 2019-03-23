package com.ivo.Task2.modelmapper.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employer {

	@Id
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="employer_id")
	private Set<Employee> employee;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employer_id")
	private User user;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}