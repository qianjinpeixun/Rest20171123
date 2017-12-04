document.oncontextmenu=function(e){
	alert("right click has been disabled");
	return false;
}

function postmessage() {
	
	
    if(form.name.value==""){
		alert("Name is mandatory!");
	}else if(form.phone.value==""){
		alert("Phone number is mandatory!");
	}else if(form.email.value==""){
		alert("Email adddress is mandatory!");
	}else{
		var reg = /[a-z0-9-.]{1,30}@[a-z0-9-]{1,65}.(com|net|org|info|biz|([a-z]{2,3}.[a-z]{2}))/ ;
		if(reg.test(form.email.value)){
			var reg1=  /[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]/;
			if(reg1.test(form.phone.value)){
				alert("Message submitted!");
				
			}else
				alert("Please check the phone number!");
		}else{
			alert("Please check the email address!");
		}
	}
}

function resetmessage() {
    form.name.value="";
	form.email.value="";
	form.content.value="";
	form.phone.value="";
}
