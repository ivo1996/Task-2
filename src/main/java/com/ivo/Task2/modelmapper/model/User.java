package com.ivo.Task2.modelmapper.model;

import java.util.Set;

//Declarations for the UserBean class which is used to store information for a row of the Database
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Declarations for getters and setters
@Entity
@Table(name = "person")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName = "";
	private String lastName = "";
	private String birthDate = "";
	private String phone = "";
	private String email = "";
	private int active;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "Id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	@Column(name = "employee_id")
	private Long employee_id;
	@Column(name = "employer_id")
	private Long employer_id;

	public User(User user) {
		this.active = user.getActive();
		this.birthDate = user.getBirthDate();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.id = user.getId();
		this.lastName = user.getLastName();
		this.password = user.getPassword();
		this.phone = user.getPhone();
		this.roles = user.getRoles();
		this.username = user.getUsername();
		this.employee_id = user.getEmployee_id();
	}

	public Long getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(Long employer_id) {
		this.employer_id = employer_id;
	}

	public String getFirstName() {
		return firstName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
