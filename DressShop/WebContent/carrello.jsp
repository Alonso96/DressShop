<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<a href="" class="shiny-button2" id="dx">
 <strong>CONTINUA A COMPRARE</strong>
  </a>

<a href="" class="shiny-button2" id="sx" >
  <strong >PROCEDI CON L'ORDINE</strong>
  </a>

</div>

<table class="table">
  <thead class="thead-dark">
    <tr>
    
      <th scope="col">Prodotto</th>
      <th scope="col">Descrizione</th>
      <th scope="col">Colore</th>
      <th scope="col">Taglia</th>
      <th scope="col">Quantità</th>
      <th scope="col">Prezzo</th>
      <th></th>
    </tr>
    
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
    <tr>
      <th scope="row"><img alt="" src="img/via.jpg" width="200px" ></th>
      <td>scarpe nike </td>
      <td> silver</td>
      <td>42</td>
      <td>1</td>
      <td>20€</td>
      <td><a href="RimuoviCarrello?id_prodotto=">Rimuovi dal carrello</a></td>
  
    </tr>
    
    <tr>
      <th scope="row"><img alt="" src="img/via.jpg" width="200px" ></th>
      <td>scarpe nike </td>
      <td> silver</td>
      <td>42</td>
      <td>1</td>
      <td>20€</td>
      <td><a href="RimuoviCarrello?id_prodotto=">Rimuovi dal carrello</a></td>
  
    </tr>

  </tbody>
    
</table>

<a href="" class="shiny-button2 , sx2" >
  <strong >PROCEDI CON L'ORDINE</strong>
  </a>

<br> <br> <br> <br> <br> <br> 

<%@ include file="footer.jsp" %>
</body>
</html>