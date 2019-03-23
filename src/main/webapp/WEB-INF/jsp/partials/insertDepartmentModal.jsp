
<!-- Modal -->
<div class="modal fade" id="departmentModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Department</h4>
			</div>
			<div class="modal-body">
				<form id="modal-department-form" action="/viewData/department">
					<div class="form-group">
						<input class="inputDepartmentName" type="text" name="name"
							placeholder="Name" /><span class="correct"></span><span
							class="incorrect"></span>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" id="modalSubmitData"
							value="Submit">
					</div>
				</form>
			</div>
		</div>

	</div>
</div>