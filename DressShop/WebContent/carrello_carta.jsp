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
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;SCEGLI UNA CARTA DI CREDITO</h4>
<hr>
 <div class="bottoni">
<a href="" class="shiny-button2" id="dx">
 <strong>INDIETRO</strong>
  </a>

<a href="" class="shiny-button2" id="sx" >
  <strong >CONFERMA PAGAMENTO</strong>
  </a>

</div>
 <form action="controller/VerificaCarta">
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	    <th></th>
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
	 
	      <th scope="row">
	      			<input type="radio" name="gender" value="male"><br>  
	      		
	      	</th>
	      <td>444444444444444444 </td>
	      <td> 00/00</td>
	      <td>111</td>
	      <td>antonio</td>
	      <td>de luca</td>
	     
	      
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>

 </form>

<div class="bottoni">
<a href="" class="shiny-button2" id="dx">
 <strong>AGGIUNGI UNA CARTA DI CREDITO</strong>
  </a>

 
  <input id="sx" type="submit" value="CONCLUDI ORDINE">
</div>




<%@ include file="footer.jsp" %>

</body>
</html>