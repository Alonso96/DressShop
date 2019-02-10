<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
<title>CARRELLO 2-INDIRIZZO</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import="java.util.ArrayList, java.util.Iterator,model.indirizzo.IndirizzoBean" %>
<%
if(request.getSession().getAttribute("tipo") != null){
	int tipo = (int) session.getAttribute("tipo");
	if( tipo ==2 || tipo ==3 || tipo == 4)
		response.sendRedirect("index.jsp");
}
%>
<% 
	ArrayList<IndirizzoBean> indirizzi = (ArrayList<IndirizzoBean>) request.getSession().getAttribute("indirizzi");
%>	 

<hr>
<h3 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;SCEGLI UN INDIRIZZO</h3>
<hr>
 <div class="bottoni">
<a href="carrello.jsp" class="shiny-button2" id="dx">
 <strong>TORNA AL CARRELLO</strong>
  </a>



</div>
<%
		if((indirizzi != null) && (indirizzi.size() > 0)) {
			Iterator<IndirizzoBean> it = indirizzi.iterator();
%>
 <form action="VerificaIndirizzo" method="form">
 <%		
			while(it.hasNext()) {
				IndirizzoBean bean = (IndirizzoBean) it.next();
				System.out.println(bean.getId_indirizzo());
%>
	 <table class="table">
	  <thead class="thead-dark">
	    <tr>
	     <th scope="col">Seleziona</th>
	      <th scope="col">Citt&agrave;</th>
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
	      			<input type="radio" name="indirizzo" value= "<%= bean.getId_indirizzo()%>"><br>  
	      		
	      </th>
	      <td><%= bean.getCitta()%></td>
	      <td><%= bean.getVia() %></td>
	      <td><%= bean.getCap() %></td>
	      <td><%= bean.getProvincia() %></td>
	      <td><%= bean.getCellulare() %></td>
	      <td><%= bean.getNome() + " " + bean.getCognome() %></td>
	     
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
<a href="aggiungi_indirizzo.jsp" class="shiny-button2" id="dx">
 <strong>AGGIUNGI UN INDIRIZZO</strong>
  </a>
<%
	if((indirizzi != null) && (indirizzi.size() > 0)) {
%>
  <input id="sx" type="submit" value="PROCEDI CON L'ORDINE" >
<%
	}
%>	  
</div>
 </form>
<%@ include file="footer.jsp" %>
</body>
</html>