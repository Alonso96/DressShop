<%
Carrello cart = (Carrello) session.getAttribute("cart"); //a%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*, java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CARRELLO 1</title>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>
<%
if(request.getSession().getAttribute("tipo") != null){
	int tipo = (int) session.getAttribute("tipo");
	if( tipo ==2 || tipo ==3 || tipo == 4)
		response.sendRedirect("index.jsp");
}
%>
<hr>
<h3 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;CARRELLO</h3>
<hr>
<div class="bottoni">
<a href="index.jsp" class="shiny-button2" id="dx">
 <strong>CONTINUA A COMPRARE</strong>
  </a>

</div>
<%
		if((cart != null) && (!cart.isEmpty())){
			List<ProdottoInCarrello> prodcart = cart.ottieniElem();
			DecimalFormat formatter = new DecimalFormat("#0.00");
%>
<form action="">
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
			<td><a href="CartControl?invia=rimuovi&id=<%=beancart.getId_prodotto()%>">Rimuovi dal carrello</a></td>
	    </tr>
	<%
		}
	%>
	    
	  
	  </tbody>
	      	
	</table>

 </form>

<form method="get" action="ProcediAcquisto" name ="ProcediAcquisto" >
<input type="hidden" name="action" value="ProcediAcquisto">
<input type="submit" value="Acquista!" >

</form>

	<%
		} else {
			%>	
			
			<h4>Non hai articoli nel carrello</h4>
		
<% } %> 

<%@ include file="footer.jsp" %>
</body>
</html>