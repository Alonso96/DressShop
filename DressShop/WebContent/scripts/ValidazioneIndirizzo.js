

function controlloNome()
{
	var lettere=/^[a-zA-Z]+$/;
	var nome=document.aggiungi_indirizzo.nome.value;
	if(nome.length==0 || !nome.match(lettere))
	{
		document.aggiungi_indirizzo.nome.style.borderColor="red";
		return false;
	}
	else{
		document.aggiungi_indirizzo.nome.style.borderColor="green";
		return true;
	}
}

function controlloCognome()
{
	var lettere=/^[a-zA-Z]+$/;
	var cognome=document.aggiungi_indirizzo.cognome.value;
	if(cognome.length==0 || !cognome.match(lettere))
	{
		document.aggiungi_indirizzo.cognome.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.cognome.style.borderColor="green";
		return true;
	}
}






function controlloCellulare()
{
	var lettere6=/^[0-9]{10}$/;
	var cellulare=document.aggiungi_indirizzo.cellulare.value;
	if(!cellulare.match(lettere6))
	{
		document.aggiungi_indirizzo.cellulare.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.cellulare.style.borderColor="green";
		return true;
	}
}

function controlloCitta()
{
	var lettere=/^[a-zA-Z]+$/;
	var citta=document.aggiungi_indirizzo.citta.value;
	if(!citta.match(lettere))
	{
		document.aggiungi_indirizzo.citta.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.citta.style.borderColor="green";
		return true;
	}
}
function controlloVia()
{
	var lettere=/^[a-zA-Z]+[ ]+[a-zA-Z]+$/;
	var via=document.aggiungi_indirizzo.via.value;
	if(!via.match(lettere))
	{
		document.aggiungi_indirizzo.via.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.via.style.borderColor="green";
		return true;
	}
}
function controlloCap()
{
	var lettere6=/^[0-9]{1,5}$/;
	var cap=document.aggiungi_indirizzo.cap.value;
	if(!cap.match(lettere6))
	{
		document.aggiungi_indirizzo.cap.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.cap.style.borderColor="green";
		return true;
	}
}


function controlloProvincia()
{
	var lettere=/^[a-zA-Z]+$/;
	var provincia=document.aggiungi_indirizzo.provincia.value;
	if(!provincia.match(lettere) || provincia.length>2)
	{
		document.aggiungi_indirizzo.provincia.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.provincia.style.borderColor="green";
		return true;
	}
}



function controlloCap()
{
	var lettere6=/^[0-9]{1,5}$/;
	var cap=document.aggiungi_indirizzo.cap.value;
	if(!cap.match(lettere6))
	{
		document.aggiungi_indirizzo.cap.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungi_indirizzo.cap.style.borderColor="green";
		return true;
	}
}



function validazione()
{
	
	if(!controlloNome())
	{
		document.aggiungi_indirizzo.nome.focus();
		return false;
	}
	else if(!controlloCognome())
	{
		document.aggiungi_indirizzo.cognome.focus();
		return false;
	}
	
	
	else if(!controlloCellulare())
	{
		document.registrazione.telefono.focus();
		return false;aggiungi_indirizzo
	}
	
	else if(!controlloProvincia())
	{
		document.aggiungi_indirizzo.provincia.focus();
		return false;
	}
	else if(!controlloVia())
	{
		document.aggiungi_indirizzo.indirizzo.focus();
		return false;
	}
	
	else if(!controlloCap())
	{
		document.aggiungi_indirizzo.cap.focus();
		return false;
	}
	
	
	else
	{
		document.aggiungi_indirizzo.submit();
	}
}


