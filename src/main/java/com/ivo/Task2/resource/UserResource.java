package com.ivo.Task2.resource;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import util.customErrorType;

import com.ivo.Task2.modelmapper.dto.UserDTO;
import com.ivo.Task2.modelmapper.model.Department;
import com.ivo.Task2.modelmapper.model.Employee;
import com.ivo.Task2.modelmapper.model.Employer;
import com.ivo.Task2.modelmapper.model.Role;
import com.ivo.Task2.modelmapper.model.Task;
import com.ivo.Task2.modelmapper.model.Update;
import com.ivo.Task2.modelmapper.model.User;
import com.ivo.Task2.service.DepartmentService;
import com.ivo.Task2.service.EmployeeService;
import com.ivo.Task2.service.EmployerService;
import com.ivo.Task2.service.RoleService;
import com.ivo.Task2.service.TaskService;
import com.ivo.Task2.service.UpdateService;
import com.ivo.Task2.service.UserService;



@RestController
@RequestMapping("/viewData")
public class UserResource {
//-----------------------Declarations-----------------	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	@Autowired
	TaskService taskService;
	
	@Autowired
	UpdateService updateService;
	
	@Autowired
	EmployerService employerService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
//------------------------Check for existing rows--------------------------------------------------------------------
//------------------------Taken User name--------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/takenuser/{username}")
	//////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> usernameTaken(@PathVariable String username) {
		Optional<User> currentUserOptional = userService.findByUsername(username);
		if (currentUserOptional.isPresent()) {
			return new ResponseEntity(new customErrorType("Username is taken"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(new customErrorType("Username is available"), HttpStatus.OK);
		}
	}
	
//------------------------Taken email-----------------------------------------------

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/takenemail/{email}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> emailTaken(@PathVariable String email) {
		Optional<User> currentUserOptional = userService.findByEmail(email);
		if (currentUserOptional.isPresent()) {
			return new ResponseEntity(new customErrorType("Email is taken"), HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity(new customErrorType("Email is free"), HttpStatus.OK);
		}
	}
	
//------------------------Taken department------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = "/takenDepartment/{department}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> departmentTaken(@PathVariable String department) {
		Optional<Department> currentDepartment = departmentService.findByName(department);
		if (currentDepartment.isPresent()) {
			return new ResponseEntity(new customErrorType("Department is taken"), HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity(new customErrorType("Department is free"), HttpStatus.OK);
		}
	}
	
//------------------------Taken task------------------------------------------
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@PostMapping(value = "/takenTask/{title}")
		////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
		public ResponseEntity<?> takenTask(@PathVariable String title) {
			Optional<Task> task = taskService.findByName(title);
			if (task.isPresent()) {
				return new ResponseEntity(new customErrorType("Department is taken"), HttpStatus.CONFLICT);
			} else {
				return new ResponseEntity(new customErrorType("Department is free"), HttpStatus.OK);
			}
		}
	
//------------------------Get Data------------------------------------------------------------------------------------
//------------------------Returns all task titles for the select forms---------------	
	@GetMapping("/tasks")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<List<String>> getTasks(){
			List<String> titles = new ArrayList<String>();
			List<Task> tasks = taskService.findAll();
			Iterator<Task> taskIterator = tasks.iterator();
			while (taskIterator.hasNext()) {
				titles.add(taskIterator.next().getTitle());
			}
			return new ResponseEntity<List<String>>(titles, HttpStatus.OK);
	}

//------------------------------Get tasks for logged employee----------------
	@GetMapping("/tasks/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<Set<Task>> getEmployeeTasks(@PathVariable Long id){
		Set<Task> tasks = employeeService.findById(id).get().getTask();
		return new ResponseEntity<Set<Task>>(tasks, HttpStatus.OK);
	}

//-----------------------------Department titles for select forms-------------
	@GetMapping(value="/department/name")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<List<String>> getDepartmentNames(){
		List<String> departmentNames = new ArrayList<String>();
		List<Department> departments = departmentService.findAll();
		Iterator<Department> departmentIterator = departments.iterator();
		while (departmentIterator.hasNext()) {
			departmentNames.add(departmentIterator.next().getName());
		}
		return new ResponseEntity<List<String>>(departmentNames, HttpStatus.OK);
	}
	
//-----------------------------Department id for select forms-------------	
	@GetMapping(value="/department/id")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<List<Long>> getDepartmentIds(){
		List<Long> departmentIds = new ArrayList<Long>();
		List<Department> departments = departmentService.findAll();
		Iterator<Department> departmentIterator = departments.iterator();
		while (departmentIterator.hasNext()) {
			departmentIds.add(departmentIterator.next().getId());
		}
		return new ResponseEntity<List<Long>>(departmentIds, HttpStatus.OK);
	}
	
//----------------------------Employer ids for select forms----------------
	@GetMapping(value="/employer/id")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<List<Long>> getEmployers(){
		List<Long> employerIds = new ArrayList<Long>();
		List<Employer> employers = employerService.findAll();
		Iterator<Employer> employerIterator = employers.iterator();
		while (employerIterator.hasNext()) {
			employerIds.add(employerIterator.next().getUser().getId());
		}
		return new ResponseEntity<List<Long>>(employerIds, HttpStatus.OK);
	}

//-----------------------------Number of assigned employees for logged employer-------------
	@GetMapping(value="/employeeNum/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<Integer> getEmployeeNum(@PathVariable Long id){
		Optional<Employer> employer = employerService.findById(id);
		if(employer.isPresent()) {
		return new ResponseEntity<Integer>(employer.get().getEmployee().size(), HttpStatus.OK);
		}
		else return new ResponseEntity<Integer>(0,HttpStatus.CONFLICT);
	}

//----------------------Used to fill in form fields for employee editing by self--------------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value="/employee/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
		Optional<Employee> employee = employeeService.findById(id);
		if(employee.isPresent()) {
		return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
		}
		else return new ResponseEntity(HttpStatus.CONFLICT);
	}

//----------------------Used to show the actual name of the employer in select field rather than id--------------
	@GetMapping(value="/employer/name/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<String> getEmployerName(@PathVariable Long id){
		Optional<User> user = userService.findById(id);
		String name = user.get().getFirstName();
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
	
//----------------------------------Returns an employer, used for view data------------------------------
	@SuppressWarnings("rawtypes")
	@GetMapping(value="/employer/{page}/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> getEmployees(@PathVariable int page,@PathVariable Long id) {
		Pageable firstPage = PageRequest.of(page, 8);
		Page<Employer> users = employerService.findById(page, firstPage, id);
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Employer>>(users, HttpStatus.OK);
	} 

//-------------------------Shows updates for an employee---------------
	@GetMapping(value="/updates/{page}/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> getUpdates(@PathVariable int page,@PathVariable Long id) {
		Pageable firstPage = PageRequest.of(page, 8);
		Page<Update> updates = updateService.findByEmployeeId(page, firstPage, id);
		return new ResponseEntity<Page<Update>>(updates, HttpStatus.OK);
	}

//--------------------------Returns the updates for an employer in a page of size 1----------------
	@GetMapping(value="/lastUpdate/{page}/{id}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> getLastUpdate(@PathVariable int page,@PathVariable Long id) {
		Pageable firstPage = PageRequest.of(page, 1, Sort.by("time").descending());
		Page<Update> update = updateService.findByEmployerId(page, firstPage, id);
		return new ResponseEntity<Page<Update>>(update, HttpStatus.OK);
	}

//----------------------------Returns the role of logged user-------------------------------
	@GetMapping("/logged")
	public Collection<? extends GrantedAuthority> getLoggedAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getAuthorities();
	}

//--------------------------------Returns the id of logged user-------------------------------	
	@GetMapping(value="/principal")
	public Long getPrincipal() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName()!="anonymousUser")
			return userService.findByUsername(auth.getName()).get().getId();
		return (long)0;
	}

