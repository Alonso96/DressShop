function controlloNumero()
{
	var lettere=/^[0-9]{16}$/;
	var numero_carta=document.aggiungiCarta.numero_carta.value;
	if(!numero_carta.match(lettere))
	{
		document.aggiungiCarta.numero_carta.style.borderColor="red";
		return false;
	}
	else{
		document.aggiungiCarta.numero_carta.style.borderColor="green";
		return true;
	}
}

function controlloAnno()
{
	var anno=document.aggiungiCarta.anno.value;
	if(anno<2019 || anno>2030)
	{
		document.aggiungiCarta.anno.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiCarta.anno.style.borderColor="green";
		return true;
	}
}

function controlloMese()
{
	var mese=document.aggiungiCarta.mese.value;
	if(mese<1 || mese>12)
	{
		document.aggiungiCarta.mese.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiCarta.mese.style.borderColor="green";
		return true;
	}
}

function controlloGiorno()
{
	var giorno=document.aggiungiCarta.giorno.value;
	if(giorno<1 || giorno>31)
	{
		document.aggiungiCarta.giorno.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiCarta.giorno.style.borderColor="green";
		return true;
	}
}

function controlloNome()
{
	var lettere=/^[a-zA-Z]+$/;
	var nome=document.aggiungiCarta.nome.value;
	if(!nome.match(lettere))
	{
		document.aggiungiCarta.nome.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiCarta.nome.style.borderColor="green";
		return true;
	}
}

function controlloCognome()
{
	var lettere=/^[a-zA-Z]+$/;
	var cognome=document.aggiungiCarta.cognome.value;
	if(!cognome.match(lettere))
	{
		document.aggiungiCarta.cognome.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiCarta.cognome.style.borderColor="green";
		return true;
	}
}

function controlloCvv()
{
	var lettere=/^[0-9]{3}$/;
	var cvv=document.aggiungiCarta.cvv.value;
	if(!cvv.match(lettere))
	{
		document.aggiungiCarta.cvv.style.borderColor="red";
		return false;
	}
	else{
		document.aggiungiCarta.cvv.style.borderColor="green";
		return true;
	}
}


function validazione()
{
	if(!controlloNumero())
	{
		document.aggiungiCarta.numero_carta.focus();
		return false;
	}
	else if(!controlloAnno())
	{
		document.aggiungiCarta.anno.focus();
		return false;
	}
	else if(!controlloMese())
	{
		document.aggiungiCarta.mese.focus();
		return false;
	}
	else if(!controlloGiorno())
	{
		document.aggiungiCarta.giorno.focus();
		return false;
	}
	else if(!controlloNome())
	{
		document.aggiungiCarta.nome.focus();
		return false;
	}
	else if(!controlloCvv())
	{
		document.aggiungiCarta.cvv.focus();
		return false;
	}
	else if(!controlloCognome())
	{
		document.aggiungiCarta.cognome.focus();
		return false;
	}
	else
	{
		document.aggiungiCarta.submit();
	}
}