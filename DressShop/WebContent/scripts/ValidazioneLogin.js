function controlloUsername()
{
    var username=document.login.username.value;
	if(username.length<1 || username==" ")
	{
		document.login.username.style.borderColor="red";
		return false;
	}
	else{
		document.login.username.style.borderColor="green";
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
	if(!controlloUsername())
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