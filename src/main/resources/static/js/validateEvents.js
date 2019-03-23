//-------------------Validate passwords ----------------------------------------------
			var pwd1 = '';
			var pwd2 = '';
			$(document).on('change','input[type=password].inputPassword.password1', function(){
				pwd1=$(this).val();
			});
			$(document).on('change','input[type=password].inputPassword.password2', function(){
      	  		pwd2=$(this).val();
			});
			$(document).on('change','input[type=password].inputPassword', function(){
			      	  	$('input.inputPassword.password1').next('span.correct').next('span.incorrect').html('');
		      	  	if(pwd1=='' || pwd2==''){
		      	  		$('input.inputPassword.password1').next('span.correct').next('span.incorrect').html('Please fill both fields');
		      	  	}
		      	  	else if(matchesPwd(pwd1,pwd2)==false){
		      			$('input.inputPassword.password1').next('span.correct').next('span.incorrect').html('Passwords do not match');
	      			}
		      		else{
		      			$('input.inputPassword.password1').next('span.correct').next('span.incorrect').html('');
		      		}
		      		
			});

// -------------------Validate user name----------------------------------------------
		$(document).on('change','input[type=text].inputUsername', function(){
		      	  var input=$(this);
		      		input.next('span.correct').next('span.incorrect').html('Username taken');
		      		input.next('span.correct').html('');
		      		if(input.val()!='')
		      		takenUsername(input.val()).done(function(response){
	      				input.next('span.correct').next('span.incorrect').html('');
			      		input.next('span.correct').html('Username available');	
		      		});
		      		else{
	      				input.next('span.correct').next('span.incorrect').html('');
	      				input.next('span.correct').html('');
	      			}		      		
		});
		
// -------------------Validate
// department----------------------------------------------
			$(document).on('change','input[type=text].inputDepartmentName', function(){
			      	  var input=$(this);
			      		input.next('span.correct').next('span.incorrect').html('Department taken');
			      		input.next('span.correct').html('');
			      		if(input.val()!='')
			      		takenDepartment(input.val()).done(function(response){
		      				input.next('span.correct').next('span.incorrect').html('');
				      		input.next('span.correct').html('Department avaiable');	
			      		});
			      		else{
		      				input.next('span.correct').next('span.incorrect').html('');
		      				input.next('span.correct').html('');
		      			}     		
			});
// ---------------------Validate name event---------------------------------
		$(document).on('change','input[type=text].inputFirstName, input[type=text].inputLastName, input[type=text].inputJob', function(){
	      	  var input=$(this);
	      		input.next('span.correct').next('span.incorrect').html('');
    			input.next('span.correct').html('');
	      	  if(validateName(input.val()))
	      		{
	      		    input.next('span.correct').html('Name is valid');
	      			input.next('span.correct').next('span.incorrect').html('');
	      			if(input.val()==''){
	      				input.next('span.correct').html('');
	      			}
	      		}
	      	  if(validateName(input.val())==false)
	      		{
	      			input.next('span.correct').html('');
	      			input.next('span.correct').next('span.incorrect').html('Name is not valid');
	      			if(input.val()==''){
	      				input.next('span.correct').next('span.incorrect').html('');
	      			}
	      		}
	    });
// ---------------------Validate date event---------------------------------
				$(document).on('change','input[type=text].inputBirthDate, input[type=text].inputHireDate', function(){
			      	  var input=$(this);
			      		input.next('span.correct').next('span.incorrect').html('');
		  			input.next('span.correct').html('');
			      	  if(validateDate(input.val()))
			      		{
			      		    input.next('span.correct').html('Date format is valid');
			      			input.next('span.correct').next('span.incorrect').html('');
			      			if(input.val()==''){
			      				input.next('span.correct').html('');
			      			}
			      		}
			      	  if(validateDate(input.val())==false)
			      		{
			      			input.next('span.correct').html('');
			      			input.next('span.correct').next('span.incorrect').html('Date format is not valid');
			      			if(input.val()==''){
			      				input.next('span.correct').next('span.incorrect').html('');
			      			}
			      		}
			    });
// ---------------------Validate Phone event---------------------------------
				$(document).on('change','input[type=text].inputPhone, input[type=text].commission, input[type=text].bonus, input[type=text].salary, input[type=text].educationYears', function(){
			      	  var input=$(this);
			      		input.next('span.correct').next('span.incorrect').html('');
		  				input.next('span.correct').html('');
			      	  if(validatePhone(input.val()))
			      		{
			      		    input.next('span.correct').html('Field is valid');
			      			input.next('span.correct').next('span.incorrect').html('');
			      			if(input.val()==''){
			      				input.next('span.correct').html('');
			      			}
			      		}
			      	  if(validatePhone(input.val())==false)
			      		{
			      			input.next('span.correct').html('');
			      			input.next('span.correct').next('span.incorrect').html('Field is not valid');
			      			if(input.val()==''){
			      				input.next('span.correct').next('span.incorrect').html('');
			      			}
			      		}
			    });
// ---------------------Validate Email event---------------------------------
				$(document).on('change','input[type=text].inputEmail', function(){
			      	  var input=$(this);
			      		input.next('span.correct').next('span.incorrect').html('');
			      		input.next('span.correct').html('');		  				
			      	  if(validateEmail(input.val()))
			      		{
			      		input.next('span.correct').next('span.incorrect').html('Email is taken');
			      		input.next('span.correct').html('');
				      		takenEmail(input.val()).done(function(response){
				      				input.next('span.correct').next('span.incorrect').html('');
						      		input.next('span.correct').html('Email is available');	
				      		});
			      		}
			      	  if(validateEmail(input.val())==false)
			      		{
			      			input.next('span.correct').html('');
			      			input.next('span.correct').next('span.incorrect').html('E-mail address is not valid');
			      			if(input.val()==''){
			      				input.next('span.correct').next('span.incorrect').html('');
			      				input.next('span.correct').html('');
			      			}
			      		}
			    });
// ---------------------Validate Initial event---------------------------------
				$(document).on('change','input[type=text].inputMiddleInitial', function(){
			      	  var input=$(this);
			      		input.next('span.correct').next('span.incorrect').html('');
		    			input.next('span.correct').html('');
			      	  if(validateInitial(input.val()))
			      		{
			      		    input.next('span.correct').html('Initial is valid');
			      			input.next('span.correct').next('span.incorrect').html('');
			      			if(input.val()==''){
			      				input.next('span.correct').html('');
			      			}
			      		}
			      	  if(validateInitial(input.val())==false)
			      		{
			      			input.next('span.correct').html('');
			      			input.next('span.correct').next('span.incorrect').html('Initial is not valid');
			      			if(input.val()==''){
			      				input.next('span.correct').next('span.incorrect').html('');
			      			}
			      		}
			    });
								