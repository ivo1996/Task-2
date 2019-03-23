
<!-- Modal -->
<div class="modal fade" id="updateModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button id="modal-dismiss" type="button" class="close"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Create Update</h4>
			</div>
			<div class="modal-body">
				<form id="modal-update-form" action="/viewData/update/">
					<div>
						<label for="id_Tasks"> Choose Task </label>
						<select id="id_Tasks" name="task" form="modal-employee-form">
						</select>
					</div>
					<div class="form-group">
						<input class="inputMessage" type="text" name="message" id="createUpdateMessage"
							placeholder="message" /><span class="correct"></span><span
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