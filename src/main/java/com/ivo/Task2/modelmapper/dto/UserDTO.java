package com.ivo.Task2.modelmapper.dto;

import java.util.Set;

import com.ivo.Task2.modelmapper.model.Role;

public class UserDTO {

	private Long Id;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;
	private String username;
	private int active;
	private String password;
	private Set<Role> roles;
	private Long employee_id;

	public UserDTO(Long id, String firstName, String lastName, String birthDate, String phone, String email,
			String username, int active, String password, Set<Role> roles, Long employee_id) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.active = active;
		this.password = password;
		this.roles = roles;
		this.employee_id = employee_id;
	}

	public Long getEmployee_id() {
		return employee_id;
	}



	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}



	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
