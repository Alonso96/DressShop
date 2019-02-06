<%

ProdottoBean product = (ProdottoBean) request.getAttribute("prodotto");

Carrello cart = (Carrello) session.getAttribute("cart"); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*"%>
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
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;SHOPPING BAG</h4>
<hr>
 <div class="bottoni">
<a href="index.jsp" class="shiny-button2" id="dx">
 <strong>CONTINUA A COMPRARE</strong>
  </a>



</div>

<table class="table">
<%
		
		List<ProdottoBean> prodcart = cart.ottieniElem();
		if(prodcart.size()==0){
			response.sendRedirect("index.jsp");
		}else{
		for(ProdottoBean beancart: prodcart) {
			System.out.println(prodcart);
		
	%>
  <thead class="thead-dark">
    <tr>
			<td><%=beancart.getCodice_prodotto() %></td>
			<td><a href="CartControl?action=rimuoviP&id=<%=beancart.getId_prodotto()%>">Cancella da carrello</a>
			

		</tr>
					
	<%
		}
		}
	%>
 
	
  </thead>
 
  <tbody class="bordo1" id="ye">
 <%-- 
  <% ArrayList<ProdottoInOrdineBean> prodotti_acquistati=(ArrayList<ProdottoInOrdineBean>)session.getAttribute("Carrello");
   if(prodotti_acquistati!=null)
   {
   for(ProdottoInOrdineBean c : prodotti_acquistati)
   {
%>
		--%>



	
</table>
<form method="get" action="ProcediAcquisto" name ="ProcediAcquisto" >
<input type="hidden" name="action" value="ProcediAcquisto">
<input type="submit" value="Acquista!">


</form>

<%@ include file="footer.jsp" %>
</body>
</html>