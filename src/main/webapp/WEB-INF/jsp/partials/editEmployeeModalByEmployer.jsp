
<!-- Modal -->
<div class="modal fade" id="editEmployeeModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Edit Employee</h4>
			</div>
			<div class="modal-body">
				<form id="modal-editEmployee-form" action="/viewData/employer/">
					<div class="form-group">
						<label for="id_tasks_edit"> Task </label>
						<select id="id_tasks_edit" name="task" form="modal-editEmployee-form">
						<option value='' selected='selected'">Do not add task</option>
						</select>
					</div>					
					<div class="form-group">
						<input type="text" class="inputJob" id="id_job_edit"
							name="job" placeholder="Job" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<label for="id_department_edit"> Department </label>
						<select id="id_department_edit" name="department" form="modal-editEmployee-form">
						</select>
					</div>
					<div class="form-group">
						<input type="text" class="salary" id="id_salary_edit"
							name="salary" placeholder="Yearly Salary in USD" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="bonus" id="id_bonus_edit"
							name="bonus" placeholder="Yearly bonus in USD" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div class="form-group">
						<input type="text" class="commission" id="id_commission_edit"
							name="commission" placeholder="Yearly commission in USD" /> <span
							class="correct"></span><span class="incorrect"></span>
					</div>
					<div>
						<label for="id_active_employee"> Active </label>
						<select class="inputActive" id="id_active_employee_edit" name="active">
							<option value="0">0</option>
							<option value="1" selected="selected">1</option>
						</select>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" id="modalEditEmployee"
							value="Submit">
					</div>
				</form>
			</div>
		</div>

	</div>
</div>