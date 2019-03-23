//---------------------Default page load --------------------------
	$(document).ready(function(){
		getAuth().done(function(response){
			auth=response[0].authority;
			getUsername().then(function(response){
			if(auth=='ROLE_ANONYMOUS'){
				$('#btnLogout').hide();
				$('#btnLogin').show();
			}
			else{
				$('#btnLogin').hide();
				$('#btnLogout').show();
			}
		});
		});
		$('#ui-datepicker-div').remove();
		$('.container-fluid').empty();
	$('.container-fluid').load('/welcome');
	});

//---------------------View data click click event---------------------------------		
		getAuth().done(function(response){
			auth=response[0].authority;
				getUsername().done(function(response){
					$(document).on('click','#viewData', function () {
					if(auth=='ROLE_ANONYMOUS'){
						$('[data-toggle="popover"]').popover("show");
					}
					else if(auth=='ROLE_EMPLOYER'){
						page=0;
						maxPage = null;
						tableUrl='/viewData/employer/0/'+currentUser;
						showEmployerTable(tableUrl);
					}
					else if(auth=='ROLE_EMPLOYEE'){
						page=0;
						maxPage = null;
						tableUrl='/viewData/updates/0/'+currentUser;
						showUpdatesTable(tableUrl);
					}
					else{
						page=0;
						maxPage = null;
						tableUrl='/viewData/0';
						showTable(tableUrl);
					}
					});
				});
			});
//---------------------View Updates by Employer event---------------------------------
		$(document).on('click','.update', function(){
			$('.container-fluid').empty();
			page=0;
			maxPage = null;
			tableUrl='/viewData/updates/0/'+$(this).attr('id').replace( /^\D+/g, '');
			showUpdatesTable(tableUrl);
		});
//---------------------View Last Update---------------------------------
		$(document).on('click','#viewLastUpdate', function(){
			$('.container-fluid').empty();
			page=0;
			maxPage = null;
			tableUrl='/viewData/lastUpdate/0/'+currentUser;
			showUpdatesTable(tableUrl);
		});		
//---------------------Insert data click event---------------------------------
			$('#insertData').click(function () {
				$('#ui-datepicker-div').remove();
				$('.container-fluid').empty();
			$('.container-fluid').load('/welcome');
		});
			
//---------------------Control panel click event---------------------------------			
			getAuth().done(function(response){
				auth=response[0].authority;
					$('#controlPanel').click(function () {
						$('#ui-datepicker-div').remove();
					if(auth=='ROLE_ANONYMOUS'){
						$('[data-toggle="popover"]').popover("show");
					}
					else if(auth=='ROLE_ADMIN'){
						$('.container-fluid').empty();
						$('.container-fluid').load('/panel');
					}
					else if(auth=='ROLE_EMPLOYEE'){
						$('.container-fluid').empty();
						$('.container-fluid').load('/employeePanel');
					}
					else if(auth=='ROLE_EMPLOYER'){
						$('.container-fluid').empty();
						$('.container-fluid').load('/employerPanel');
					}
					});
			});
//----------------------Create employee modal--------------------------------
		$(document).on('click','#insertEmployee', function(){
			$('#id_employer').empty();
			$('#id_department').empty();
			getEmployerIds().done(function(response){
				for(i=0; i < response.length; i++){
					getEmployerName(response[i]).done(function(name){
					$('#id_employer')
						.append('<option value='+response[i]+'>'+'#'+response[i]+' - '+name+'</option>')
					});
				}
				getDepartmentNames().done(function(name){
					getDepartmentIds().done(function(response){
						for(i=0; i < response.length; i++){
						$('#id_department')
							.append('<option value='+response[i]+'>'+name[i]+'</option>')
						}
					});
				});
			$('#employeeModal').modal()
			});
		});
//----------------------Create employer modal--------------------------------
		$(document).on('click','#insertEmployer', function(){
			$('#employerModal').modal()
		})
//----------------------Create department modal--------------------------------
		$(document).on('click','#insertDepartment', function(){
			$('#departmentModal').modal()
		})	
//----------------------Create task modal--------------------------------
		$(document).on('click','#insertTask', function(){
			$('#taskModal').modal()
		})
//----------------------Create update modal--------------------------------
		$(document).on('click','#insertUpdate', function(){
			$('#id_Tasks').empty();
			getCurrentTasks(currentUser).done(function(response){
				for(i=0; i<response.length;i++){
					$('#id_Tasks')
					.append('<option value="'+response[i].id+'">'+response[i].title+'</option>');
				}
			$('#updateModal').modal()
			});
		})
//----------------------Edit employee by self modal--------------------------------
		$(document).on('click','#editEmployee', function(){
			getEmployee(currentUser).done(function(response){
				$('#modalFirstNameEmployeeBySelf').attr('value',response.user.firstName);
				$('#modalMiddleInitialBySelf').attr('value',response.middleName);
				$('#modalLastNameEmployeeBySelf').attr('value',response.user.lastName);
				$('#modalBirthDateEmployeeSelf').attr('value',response.user.birthDate);
				$('#modalPhoneEmployeeSelf').attr('value',response.user.phone);
				$('#modalEmailEmployeeSelf').attr('value',response.user.email);
				$("#id_sex_bySelf option[value='"+response.sex+"']").attr('selected', 'selected');
				$('#selfEditEmployeeModal').modal()
			});
		})	
