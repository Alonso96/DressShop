<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
<title>CARRELLO 3-PAGAMENTO</title>
</head>
<body>

<%@ include file="header.jsp" %>
<%@ page import="java.util.ArrayList, java.util.Iterator, model.CartaDiCreditoBean" %>
<% 
	ArrayList<CartaDiCreditoBean> carte = (ArrayList<CartaDiCreditoBean>) request.getSession().getAttribute("carte");
%>	 

<hr>
<h3 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;SCEGLI UNA CARTA DI CREDITO</h3>
<hr>
 <div class="bottoni">
<a href="carrello_indirizzo.jsp" class="shiny-button2" id="dx">
 <strong>INDIETRO</strong>
  </a>



</div>
<%
		if((carte != null) && (carte.size() > 0)) {
			Iterator<CartaDiCreditoBean> it = carte.iterator();
%>
<%		
			while(it.hasNext()) {
				CartaDiCreditoBean bean = (CartaDiCreditoBean) it.next();
				System.out.println(bean.getNumero_carta());
%>
 <form action="VerificaCarta">
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
	      			<input type="radio" name="carta" value="<%= bean.getNumero_carta()%>"><br>  
	      		
	      	</th>
	      <td><%= bean.getNumero_carta() %></td>
	      <td><%= bean.getData_scadenza() %></td>
	      <td><%= bean.getCvv() %></td>
	      <td><%= bean.getNome_proprietario() %></td>
	      <td><%= bean.getCognome_proprietario() %></td>
	     
<%
			}
%>	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>
<%
			}
%>	  

<div class="bottoni">
<a href="aggiungi_carta.jsp" class="shiny-button2" id="dx">
 <strong>AGGIUNGI UNA CARTA DI CREDITO</strong>
  </a>

<%
	if((carte != null) && (carte.size() > 0)) {
%>
 
   <input id="sx" type="submit" value="PROCEDI CON L'ORDINE">
<%
	}
%>	  
</div>

 </form>

<%@ include file="footer.jsp" %>

</body>
</html>