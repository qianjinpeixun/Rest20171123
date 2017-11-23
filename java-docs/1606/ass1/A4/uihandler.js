
function postmessage() {
	
	
    if(form.name.value==""){
		alert("Name is mandatory!");
	}else{
		var reg = /[a-z0-9-.]{1,30}@[a-z0-9-]{1,65}.(com|net|org|info|biz|([a-z]{2,3}.[a-z]{2}))/ ;
		if(reg.test(form.email.value)){
			sendemailforbonus();
			alert("Message submitted!");
		}else{
			alert("Please check the email address!");
		}
	}
}

function resetmessage() {
    form.name.value="";
	form.email.value="";
	form.content.value="";
}

//the gmail address is:  infx1606@gmail.com/ ABcd@1234
