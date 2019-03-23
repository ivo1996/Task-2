function getFormData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {};

		$.map(unindexed_array, function(n, i) {
			indexed_array[n['name']] = n['value'];
		});
		return indexed_array;
		} 

			$('#user-form').on('submit', function(e) {
				e.preventDefault();
						if(validateName($('input[type=text].inputFirstName').val())
								&&validateName($('input[type=text].inputLastName').val())
								&&validateDate($('input[type=text].inputBirthDate').val())
								&&validatePhone($('input[type=text].inputPhone').val())
								&&validateEmail($('input[type=text].inputEmail').val())
								&&takenUsername($('input[type=text].inputUsername').val()).statusText=="success"
								&&takenEmail($('input[type=text].inputEmail').val()).statusText=="success"
								&&matchesPwd($('input.inputPassword.password1').val(),$('input.inputPassword.password2').val())){
									$form = $(this);
									let data = JSON.stringify(getFormData($form));
									let URL = "/viewData";					
										$.ajax({
											type : 'POST',
											url : URL,
											data : data,
											contentType : 'application/json',
											success : function(response) {
												$('#insertData').click();	
											},
											error : function(statusText) {
												$('.container-fluid').html(statusText);
											}
										});
						}
					});