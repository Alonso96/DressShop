<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>

<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;SCEGLI UN INDIRIZZO</h4>
<hr>
 <div class="bottoni">
<a href="carrello.jsp" class="shiny-button2" id="dx">
 <strong>TORNA AL CARRELLO</strong>
  </a>



</div>
 <form action="VerificaIndirizzo">
 
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	     <th scope="col">Seleziona</th>
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
	 
	      <th scope="row">
	      			<input type="radio" name="indirizzo" value="y"> Male<br>  
	      		
	      	</th>
	      <td>Napoli </td>
	      <td> via roma</td>
	      <td>80033</td>
	      <td>NA</td>
	      <td>3333333333</td>
	      <td>antonio de luca</td>
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>

 </form>

<div class="bottoni">
<a href="aggiungi_indirizzo.jsp" class="shiny-button2" id="dx">
 <strong>AGGIUNGI UN INDIRIZZO</strong>
  </a>

 
  <input id="sx" type="submit" value="PROCEDI CON L'ORDINE">
</div>




<%@ include file="footer.jsp" %>
</body>
</html>