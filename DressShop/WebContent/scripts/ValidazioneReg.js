

function controlloNome()
{
	var lettere=/^[a-zA-Z]+$/;
	var nome=document.registrazione.nome.value;
	if(nome.length==0 || !nome.match(lettere))
	{
		document.registrazione.nome.style.borderColor="red";
		return false;
	}
	else{
		document.registrazione.nome.style.borderColor="green";
		return true;
	}
}

function controlloCognome()
{
	var lettere=/^[a-zA-Z]+$/;
	var cognome=document.registrazione.cognome.value;
	if(cognome.length==0 || !cognome.match(lettere))
	{
		document.registrazione.cognome.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.cognome.style.borderColor="green";
		return true;
	}
}



function controlloPassword()
{
	var lettere4=/^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])[0-9A-Za-z]{8,16}$/ //8-16 caratteri(1 cifra,1 lettera mi e ma)
	var password=document.registrazione.password.value;
	if(!password.match(lettere4))
	{
		document.registrazione.password.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.password.style.borderColor="green";
		return true;
	}
}

function controlloEmail()
{
	var lettere5=/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-]{2,})+\.)+([a-zA-Z0-9]{2,})+$/;
	var email=document.registrazione.email.value;
	if(!email.match(lettere5))
	{
		document.registrazione.email.style.borderColor="red";
		return false;
	}
	else
	{
		document.registrazione.email.style.borderColor="green";
		return true;
	}
}





function validazione()
{
	
	if(!controlloNome())
	{
		document.registrazione.nome.focus();
		return false;
	}
	else if(!controlloCognome())
	{
		document.registrazione.cognome.focus();
		return false;
	}
	
	else if(!controlloPassword())
	{
		document.registrazione.password.focus();
		return false;
	}
	else if(!controlloEmail())
	{
		document.registrazione.email.focus();
		return false;
	}
	
	else
	{
		document.registrazione.submit();
	}
}



