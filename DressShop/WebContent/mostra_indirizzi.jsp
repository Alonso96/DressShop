<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>


<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;INDIRIZZI</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>

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
	 
	     
	      <td>Napoli </td>
	      <td> via roma</td>
	      <td>80033</td>
	      <td>NA</td>
	      <td>3333333333</td>
	      <td>antonio de luca</td>
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>

<a href="aggiungi_indirizzo" class="shiny-button2">
 <strong>AGGIUNGI UN INDIRIZZO</strong>
  </a>

</body>
</html>