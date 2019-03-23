
<!-- Modal -->
<div class="modal fade" id="employerModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Employer</h4>
			</div>
			<div class="modal-body">
				<form id="modal-employer-form" action="/viewData/employer">
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
						<input type="text" class="inputFirstName" id="modalFirstNameEmployer"
							name="firstName" placeholder="First Name" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputLastName" id="modalLastNameEmployer"
							name="lastName" placeholder="Last Name" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputBirthDate datepicker" id="modalBirthDateEmployer"
							name="birthDate" placeholder="Birth Date" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div>
					<input type="text" class="inputPhone" id="modalPhoneEmployer" name="phone"
						placeholder="Phone Number" /> <span class="correct"></span><span
						class="incorrect"></span>
					</div>
					<label for="id_active_employer"> Active </label>
					<div class="form-group">
						<select class="inputActive" id="id_active_employer" name="active">
							<option value="0">0</option>
							<option value="1" selected="selected">1</option>
						</select>
					</div>
					<div class="form-group">
						<input class="inputEmail" type="text" name="email"
							placeholder="E-mail address" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
				<div class="modal-footer">
					<input type="submit" class="btn btn-primary" id="modalSubmitEmployer"
						value="Submit">
				</div>
			</form>
			</div>
		</div>
	</div>

</div>
</div>