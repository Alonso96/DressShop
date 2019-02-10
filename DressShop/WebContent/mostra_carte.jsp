<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MOSTRA CARTE</title>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="java.util.Collection, java.util.Iterator, model.*, java.text.DecimalFormat" %>
<%
if(request.getSession().getAttribute("tipo") != null){
	int tipo = (int) session.getAttribute("tipo");
	if( tipo ==2 || tipo ==3 || tipo == 4)
		response.sendRedirect("index.jsp");
}
%>
<%		CartaDiCreditoModel<CartaDiCreditoBean> cards = new CartaDiCreditoModelDM();                // mi richiamo tutte le carte dell'utente 
		
    	Collection<CartaDiCreditoBean> carte = cards.doRetrieveByUtente((int)session.getAttribute("id"));  //le salvo 
%>    
   

<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;LE TUE CARTE</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>
<%
		if((carte != null) && (carte.size() > 0)) {
		Iterator<?> it = carte.iterator();
		//DecimalFormat formatter = new DecimalFormat("#0.00");
		
		while(it.hasNext()) {
			CartaDiCreditoBean bean = (CartaDiCreditoBean) it.next();
%>
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
	     
	      <td><%=bean.getNome_proprietario() %> </td>
	      <td><%=bean.getCognome_proprietario() %> </td>
	      <td><%=bean.getNumero_carta() %> </td>
	      <td><%=bean.getCvv() %> </td>
	      <td><%=bean.getData_scadenza() %></td>
	      
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>
	 <% 		} 
		} else {
	%>	
		
			<p>Nessuna carta disponibile, </p>
		
<% } %> 

<a href="aggiungiCarta.jsp" class="shiny-button2" name="addcarta2">
 <strong>AGGIUNGI UNA CARTA</strong>
  </a>

</body>
</html>