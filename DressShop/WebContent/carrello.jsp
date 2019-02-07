<%

ProdottoBean product = (ProdottoBean) request.getAttribute("prodotto");

Carrello cart = (Carrello) session.getAttribute("cart"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CARRELLO 1</title>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>

<hr>
<h3 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;CARRELLO</h3>
<hr>
<div class="bottoni">
<a href="index.jsp" class="shiny-button2" id="dx">
 <strong>CONTINUA A COMPRARE</strong>
  </a>

</div>

<form action="">
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	   
	     <th scope="col">PRODOTTO</th>
	      <th scope="col">MARCA</th>
	      <th scope="col">MODELLO</th>
	      <th scope="col">PREZZO</th>
	      <th scope="col">QUANTITA'</th>
	      <th></th>
	    </tr>
	    
	  </thead>
	 
	  <tbody class="bordo1" id="ye">
	  
	  <tr>
	 
	      <td scope="row">
	      			<img src="img/lo.jpg" width="10%" style="float:left;">  
	      		
	      	</td>
	      <td>444444 </td>
	      <td> 00/00</td>
	      <td>111</td>
	      <td>antonio</td>
			<td><a href="">Rimuovi dal carrello</a></td>
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>

 </form>


<%@ include file="footer.jsp" %>
</body>
</html>