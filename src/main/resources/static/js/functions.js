//----------------------get authority------------------------------
function getAuth(){
	return $.ajax({
		type : 'GET',
		url : '/viewData/logged',
		async: false,
		success: function(response){
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}
//---------------------get username----------------------------
function getUsername(){
	return $.ajax({
		type : 'GET',
		url : '/viewData/principal',
		async: false,
		success: function(response){
			currentUser=response;
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}

//-----------------------Get employer Ids---------------------------
function getEmployerIds(){
	return $.ajax({
		type : 'GET',
		url: 'viewData/employer/id',
		async: false,
		success: function(response){
			
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}
//-----------------------Get employer Ids---------------------------
function getEmployee(id){
	return $.ajax({
		type : 'GET',
		url: 'viewData/employee/'+id,
		async: false,
		success: function(response){
			
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}
//-----------------------Get employer Ids---------------------------
function getEmployeeNum(id){
	return $.ajax({
		type : 'GET',
		url: 'viewData/employeeNum/'+id,
		async: false,
		success: function(response){
		},
		error: function(response){
			console.log(response);
		}
	});
}
//-----------------------Get department Ids---------------------------
function getDepartmentIds(){
	return $.ajax({
		type : 'GET',
		url: 'viewData/department/id',
		async: false,
		success: function(response){
			
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}
//-----------------------Get task titles---------------------------
function getTaskTitles(){
	return $.ajax({
		type : 'GET',
		url: 'viewData/tasks',
		async: false,
		success: function(response){
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}
//-----------------------Get task titles for logged employee---------------------------
function getCurrentTasks(id){
	return $.ajax({
		type : 'GET',
		url: 'viewData/tasks/'+id,
		async: false,
		success: function(response){
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}
//-----------------------Get Department names---------------------------
function getDepartmentNames(){
	return $.ajax({
		type : 'GET',
		url: 'viewData/department/name',
		async: false,
		success: function(reponse){
			
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}

//-----------------------Get Employer name---------------------------
function getEmployerName(id){
	return $.ajax({
		type : 'GET',
		url: 'viewData/employer/name/'+id,
		async: false,
		success: function(name){
			
		},
		error: function(response){
			$('.container-fluid').html(response);
		}
	});
}

//----------------------Validate passwords--------------------------
function matchesPwd(pwd1, pwd2){
	if(pwd1==''){
		return false;
	}
	else if(pwd2==''){
		return false;
	}
	else if(pwd1!=pwd2){
		return false;
	}
	else{
		return true;
	}
}

//---------------Validate taken email--------------------------------
function takenEmail(email){
	return $.ajax({
		type : 'POST',
		url : '/viewData/takenemail/'+email,
		async: false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
		},
		error : function(error) {
		}	
	});
}

//---------------Validate taken username--------------------------------
function takenUsername(username){
	return $.ajax({
		type : 'POST',
		url : '/viewData/takenuser/'+username,
		async: false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
		},
		error : function(response) {
		}
	});
}
//---------------Validate taken task--------------------------------
function takenTask(task){
	return $.ajax({
		type : 'POST',
		url : '/viewData/takenTask/'+task,
		async: false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
		},
		error : function(response) {
		}		
	});
}
//---------------Validate taken department--------------------------------
function takenDepartment(department){
	return $.ajax({
		type : 'POST',
		url : '/viewData/takenDepartment/'+department,
		async: false,
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
		},
		error : function(response) {
		}
		
	});
}

//---------------Validate name function------------------------------      
        function validateName(name)
        {
        	var regex = /^[A-Z][a-zA-Z ]{2,30}$/;
            if (regex.test(name)) {
                return true;
            }
            else {
                return false;
            }
        }
//---------------Validate date function------------------------------             
        function validateDate(date){
        	var regex = /^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/;
            if (regex.test(date)) {
                return true;
            }
            else {
                return false;
            }
        }
//---------------Validate phone function------------------------------                
        function validatePhone(phone){
        	var regex = /^[0-9]*$/;
            if (regex.test(phone)) {
                return true;
            }
            else {
                return false;
            }
        }
//---------------Validate Initial function------------------------------                
        function validateInitial(initial){
        	var regex = /^[A-Z]{0}(?:[a-zA-Z]){1,2}(?:[\.])$/;
            if (regex.test(initial)) {
                return true;
            }
            else {
                return false;
            }
        }
//---------------Validate email function------------------------------        
        function validateEmail(email){
        	var regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            if (regex.test(email)) {
                return true;
            }
            else {
                return false;
            }
        }
//---------------get form data function------------------------------               
		function getFormData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {};
		$.map(unindexed_array, function(n, i) {
			indexed_array[n['name']] = n['value'];
		});
		return indexed_array;
		}
//---------------get custom data function------------------------------               
		function getCustomData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {"user":{}, "department":{}, "task":[{}]};
		$.map(unindexed_array, function(n, i) {
			if(n['name']=='task'){
				indexed_array.task[0]['title']= n['value'];
			}
			else if(n['name']=='active'||
					n['name']=='birthDate'||
					n['name']=='email'||
					n['name']=='firstName'||
					n['name']=='lastName'||
					n['name']=='username'||
					n['name']=='password'||
					n['name']=='phone'){
				if(n['name']=='active'){
					indexed_array.user[n['name']] = parseInt(n['value']);
				}
				else{
					indexed_array.user[n['name']] = n['value'];
				}
			}
			else if(n['name']=='department'){
				indexed_array.department['id'] = n['value'];
			}
			else if(n['name']=='task'){
				indexed_array.department['task'] = n['value'];
			}
			else{
				indexed_array[n['name']] = n['value'];
			}
		});
		return indexed_array;
		}
//------------display table function-----------------------------		
		function showTable(tableUrl){
			$('.container-fluid').empty();
			getAuth().done(function(response){
				auth=response[0].authority
			$('.container-fluid').load('/view',function(){
				$.ajax({
					type: 'GET',
					url: tableUrl,
					headers: {
						Accept: "application/json; charset=utf-8",
						"Content-type": "application/json; charset=utf-8"
					},
					success: function (data) {
						if(sortBy!=null)
							{
						data.content.sort(function(a, b) {
							if(sortBy=="roles"){
								return (a[sortBy][0].role>b[sortBy][0].role) - (a[sortBy][0].role<b[sortBy][0].role);
							}
							return (a[sortBy]>b[sortBy]) - (a[sortBy]<b[sortBy]);
						});
							}				        
						var user_data = '';
						var table_header = '';
						table_header += '<tr><th><a href="#" class="tableHead" id="tableId">ID</a></th>';
						table_header += ' <th><a href="#" class="tableHead" id="username">Username</a></th>';
						table_header += ' <th><a href="#" class="tableHead" id="firstName">First Name</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="lastName">Last Name</a></th>';
						table_header += ' <th><a href="#" class="tableHead" id="birthDate">Birth Date</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="email">E-mail address</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="phone">Phone number</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="active">Active</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="roles">Role</a></th>';
						table_header += '<th>Edit</th>';						
						table_header += '<th>Delete</th>';
						table_header += ' </tr>';
						maxPage = data.totalPages;
						$.each(data.content, function (key, value) {
							user_data += '<tr>';
							user_data += '<td>' + value.id + '</td>';
							user_data += '<td>' + value.username + '</td>';
							user_data += '<td>' + value.firstName + '</td>';
							user_data += '<td>' + value.lastName + '</td>';
							user_data += '<td>' + value.birthDate + '</td>';
							user_data += '<td>' + value.email + '</td>';
							user_data += '<td>' + value.phone + '</td>';
							user_data += '<td>' + value.active + '</td>';
							user_data += '<td>' + value.roles[0].role + '</td>';
							user_data += '<td><a class="btn btn-info modalButton" id="'+ value.id +'">Edit</a></td>';
							if(value.roles[0].role!='ADMIN')
							user_data += '<td><a href="/viewData/'+value.id+'" class="btn btn-danger delete-btn">Delete</a></td>';
							user_data += '</tr>';
						});
						user_data += '<tr><td colspan="1" align="left"><button type="button" id="prev" href="#" class="btn btn-default" disabled>Previous</button></td>';
						user_data += '<td colspan="11" align="right"><button type="button" id="next" href="#" class="btn btn-default" disabled>Next</button></td></tr>';
						$('#table').append(table_header);
						$('#table').append(user_data);
						$('#pageNum').append(page+1+'/'+maxPage);
						if(page-1>=minPage){
							$('#prev').removeAttr("disabled");
						}
						if(page+1<maxPage){
							$('#next').removeAttr("disabled");
						}
					},
					error: function (data){
						$('.container-fluid').html('No results found.');
					}
				});
			});
			});
			}
//---------------------------------------Show table for employer---------------------------------------		
		function showEmployerTable(tableUrl) {
			$('.container-fluid').empty();
			getAuth().done(function(response){
				auth=response[0].authority
			$('.container-fluid').load('/view',function(){
				$.ajax({
					type: 'GET',
					url: tableUrl,
					headers: {
						Accept: "application/json; charset=utf-8",
						"Content-type": "application/json; charset=utf-8"
					},
					success: function (data) {
						if(sortBy!=null)
							{
						data.content.sort(function(a, b) {
							if(sortBy=="roles"){
								return (a[sortBy][0].role>b[sortBy][0].role) - (a[sortBy][0].role<b[sortBy][0].role);
							}
							return (a[sortBy]>b[sortBy]) - (a[sortBy]<b[sortBy]);
						});
							}				        
						var user_data = '';
						var table_header = '';
						table_header += '<tr>';
						table_header += ' <th><a href="#" class="tableHead" id="firstName">First Name</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="middleInitial">Middle name</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="lastName">Last Name</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="job">Job</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="educationYears">Education</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="gender">Sex</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="gender">Tasks</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="department">Department</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="salary">Salary</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="bonus">Bonus</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="commission">Commission</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="hireDate">Hire date</a></th>';
						table_header += ' <th><a href="#" class="tableHead" id="birthDate">Birthdate</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="email">E-mail</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="phone">Phone number</a></th>';
						table_header += '<th><a href="#" class="tableHead" id="active">Active</a></th>';
						table_header += '<th>Edit</th>';
						table_header += '<th>Updates</th>';
						table_header += ' </tr>';
						if(data==null)
							return;
						maxPage = data.totalPages;
						$.each(data.content, function (key, value) {
							if(tableUrl=='/viewData/employer/0/'+currentUser){
								iterator = value.employee;
							}
							else{
								iterator = data.content;
							}
							$.each(iterator, function (key, value) {
							user_data += '<tr>';
							user_data += '<td>' + value.user.firstName + '</td>';
							user_data += '<td>' + value.middleName + '</td>';
							user_data += '<td>' + value.user.lastName + '</td>';
							user_data += '<td>' + value.job + '</td>';
							user_data += '<td>' + value.educationYears + '</td>';
							user_data += '<td>' + value.sex + '</td>';
							user_data += '<td>';
							$.each(value.task, function (key, value) {
								user_data += value.title + ', ';
							});
							user_data += '</td>';
							user_data += '<td>' + value.department.name + '</td>';
							user_data += '<td>' + value.salary + '</td>';
							user_data += '<td>' + value.bonus + '</td>';
							user_data += '<td>' + value.commission + '</td>';
							user_data += '<td>' + value.hireDate + '</td>';
							user_data += '<td>' + value.user.birthDate + '</td>';
							user_data += '<td>' + value.user.email + '</td>';
							user_data += '<td>' + value.user.phone + '</td>';
							user_data += '<td>' + value.user.active + '</td>';
							user_data += '<td><a class="btn btn-info modalButton" id="'+ value.id +'">Edit</a></td>';
							user_data += '<td><a class="btn btn-info update" id="updateFor'+value.id+'">View Updates</a></td>';
							user_data += '</tr>';
							});
						});
						user_data += '<tr><td colspan="1" align="left"><button type="button" id="prev" href="#" class="btn btn-default" disabled>Previous</button></td>';
						user_data += '<td colspan="17" align="right"><button type="button" id="next" href="#" class="btn btn-default" disabled>Next</button></td></tr>';
						$('#table').append(table_header);
						$('#table').append(user_data);
						$('#pageNum').append(page+1+'/'+maxPage);
						if(page-1>=minPage){
							$('#prev').removeAttr("disabled");
						}
						if(page+1<maxPage){
							$('#next').removeAttr("disabled");
						}
					},
					error: function (data){
						$('.container-fluid').html('No results found.');
					}
				});
			});
			});
			}
//------------display updates table function-----------------------------		
		function showUpdatesTable(tableUrl){
			$('.container-fluid').empty();
			getAuth().done(function(response){
				auth=response[0].authority
			$('.container-fluid').load('/view',function(){
				$.ajax({
					type: 'GET',
					url: tableUrl,
					headers: {
						Accept: "application/json; charset=utf-8",
						"Content-type": "application/json; charset=utf-8"
					},
					success: function (data) {
						if(sortBy!=null)
							{
						data.content.sort(function(a, b) {
							if(sortBy=="roles"){
								return (a[sortBy][0].role>b[sortBy][0].role) - (a[sortBy][0].role<b[sortBy][0].role);
							}
							return (a[sortBy]>b[sortBy]) - (a[sortBy]<b[sortBy]);
						});
							}				        
						var user_data = '';
						var table_header = '';
						table_header += '<tr>';
						if(auth!='ROLE_EMPLOYEE'){
							table_header += ' <th>Employee</th>';
						}
						table_header += ' <th>Task</th>';
						table_header += ' <th>Message</th>';
						table_header += ' <th>Time</th>';
						table_header += ' </tr>';
						maxPage = data.totalPages;
						$.each(data.content, function (key, value) {
							user_data += '<tr>';
							if(auth!='ROLE_EMPLOYEE'){
							user_data += '<td>' + getEmployerName(value.employeeId).responseText + '</td>';
							}
							user_data += '<td>' + value.taskTitle + '</td>';
							user_data += '<td>' + value.message + '</td>';
							user_data += '<td>' + value.time + '</td>';
							user_data += '</tr>';
						});
						user_data += '<tr><td colspan="1" align="left"><button type="button"';
						if(auth=='ROLE_EMPLOYEE'){
							user_data += 'id="prev"';
						}
						else{
							user_data += 'id="prev2"';
						}
						user_data += 'href="#" class="btn btn-default" disabled>Previous</button></td>';
						if(auth=='ROLE_EMPLOYEE'){
							user_data += '<td colspan="2" align="right"><button type="button"';
							user_data += 'id="next"';
						}
						else{
							user_data += '<td colspan="3" align="right"><button type="button"';
							user_data += 'id="next2"';
						}
						user_data += 'href="#" class="btn btn-default" disabled>Next</button></td></tr>';
						$('#table').append(table_header);
						$('#table').append(user_data);
						$('#pageNum').append(page+1+'/'+maxPage);
						if(page-1>=minPage){
							$('#prev').removeAttr("disabled");
							$('#prev2').removeAttr("disabled");
						}
						if(page+1<maxPage){
							$('#next').removeAttr("disabled");
							$('#next2').removeAttr("disabled");
						}
					},
					error: function (data){
						$('.container-fluid').html('No results found.');
					}
				});
			});
			});
			}