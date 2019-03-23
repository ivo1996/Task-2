
<!-- Modal -->
<div class="modal fade" id="selfEditEmployeeModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Edit User</h4>
			</div>
			<div class="modal-body">
				<form id="modal-editEmployeeSelf-form" action="/viewData/employee/">
					<div class="form-group">
						<input class="inputPassword password1" type="password" id="modalPassword1EmployeeBySelf"
							name="password" placeholder="Password" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input class="inputPassword password2" type="password" id="modalPassword2EmployeeBySelf"
							name="password" placeholder="Retype Password" />
					</div>
					<div class="form-group">
						<input type="text" class="inputFirstName" id="modalFirstNameEmployeeBySelf"
							name="firstName" placeholder="First Name" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputMiddleInitial" id="modalMiddleInitialBySelf"
							name="middleName" placeholder="Middle Name Initial" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputLastName" id="modalLastNameEmployeeBySelf"
							name="lastName" placeholder="Last Name" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<label for="id_sex_bySelf"> Gender </label>
						<select id="id_sex_bySelf" name="sex" form="modal-editEmployeeSelf-form">
							<option value="M">M</option>
							<option value="F">F</option>
						</select>
					</div>
					<div class="form-group">
						<input type="text" class="inputBirthDate datepicker" id="modalBirthDateEmployeeSelf"
							name="birthDate" placeholder="Birth Date" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputPhone" id="modalPhoneEmployeeSelf" name="phone"
							placeholder="Phone Number" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input class="inputEmail" type="text" name="email" id="modalEmailEmployeeSelf"
							placeholder="E-mail address" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" id="modalEditEmployeeSelf"
							value="Submit">
					</div>
				</form>
			</div>
		</div>

	</div>
</div>