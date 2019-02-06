<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RIEPILOGO ORDINE</title>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>
<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;RIEPILOGO ORDINE</h4>
<hr>
 <div class="bottoni">
<a href="carrello_carta.jsp" class="shiny-button2" id="dx">
 <strong>TORNA INDIETRO</strong>
  </a>

<a href="acquisto_completato.jsp" class="shiny-button2" id="sx" >
  <strong >CONCLUDI L'ORDINE</strong>
  </a>

</div>

<table class="table">
  <thead class="thead-dark">
    <tr>
    
      <th scope="col">Prodotto</th>
      <th scope="col">Descrizione</th>
      <th scope="col">Colore</th>
      <th scope="col">Taglia</th>
      <th scope="col">Quantità</th>
      <th scope="col">Prezzo</th>
      <th></th>
    </tr>
    
  </thead>
 
  <tbody class="bordo1" id="ye">
  
  <tr>
      <th scope="row"><img alt="" src="img/via.jpg" width="200px" ></th>
      <td>scarpe nike </td>
      <td> silver</td>
      <td>42</td>
      <td>1</td>
      <td>20€</td>
      
  
    </tr>

  </tbody>
    
</table>

 
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	     
	      <th scope="col">Città</th>
	      <th scope="col">Via</th>
	      <th scope="col">Cap</th>
	      <th scope="col">Provincia</th>
	      <th scope="col">Numero Di Cellulare</th>
	      <th scope="col">Nome Destinatario</th>
	      <th></th>
	    </tr>
	    
	  </thead>
	 
	  <tbody class="bordo1" id="ye">
	  
	  <tr>
	 
	      <th>Napoli </th>
	      <td> via roma</td>
	      <td>80033</td>
	      <td>NA</td>
	      <td>3333333333</td>
	      <td>antonio de luca</td>
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>


	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	    
	     <th scope="col">Numero Carta</th>
	      <th scope="col">Data Scandenza</th>
	      <th scope="col">CVV</th>
	      <th scope="col">Nome Proprietario</th>
	      <th scope="col">Cognome Proprietario</th>
	      
	      <th></th>
	    </tr>
	    
	  </thead>
	 
	  <tbody class="bordo1" id="ye">
	  
	  <tr>
	 
	      
	      <th>444444444444444444 </th>
	      <td> 00/00</td>
	      <td>111</td>
	      <td>antonio</td>
	      <td>de luca</td>
	     
	      
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>








<%@ include file="footer.jsp" %>

</body>
</html>