//---------------------Datepicker event---------------------------------
		$(document).on('click', '.datepicker', function(e){
			$(this).datepicker({ 
				dateFormat: 'yy-mm-dd',
		        changeMonth: true,
		        changeYear: true
			}).focus();
		});
		
//---------------------Edit table row event-Modal trigger--------------------------------		
		getAuth().done(function(response){
			$(document).on('click', '.modalButton', function(){
				if(auth=='ROLE_EMPLOYER'){
					var departments =[];
					$('#id_department_edit').empty();
					$('#id_tasks_edit').empty();
					$('#id_tasks_edit').append('<option value=\'\'>Do not add task</option>');
					getTaskTitles().done(function(titles){
						for(i=0; i<titles.length; i++){
							$('#id_tasks_edit')
								.append('<option value="'+titles[i]+'">'+titles[i]+'</option>');
						}
					});
					getDepartmentNames().done(function(name){
						getDepartmentIds().done(function(response){
							for(i=0; i < response.length; i++){
							$('#id_department_edit')
								.append('<option value='+response[i]+'>'+name[i]+'</option>');
								departments[name[i]] = response[i];
							}
						});
					});
					userId = $(this).attr('id');
					$('#id_job_edit').attr('value', $(this).closest('tr').find('td').eq(3).text());
					$('#id_salary_edit').attr('value', $(this).closest('tr').find('td').eq(8).text());
					$('#id_bonus_edit').attr('value', $(this).closest('tr').find('td').eq(9).text());
					$('#id_commission_edit').attr('value', $(this).closest('tr').find('td').eq(10).text());
					$("#id_active_employee_edit option[value='"+$(this).closest('tr').find('td').eq(15).text()+"']").attr('selected', 'selected');
					$("#id_department_edit option[value='"+departments[$(this).closest('tr').find('td').eq(7).text()]+"']").attr('selected', 'selected');
					$("#editEmployeeModal").modal();
				}
				else{
					$('#modalFirstName').attr('value', $(this).closest('tr').find('td').eq(2).text());
					$('#modalLastName').attr('value', $(this).closest('tr').find('td').eq(3).text());
					$('#datepicker').attr('value', $(this).closest('tr').find('td').eq(4).text());
					$('#modalEmail').attr('value', $(this).closest('tr').find('td').eq(5).text());
					$('#modalPhone').attr('value', $(this).closest('tr').find('td').eq(6).text());
					$("#modalActive option[value='"+$(this).closest('tr').find('td').eq(7).text()+"']").attr('selected', 'selected');			
					userId = $(this).closest('tr').find('td').eq(0).text();
				    $("#myModal").modal();
				}
			});
		});
		
//-----------------------Login------------------------------
		$(document).on('click', '#btnLogout', function(e){
			e.preventDefault();
			$('.container-fluid').empty();
			$.ajax({
				url: '/logout',
				success: function(response){
					location.reload();
				}
			});
		});
//------------Previous page ------------------
		$(document).on('click','#prev',function(e){
			e.preventDefault();
			if(page-1>=minPage){
				page--;
			}
			getAuth().done(function(response){
				auth=response[0].authority;
				if(auth=='ROLE_ADMIN'){
					tableUrl='/viewData/'+page;
					showTable(tableUrl);
				}
				if(auth=='ROLE_EMPLOYEE'){
					tableUrl='/viewData/updates/'+page+'/'+currentUser;
					showUpdatesTable(tableUrl);
				}
				if(auth=='ROLE_EMPLOYER'){
					tableUrl='/viewData/employer/'+page+'/'+currentUser;
					showEmployerTable(tableUrl);
				}
			});
		});		
//------------Next page ------------------
		$(document).on('click','#next',function(e){
			e.preventDefault();
			if(page+1<maxPage){
				page++;
			}
			getAuth().done(function(response){
				auth=response[0].authority;
				if(auth=='ROLE_ADMIN'){
					tableUrl='/viewData/'+page;
					showTable(tableUrl);
				}
				if(auth=='ROLE_EMPLOYEE'){
					tableUrl='/viewData/updates/'+page+'/'+currentUser;
					showUpdatesTable(tableUrl);
				}
				if(auth=='ROLE_EMPLOYER'){
					tableUrl='/viewData/employer/'+page+'/'+currentUser;
					showEmployerTable(tableUrl);
				}
			});
		});
//------------Previous page on last update------------------
		$(document).on('click','#prev2',function(e){
			e.preventDefault();
			if(page-1>=minPage){
				page--;
			}
			tableUrl='/viewData/lastUpdate/'+page+'/'+currentUser;
			showUpdatesTable(tableUrl);
		});		
//------------Next page on last update------------------
		$(document).on('click','#next2',function(e){
			e.preventDefault();
			if(page+1<maxPage){
				page++;
			}
			tableUrl='/viewData/lastUpdate/'+page+'/'+currentUser;
			showUpdatesTable(tableUrl);
		});