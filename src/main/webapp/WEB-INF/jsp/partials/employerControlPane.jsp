<div style="margin-left:5%">
	<div class="employer">
		<div class="row">
		<p id="employeeNum">
		<script>
		getUsername().done(function(response){
			getEmployeeNum(currentUser).done(function(response){
				$('#employeeNum').text('Number of assigned employees: '+response);
			});
		});
		</script>
		</p>
		</div>
		<div class="row">
		<a class="btn btn-info" id="insertTask">Create task</a>
		</div>
		<div class="row">
		<a class="btn btn-info" id="insertEmployee">Create employee</a>
		</div>
		<div class="row">
		<a class="btn btn-info" id="viewLastUpdate">View most recent update</a>
		</div>
	</div>
</div>

<%@include file="insertTaskModal.jsp" %>
<%@include file="insertEmployeeModal.jsp" %>
