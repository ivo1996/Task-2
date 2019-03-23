//---------------------Delete table row event---------------------------------		
$(document).on('click', '.delete-btn', function(event) {
	event.preventDefault();
	$('.container-fluid').empty();
	let URL = $(this).attr('href');
	$.ajax({
		type : 'DELETE',
		url : URL,
		data : {},
		success : function(response) {
			$('#viewData').click();
		},
		error : function(error) {
		}
	});
	return 0;
});
// ---------------------Edit user modal event---------------------------------
$(document).on(
		'submit',
		'#modal-user-form',
		function(event) {
			event.preventDefault();
			if (validateName($('input[type=text].inputFirstName').val())
					&& validateName($('input[type=text].inputLastName').val())
					&& validateDate($('input[type=text].inputBirthDate').val())
					&& validatePhone($('input[type=text].inputPhone').val())
					&& matchesPwd($('input.inputPassword.password1').val(), $(
							'input.inputPassword.password2').val())) {
				let URL = 'viewData/' + userId;
				$form = $(this);
				let data = JSON.stringify(getFormData($form));
				$.ajax({
					type : 'PUT',
					url : URL,
					data : data,
					dataType : 'json',
					contentType : 'application/json',
					success : function(response) {
						$("#myModal").modal('hide').one('hidden.bs.modal',
								function(e) {
									console.log(response);
									$(this).off('shown.bs.modal');
									$('.container-fluid').empty();
									showTable(tableUrl);
								});
					},
					error : function(error) {
						console.log(error);
					}
				});
				return 0;
			}
		});
//---------------------Edit Employee by Employer modal event---------------------------------
$(document).on(
		'submit',
		'#modal-editEmployee-form',
		function(event) {
			event.preventDefault();
				let URL = 'viewData/employer/' + userId;
				$form = $(this);
				let data = JSON.stringify(getCustomData($form));
				$.ajax({
					type : 'PUT',
					url : URL,
					data : data,
		            dataType: 'html',
					contentType : 'application/json',
					success : function(response) {
						$("#editEmployeeModal").modal('hide').one('hidden.bs.modal',
								function(e) {
									$(this).off('shown.bs.modal');
									$('.container-fluid').empty();
									showEmployerTable(tableUrl);
								});
					},
					error : function(error) {
						console.log(error);
					}
				});
				return 0;
		});
//---------------------Submit employer modal event---------------------------------
$(document).on(
		'submit',
		'#modal-employer-form',
		function(event) {
			event.preventDefault();
			$form = $(this);
			validateObject = $(this).serializeArray();
			if (validateName(validateObject[3].value)
					&&validateName(validateObject[4].value)
					&&validateDate(validateObject[5].value)
					&&validatePhone(event.currentTarget[6].value)
					&&matchesPwd(event.currentTarget[1].value,event.currentTarget[2].value)) {
				takenUsername(validateObject[0].value).then(function(response){
					takenEmail(validateObject[8].value).then(function(response){
						let URL = 'viewData/employer';
						let data = JSON.stringify(getCustomData($form));
						$.ajax({
							type : 'POST',
							url : URL,
							data : data,
							contentType : 'application/json',
							success : function(response) {
								$("#employerModal").modal('hide').one('hidden.bs.modal',
										function(e) {
											$(this).off('shown.bs.modal');
										});
							},
							error : function(error) {
								console.log(error);
							}
						});
					});
				});
				return 0;
			}
		});
//---------------------Submit employee modal event---------------------------------
$(document).on(
		'submit',
		'#modal-employee-form',
		function(event) {
			event.preventDefault();
			$form = $(this);
			validateObject = $(this).serializeArray();
			if (validateName(validateObject[5].value)
					&&validateName(validateObject[3].value)
					&&validateDate(validateObject[14].value)
					&&validateDate(validateObject[15].value)
					&&validatePhone(validateObject[16].value)
					&&validatePhone(validateObject[11].value)
					&&validatePhone(validateObject[12].value)
					&&validatePhone(validateObject[13].value)
					&&validatePhone(validateObject[10].value)
					&&validatePhone(validateObject[9].value)
					&&validatePhone(validateObject[7].value)
					&&validateName(validateObject[6].value)
					&&validateInitial(validateObject[4].value)
					&&matchesPwd(validateObject[1].value,validateObject[2].value)) {
				takenUsername(validateObject[0].value).then(function(response){
					takenEmail(validateObject[17].value).then(function(response){
						let URL = 'viewData/employee';
						let data = JSON.stringify(getCustomData($form));
						$.ajax({
							type : 'POST',
							url : URL,
							data : data,
							contentType : 'application/json',
							success : function(response) {
								$("#employeeModal").modal('hide').one('hidden.bs.modal',
										function(e) {
											$(this).off('shown.bs.modal');
										});
							},
							error : function(error) {
								console.log(error);
							}
						});
					});
				});
				return 0;
			}
		});
