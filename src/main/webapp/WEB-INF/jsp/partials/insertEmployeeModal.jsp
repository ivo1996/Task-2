
<!-- Modal -->
<div class="modal fade" id="employeeModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Employee</h4>
			</div>
			<div class="modal-body">
				<form id="modal-employee-form" action="/viewData/employee">
					<div class="form-group">
						<input class="inputUsername" type="text" name="username"
							placeholder="Username" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input class="inputPassword password1" type="password"
							name="password" placeholder="Password" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input class="inputPassword password2" type="password"
							name="password" placeholder="Retype Password" />
					</div>
					<div class="form-group">
						<input type="text" class="inputFirstName" id="modalFirstNameEmployee"
							name="firstName" placeholder="First Name" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputMiddleInitial" id="modalMiddleInitial"
							name="middleName" placeholder="Middle Name Initial" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputLastName" id="modalLastNameEmployee"
							name="lastName" placeholder="Last Name" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputJob"
							name="job" placeholder="Job" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="educationYears"
							name="educationYears" placeholder="Years of education" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<label for="id_sex"> Gender </label>
						<select id="id_sex" name="sex" form="modal-employee-form">
							<option value="M">M</option>
							<option value="F">F</option>
						</select>
					</div>
					<div class="form-group">
						<label for="id_employer"> Employer </label>
						<select id="id_employer" name="employerId" form="modal-employee-form">
						</select>
					</div>
					<div class="form-group">
						<label for="id_department"> Department </label>
						<select id="id_department" name="department" form="modal-employee-form">
						</select>
					</div>
					<div class="form-group">
						<input type="text" class="salary"
							name="salary" placeholder="Yearly Salary in USD" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="bonus"
							name="bonus" placeholder="Yearly bonus in USD" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="commission"
							name="commission" placeholder="Yearly commission in USD" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputHireDate datepicker"
							name="hireDate" placeholder="Hire Date" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputBirthDate datepicker"
							name="birthDate" placeholder="Birth Date" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputPhone" id="modalPhoneEmployee" name="phone"
							placeholder="Phone Number" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input class="inputEmail" type="text" name="email"
							placeholder="E-mail address" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<label for="id_active_employee"> Active </label>
						<select class="inputActive" id="id_active_employee" name="active">
							<option value="0">0</option>
							<option value="1" selected="selected">1</option>
						</select>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" id="modalSubmitEmployee"
							value="Submit">
					</div>
				</form>
			</div>
		</div>

	</div>
</div>