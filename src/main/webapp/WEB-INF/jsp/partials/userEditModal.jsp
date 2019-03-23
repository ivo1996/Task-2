
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Edit User</h4>
			</div>
			<div class="modal-body">
				<form id="modal-user-form" action="/viewData">
					<div class="form-group">
						<input type="text" class="inputFirstName" id="modalFirstName"
							name="firstName" placeholder="First Name" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputLastName" id="modalLastName"
							name="lastName" placeholder="Last Name" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputBirthDate" id="datepicker"
							name="birthDate" placeholder="Birth Date" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="inputPhone" id="modalPhone" name="phone"
							placeholder="Phone Number" /> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="form-group">
						<select class="inputActive" id="modalActive" name="active">
							<option value="0" selected="selected">0</option>
							<option value="1">1</option>
						</select>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" id="modalSubmitData"
							value="Update"> <span class="correct"></span><span
							class="incorrect"></span>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>