//---------------------Submit Edit employee by self modal event---------------------------------
$(document).on(
		'submit',
		'#modal-editEmployeeSelf-form',
		function(event) {
			event.preventDefault();
			if (validateName($('#modalFirstNameEmployeeBySelf').val())
					&&validateName($('#modalLastNameEmployeeBySelf').val())
					&&validateDate($('#modalBirthDateEmployeeSelf').val())
					&&validatePhone($('#modalPhoneEmployeeSelf').val())
					&&matchesPwd($('#modalPassword1EmployeeBySelf').val(),$('#modalPassword2EmployeeBySelf').val())) {
				let URL = 'viewData/employee/'+currentUser;
				$form = $(this);
				let data = JSON.stringify(getCustomData($form));
				console.log(data);
				$.ajax({
					type : 'PUT',
					url : URL,
					data : data,
					contentType : 'application/json',
					success : function(response) {
						console.log(response);
						$("#selfEditEmployeeModal").modal('hide').one('hidden.bs.modal',
								function(e) {
									$(this).off('shown.bs.modal');
								});
					},
					error : function(error) {
						console.log(error);
					}
				});
				return 0;
			}
		});
// ----------------------Submit department-----------------------------------
$(document)
		.on(
				'submit',
				'#modal-department-form',
				function(event) {
					event.preventDefault();
					if (takenDepartment($(
							'input[type=text].inputDepartmentName').val()).statusText == "success") {
						let URL = $(this).attr('action');
						$form = $(this);
						let data = JSON.stringify(getFormData($form));
						$.ajax({
							type : 'POST',
							url : URL,
							data : data,
							contentType : 'application/json',
							success : function(response) {
								console.log(response);
								$("#departmentModal").modal('hide').one(
										'hidden.bs.modal', function(e) {
											console.log(response);
											$(this).off('shown.bs.modal');
										});
							},
							error : function(error) {
								console.log(error);
							}
						});
						return 0;
					}
				});
//----------------------Submit task-----------------------------------
$(document)
		.on(
				'submit',
				'#modal-task-form',
				function(event) {
					event.preventDefault();
					if (takenTask($(
							'input[type=text].inputTaskTitle').val()).statusText == "success") {
						let URL = $(this).attr('action');
						$form = $(this);
						let data = JSON.stringify(getFormData($form));
						$.ajax({
							type : 'POST',
							url : URL,
							data : data,
							contentType : 'application/json',
							success : function(response) {
								$("#taskModal").modal('hide').one(
										'hidden.bs.modal', function(e) {
											$(this).off('shown.bs.modal');
										});
							},
							error : function(error) {
								console.log(error);
							}
						});
						return 0;
					}
				});
//----------------------Submit update-----------------------------------
$(document)
		.on(
				'submit',
				'#modal-update-form',
				function(event) {
					event.preventDefault();
						let URL = '/viewData/update/'+$('#id_Tasks').val()+'/'+currentUser;
						$form = $(this);
						let data = JSON.stringify(getFormData($form));
						$.ajax({
							type : 'POST',
							url : URL,
							data : data,
							contentType : 'application/json',
							success : function(response) {
								$("#updateModal").modal('hide').one(
										'hidden.bs.modal', function(e) {
											$(this).off('shown.bs.modal');
										});
							},
							error : function(error) {
								console.log(error);
							}
						});
						return 0;
				});
// ---------------------Search submit event---------------------------------
$(document).on('submit', '#searchForm', function(e) {
	e.preventDefault();
	if (auth == 'ROLE_ANONYMOUS') {
		$('[data-toggle="popover"]').popover("show");
	} else {
		let data = getFormData($(this));
		if (data.q == '') {
			if(auth == 'ROLE_ADMIN')
				tableUrl = '/viewData/0';
			if(auth == 'ROLE_EMPLOYER')
				tableUrl='/viewData/employer/0/'+currentUser;
			if(auth == 'ROLE_EMPLOYEE')
				tableUrl='/viewData/updates/0/'+currentUser;
		} else {
			page = 0;
			maxPage = null;
			tableUrl = '/viewData/search/' + data.q + '/0';
		}
		if(auth == 'ROLE_ADMIN')
			showTable(tableUrl);
		if(auth == 'ROLE_EMPLOYER')
			showEmployerTable(tableUrl);
		if(auth == 'ROLE_EMPLOYEE')
			showUpdatesTable(tableUrl);
	}
	return 0;
});