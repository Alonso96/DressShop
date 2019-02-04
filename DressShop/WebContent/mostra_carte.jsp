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
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;LE TUE CARTE</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>
<table class="table">
	  <thead class="thead-dark">
	    <tr>
	  
	      <th scope="col">NOME</th>
	      <th scope="col">COGNOME</th>
	      <th scope="col">NUMERO CARTA</th>
	      <th scope="col">CVV</th>
	      <th scope="col">DATA DI SCADENZA</th>
	      
	      <th></th>
	    </tr>
	    
	  </thead>
	 
	  <tbody class="bordo1" id="ye">
	  
	<tr> 
	     
	      <td>Antonio </td>
	      <td> DE LUCA</td>
	      <td>00000000000000</td>
	      <td>123</td>
	      <td>01/21</td>
	      
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>

<a href="aggiungi_carta.jsp" class="shiny-button2">
 <strong>AGGIUNGI UNA CARTA</strong>
  </a>

</body>
</html>