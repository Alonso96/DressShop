function controlloNumero()
{
	var lettere=/^[0-9]{8}$/;
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
	if(anno<2018 || anno>2030)
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

function controlloIntestatario()
{
	var lettere=/^[a-zA-Z]+[ ]+[a-zA-Z]+$/;
	var intestatario=document.aggiungiCarta.intestatario.value;
	if(!intestatario.match(lettere))
	{
		document.aggiungiCarta.intestatario.style.borderColor="red";
		return false;
	}
	else
	{
		document.aggiungiCarta.intestatario.style.borderColor="green";
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
	else if(!controlloIntestatario())
	{
		document.aggiungiCarta.intestatario.focus();
		return false;
	}
	else
	{
		document.aggiungiCarta.submit();
	}
}