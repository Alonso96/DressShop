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
<%@ page import="java.util.ArrayList, java.util.*, model.*, java.text.DecimalFormat" %>
<% 
	Carrello cart = (Carrello) session.getAttribute("cart");
	List<ProdottoInCarrello> prodcart = cart.ottieniElem();
	DecimalFormat formatter = new DecimalFormat("#0.00");

	IndirizzoBean indirizzo = (IndirizzoBean) request.getSession().getAttribute("indirizzo");
	CartaDiCreditoBean carta = (CartaDiCreditoBean) request.getSession().getAttribute("carta");
%>	 
<hr>
<h3 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;RIEPILOGO ORDINE</h3>
<hr>
 <div class="bottoni">
<a href="carrello_carta.jsp" class="shiny-button2" id="dx">
 <strong>TORNA INDIETRO</strong>
  </a>

<a href="ConfermaAcquistoControl" class="shiny-button2" id="sx" >
  <strong >CONCLUDI L'ORDINE</strong>
  </a>

</div>

<table class="table">
  <thead class="thead-dark">
	    <tr>
	   
	     <th scope="col">PRODOTTO</th>
	      <th scope="col">MARCA</th>
	      <th scope="col">MODELLO</th>
	      <th scope="col">TAGLIA</th>
	      <th scope="col">QUANTITA'</th>
	      <th scope="col">PREZZO</th>
	      <th></th>
	    </tr>
    
  </thead>
 
  <tbody class="bordo1" id="ye">
  
<%
			for(ProdottoInCarrello beancart : prodcart) {
				System.out.println(prodcart);
		
%>

	  <tr>	 
	      <td scope="row">
	      			<img src="<%= beancart.getFoto() %>" width="10%" style="float:left;">  
	      		
	      	</td>
	      <td><%= beancart.getMarca() %></td>
	      <td><%= beancart.getModello() %></td>
	      <td><%= beancart.getTaglia() %></td>
	      <td><%= beancart.getQuantita() %></td>
	      <td>&euro; <%= formatter.format(beancart.getPrezzo_compl()) %></td>
	    </tr>
	<%
		}
	%>

  </tbody>
    
</table>

 
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	     
	      <th scope="col">Citt&agrave; </th>
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
	 
	      <td><%= indirizzo.getCitta()%></td>
	      <td><%= indirizzo.getVia() %></td>
	      <td><%= indirizzo.getCap() %></td>
	      <td><%= indirizzo.getProvincia() %></td>
	      <td><%= indirizzo.getCellulare() %></td>
	      <td><%= indirizzo.getNome() + " " + indirizzo.getCognome() %></td>
	     
	  
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
	 
	      
	      <td><%= carta.getNumero_carta() %></td>
	      <td><%= carta.getData_scadenza() %></td>
	      <td><%= carta.getCvv() %></td>
	      <td><%= carta.getNome_proprietario() %></td>
	      <td><%= carta.getCognome_proprietario() %></td>
	     
	      
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>








<%@ include file="footer.jsp" %>

</body>
</html>