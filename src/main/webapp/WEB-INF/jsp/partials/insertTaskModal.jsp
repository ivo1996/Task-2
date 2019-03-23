
<!-- Modal -->
<div class="modal fade" id="taskModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Task</h4>
			</div>
			<div class="modal-body">
				<form id="modal-task-form" action="/viewData/employee/task">
					<div class="form-group">
						<input class="inputTasktName" type="text" name="title"
							placeholder="Title" /><span class="correct"></span><span
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