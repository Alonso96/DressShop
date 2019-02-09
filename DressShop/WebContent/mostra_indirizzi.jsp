<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MOSTRA INDIRIZZI</title>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="java.util.Collection, java.util.Iterator, model.*, java.text.DecimalFormat" %>
<%		IndirizzoModel<IndirizzoBean> indirizzi = new IndirizzoModelDM();                // mi richiamo tutti gli indirizzi  dell'utente 
		
    	Collection<IndirizzoBean> ind = indirizzi.doRetrieveByUtente((int)session.getAttribute("id"));  //le salvo 
%>    
   

<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;INDIRIZZI</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>

<%
		if((ind != null) && (ind.size() > 0)) {
		Iterator<?> it = ind.iterator();
		//DecimalFormat formatter = new DecimalFormat("#0.00");
		
		while(it.hasNext()) {
			IndirizzoBean bean = (IndirizzoBean) it.next();
%>
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
	 
	     
	      <td><%=bean.getCitta() %></td>
	      <td><%=bean.getVia() %></td>
	      <td><%=bean.getCap() %></td>
	      <td><%=bean.getProvincia() %></td>
	      <td><%=bean.getCellulare() %></td>
	      <td><%=bean.getNome() + " "+ bean.getCognome() %></td>
	     
	  
	    </tr>
	    
	  
	  </tbody>
	      	
	</table>
	
	 <% 		} 
		} else {
	%>	
		
			<p>Nessun indirizzo disponibile</p>
		
<% } %> 

<a href="aggiungi_indirizzo.jsp" class="shiny-button2">
 <strong>AGGIUNGI UN INDIRIZZO</strong>
  </a>

</body>
</html>