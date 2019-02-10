function controlloEmail()
{
	var lettere5=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
	var email=document.login.email.value;
	if(!email.match(lettere5))
	{
		document.login.email.style.borderColor="red";
		return false;
	}
	else
	{
		document.login.email.style.borderColor="green";
		return true;
	}
}
function controlloPassword()
{
    var password=document.login.password.value;
	if(password.length<1)
	{
		document.login.password.style.borderColor="red";
		return false;
	}
	else{
		document.login.password.style.borderColor="green";
		return true;
	}
}

function validazione()
{
	if(!controlloEmail())
	{
		document.login.username.focus();
		return false;
	}
	else if(!controlloPassword())
	{
		document.login.password.focus();
		return false;
	}
	else
	{
		document.login.submit();
	}
}