//--------------------------------All users as User entity for view data as admin---------------------
	@SuppressWarnings("rawtypes")
	////@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/{page}")
	public ResponseEntity<?> getAll(@PathVariable int page) {
		Pageable firstPage = PageRequest.of(page, 8);		
		Page<User> users = userService.getAll(page, firstPage);
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
	}

//-------------------------------If admin - search through roles and user entity attributes---------
//								If employer - search through all the employee and user fields------
//								If employee - serch through updates by message or task title-------------
	@SuppressWarnings("rawtypes")
	@GetMapping("/search/{key}/{page}")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER','EMPLOYEE')")
	public ResponseEntity<?> search(@PathVariable String key, @PathVariable int page) {
		Pageable firstPage = PageRequest.of(page, 8);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
			Pageable secondPage = PageRequest.of(page, 8);
			Page<User> users = userService.search(firstPage, key);
			Set<Role> role = roleService.findByName(key.toUpperCase());
			Page<User> byRole = userService.findByRole(secondPage, role);
			if (users.isEmpty()) {
				if(key.matches("[0-9]+")) {
					Long id= Long.valueOf(key);
					System.out.println(id);
					Pageable thirdPage = PageRequest.of(page, 8);
					Page<User> byId = userService.findById(thirdPage, id);
					if(byId.isFirst()) {
						Page<UserDTO> usersDtoById = convertAll(firstPage, byId);
						return new ResponseEntity<Page<UserDTO>>(usersDtoById, HttpStatus.OK);
					}
				}				
				if(byRole.isFirst()) {
					if(auth.getAuthorities().toString().equals("[ROLE_USER]")) {
						return new ResponseEntity(HttpStatus.OK);
					}
					Page<UserDTO> usersDtoByRole = convertAll(firstPage, byRole);
					return new ResponseEntity<Page<UserDTO>>(usersDtoByRole, HttpStatus.OK);
				}
			}
			Page<UserDTO> usersDto = convertAll(firstPage, users);
			return new ResponseEntity<Page<UserDTO>>(usersDto, HttpStatus.OK);
		}
		else if (auth.getAuthorities().toString().equals("[ROLE_EMPLOYER]")){
		String employerName = auth.getName();
		Long employerId = userService.findByUsername(employerName).get().getId();
		Page<Employee> employees = employeeService.search(firstPage, key, employerId);
			if(employees.hasContent())
				return new ResponseEntity<Page<Employee>>(employees, HttpStatus.OK);
			if(employees.isEmpty()) {
				Page<User> user = userService.search(firstPage, key);
					Long id = user.getContent().iterator().next().getId();
					Page<Employee> newEmployee = employeeService.pageFindById(0, firstPage, id,  employerId);
				return new ResponseEntity<Page<Employee>>(newEmployee, HttpStatus.OK);
			}
			if(key.matches("[0-9]+")) {
				int inter = Integer.valueOf(key);
				Page<Employee> employee = employeeService.search(firstPage, inter, employerId);
				return new ResponseEntity<Page<Employee>>(employee, HttpStatus.OK);
			}
		return new ResponseEntity<Page<Employee>>(employees,HttpStatus.NO_CONTENT);
		}
		else if (auth.getAuthorities().toString().equals("[ROLE_EMPLOYEE]")) {
			String employeeName = auth.getName();
			Long employeeId = userService.findByUsername(employeeName).get().getId();
			Page<Update> found = updateService.search(page, firstPage, key, employeeId);
			if(!found.isEmpty()) {
				return new ResponseEntity<Page<Update>>(found, HttpStatus.OK);
			}
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
//-------------------------------------Create---------------------------------------------------------------------------------------
//----------------------------Create employee, accessed by admin or employer----------------------------	
	@PostMapping(value="/employee", produces = "application/json", consumes = "application/json")
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER')")
	public ResponseEntity<?> createEmployee(@RequestBody final Employee employee) throws ParseException {
		User user = employee.getUser();
		Set<Role> roles = roleService.findByName("EMPLOYEE");
		user.setRoles(roles);
		user.setActive(1);
		userService.create(user);
		user.setEmployee_id(user.getId());
		userService.update(user);
		Optional<Department> optDepartment = departmentService.findById(employee.getDepartment().getId());
		employee.setDepartment(optDepartment.get());
		Set<Task> task = new HashSet<Task>();
		employee.setTask(task);
		employeeService.create(employee);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
//----------------------------Create employer-------------------------------------------------------------	
	@PostMapping(value="/employer", consumes = "application/json")
	////@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> createEmployer(@RequestBody final Employer employer) throws ParseException {
		User user = employer.getUser();
		Set<Role> roles = roleService.findByName("EMPLOYER");
		user.setRoles(roles);
		userService.create(user);
		user.setEmployer_id(user.getId());
		userService.update(user);
		employerService.create(employer);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
//------------------------------Create department----------------------------------------------------------	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	////@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(value="/department", produces = "application/json", consumes="application/json")
	public ResponseEntity<?> createDepartment(@RequestBody final Department department) throws ParseException{
		Optional<Department> taken = departmentService.findByName(department.getName());
		if(taken.isPresent()) {
			return new ResponseEntity(new customErrorType("Department already exsists"), HttpStatus.CONFLICT);
		}
		else {
			departmentService.create(department);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

//-----------------------------Create task------------------------------------------------------------------	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	////@PreAuthorize("hasAnyRole('ADMIN','EMPLOYER')")
	@PostMapping(value="/employee/task", produces="application/json", consumes = "application/json")
	public ResponseEntity<?> createTask(@RequestBody final Task task) throws ParseException {
		if(taskService.findByName(task.getTitle()).isPresent())
		{
			return new ResponseEntity(new customErrorType("Task is a duplicate"), HttpStatus.OK);
		}
		else
		{
			taskService.create(task);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

//------------------------------------------------Create update----------------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	////@PreAuthorize("hasAnyRole('EMPLOYEE')")
	@PostMapping(value="/update/{task_id}/{employee_id}", produces="application/json", consumes="application/json")
	public ResponseEntity<?> createUpdate(@RequestBody final Update update,@PathVariable Long task_id, @PathVariable Long employee_id) throws ParseException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		update.setEmployeeId(employee_id);
		Optional<Employer> employer = employerService.findByEmployeeId(userService.findByUsername(auth.getName()).get().getEmployee_id());
		update.setEmployerId(employer.get().getId());
		updateService.create(update);
		 Optional<Task> task = taskService.findById(task_id);
		 if(task.isPresent()) {
		  Task currTask = task.get();
		  update.setTaskTitle(currTask.getTitle());
		  Set<Update> updates = currTask.getUpdate();
		  Optional<Update> newUpdate = updateService.findByMessage(update.getMessage());
			  if(newUpdate.isPresent())
			  {
				  updates.add(newUpdate.get());
				  currTask.setUpdate(updates);
				  taskService.create(currTask); 
			  }
			  else {
				  return new ResponseEntity( new customErrorType("Creating an update failed."), HttpStatus.BAD_REQUEST);
			  }
		  }
		 else return new ResponseEntity( new customErrorType("Creating an update failed."), HttpStatus.BAD_REQUEST);
		 return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	//-------------------------------------Data Updates------------------------------------------------------------

//--------------------------------------Update user entities--------------------------------------
	@SuppressWarnings({ "unchecked", "rawtypes" })
	////@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody UserDTO userDto) throws ParseException {
		User user = convertToEntity(userDto);
		Optional<User> currentUserOptional = userService.findById(id);

		if (!currentUserOptional.isPresent()) {
			return new ResponseEntity(new customErrorType("Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		} else {
			User currentUser = currentUserOptional.get();
			currentUser.setFirstName(user.getFirstName());
			currentUser.setLastName(user.getLastName());
			currentUser.setBirthDate(user.getBirthDate());
			currentUser.setPhone(user.getPhone());
			currentUser.setActive(user.getActive());
			userService.update(currentUser);
			return new ResponseEntity(new customErrorType("User with id: " + id + " has been updated."), HttpStatus.OK);
		}
	}

//--------------------------------------Update employees by employer--------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked"})
	////@PreAuthorize("hasAnyRole('EMPLOYER')")
	@RequestMapping(value="/employer/{id}", method=RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> updateByEmployer(@PathVariable("id") Long id, @RequestBody Employee employee) throws ParseException{
		Optional<Employee> optEmployee = employeeService.findById(id);
		if(optEmployee.isPresent()) {
			Employee contentEmployee = optEmployee.get();
			//-----------------Set active--------------
			if(employee.getUser()!=null) {
			User user = contentEmployee.getUser();
			User sentUser = employee.getUser();
			user.setActive(sentUser.getActive());
			contentEmployee.setUser(user);
			}
			//-----------------Set department, job, salary, bonus, commission--------
			if(employee.getDepartment()!=null) {
				Optional<Department> optDepartment = departmentService.findById(employee.getDepartment().getId());
				contentEmployee.setDepartment(optDepartment.get());
			}
			if(employee.getJob()!=null) {
			contentEmployee.setJob(employee.getJob());
			}
			if(employee.getBonus()!=null) {
			contentEmployee.setBonus(employee.getBonus());
			}
			if(employee.getCommission()!=null) {
			contentEmployee.setCommission(employee.getCommission());
			}
			if(employee.getTask()!=null) {
			Set<Task> task = employee.getTask();
			Task contentTask = task.iterator().next();
			Optional<Task> optTask = taskService.findByName(contentTask.getTitle());
			if(optTask.isPresent()) {
				Task newTask = optTask.get();
				Set<Task> currTasks = optEmployee.get().getTask();
				currTasks.add(newTask);
				contentEmployee.setTask(currTasks);
			}
			}
			employeeService.update(contentEmployee);
			return new ResponseEntity(new customErrorType("Employee has been updated"), HttpStatus.OK);
		}
		else {
			return new ResponseEntity(new customErrorType("Update failed"), HttpStatus.CONFLICT);
		}
	}

//	--------------------------------------Update employee by self--------------------------------------
	@SuppressWarnings({ "rawtypes", "unchecked" })
	////@PreAuthorize("hasAnyRole('EMPLOYEE')")
	@RequestMapping(value="/employee/{id}", method=RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> updateByEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) throws ParseException{
		Optional<Employee> optEmployee = employeeService.findById(id);
		if(optEmployee.isPresent()) {
		Employee contentEmployee = optEmployee.get();
		
		//-----------------Set User--------------
		User user = contentEmployee.getUser();
		User sentUser = employee.getUser();
		if(sentUser.getFirstName()!=null)
		user.setFirstName(sentUser.getFirstName());
		if(sentUser.getLastName()!=null)
		user.setLastName(sentUser.getLastName());
		if(sentUser.getBirthDate()!=null)
		user.setBirthDate(sentUser.getBirthDate());
		if(sentUser.getPhone()!=null)
		user.setPhone(sentUser.getPhone());
		if(sentUser.getEmail()!=null)
		user.setEmail(sentUser.getEmail());
		if(sentUser.getPassword()!=null)
		user.setPassword(passwordEncoder.encode(sentUser.getPassword()));
		contentEmployee.setUser(user);
		//-----------------Set Middle name, Gender--------
		if(employee.getMiddleName()!=null)
		contentEmployee.setMiddleName(employee.getMiddleName());
		if(employee.getSex()!=null)
		contentEmployee.setSex(employee.getSex());
		employeeService.update(contentEmployee);
		return new ResponseEntity(new customErrorType("Employee has been updated"), HttpStatus.OK);
		}
		else
			return new ResponseEntity(new customErrorType("Update failed!"), HttpStatus.OK);
	}
	
	//--------------------------------------Delete-------------------------------------------------
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	////@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		
		Optional<User> currentUserOptional = userService.findById(id);

		if (!currentUserOptional.isPresent()) {
			return new ResponseEntity(new customErrorType("Unable to delete. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		} else {
			Set<Role> roles = roleService.findByName("");
			User currentUser = currentUserOptional.get();
			currentUser.setRoles(roles);
			if(currentUser.getEmployer_id()!=null) {
				employerService.deleteById(currentUser.getEmployer_id());
			}
			if(currentUser.getEmployee_id()!=null) {
				employeeService.deleteUserById(currentUser.getEmployee_id());
			}
			return new ResponseEntity(new customErrorType("User with id: " + id + " has been deleted."), HttpStatus.OK);
		}
	}
	//-----------------------------------------DTO conversions---------------------------------------------
	
	private Page<UserDTO> convertAll(Pageable pageable, Page<User> users){
		int totalElements = (int) users.getTotalElements();
		return new PageImpl<UserDTO>(
				users.stream()
				.map(User -> new UserDTO(
						User.getId(),
						User.getFirstName(),
						User.getLastName(),
						User.getBirthDate(),
						User.getPhone(),
						User.getEmail(),
						User.getUsername(),
						User.getActive(),
						User.getPassword(),
						User.getRoles(),
						User.getEmployee_id()))
				.collect(Collectors.toList()), pageable, totalElements);
	}
	
	private User convertToEntity(UserDTO userDto) throws ParseException {
	    User user = modelMapper.map(userDto, User.class);
	    return user;
	}

}
