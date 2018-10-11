<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, java.util.*"%>
    <%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	if(products == null) {
		response.sendRedirect("./AdminControl");
		return;
	}
	
	ProductBean product = (ProductBean) request.getAttribute("product");
	
	Carrello cart = (Carrello) request.getAttribute("cart");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pannello Gestione Prodotti</title>

<link href="ProductStyle.css" rel="stylesheet" type="text/css">
<style>
body {
	background-color: white;
	background-image: radial-gradient(white, white,#f7af62); 	
}
</style>
</head>
<body>

	<div id="header">
	<%	
		
	String name = (String)session.getAttribute("name");
	System.out.println(name);
	String flag= (String)session.getAttribute("flag");
	System.out.println(flag);
	
if(name !=null)
{
	
	
}

else {
	response.sendRedirect("home.jsp");	
	out.println("<a class =" +"\"tagHeader\"" + "href= \"" +" login.jsp \"" +"style="+"\"font-family: cursive ; font-weight: bold; color black; text-decoration:none\""+"> Login </a>"
	+ " <p class= \" tagHeader\"> or <a class = \"tagHeader\" href=\"Registration.html \" style = \" font-family: cursive \"> Register </p></a> ");
}
%>
		
		<p class="tagHeader" style="margin-left: 150px">
			lingua corrente : IT
		<div id="header2">
<!-- form -->	
	<div id="divLogo">
		<img src="immagini/dressLogo.png" width="900" height="300">
			<style="margin-left: 50px"></style>
	</div>
	
	
<h2>Prodotti</h2>

<table>
	<tr><th>Immagine</th>
		<th>Id</th>
		<th>Codice</th>
		<th>Descrizione</th>
		<th>Marca</th>
		<th>Prezzo</th>
		<th>Iva</th>
		<th>CodCategoria</th>
		<th>Quantità</th>
		<th>Action</th>
	</tr>
	<%
		if(products.size() > 0) {
			
			Iterator<?> it = products.iterator();
			
			while(it.hasNext()) {
				ProductBean bean = (ProductBean) it.next();
	%>
		<tr>
			<td> <img src="<%=bean.getUrlPercorso() %>" alt="Vestito" height="60" width="50"> </td>
		<% System.out.println(bean.getUrlPercorso()) ;%>
			<td><%= bean.getId() %></td>		
			<td><%= bean.getCodice() %></td>
			<td><%= bean.getDescription() %></td>
			<td><%= bean.getMarca()%></td>
			<td><%= bean.getPrezzoV()%></td>
			<td><%= bean.getIvaV()%></td>
			<td><%= bean.getCodC()%></td>
			<td><%= bean.getQuantity()%></td>
			<td style="width:200px;">
			<a href="ProductControl?action=detail&id=<%=bean.getId()%>">Dettagli</a>	
			<a href="ProductControl?action=delete&id=<%=bean.getId()%>">Cancella</a>
	
			</td>
		</tr>
	<% 		} 
		} else {
	%>	
		<tr>
			<td colspan="4">Nessun prodotto disponibili</td>
		</tr>
	<% } 
	%>
</table>
	
	<%
	   if(product != null) {
	%>
		<h2>Dettagli</h2>
		<table>
			<tr>
				<th>Immagine</th>
				<th>Id</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<tr>
			
			<td><%= product.getId() %></td>		
			<td><%= product.getCodice() %></td>
			<td><%= product.getDescription() %></td>
			<td><%= product.getMarca()%></td>
			<td><%= product.getPrezzoV()%></td>
			<td><%= product.getIvaV()%></td>
			<td><%= product.getCodC()%></td>
			<td><%= product.getQuantity()%></td>
			</tr>
		</table>	
	<% }
	%>

<h2>Inserisci</h2>
<form action="AdminControl" method="GET" name="insert">
	<input type="hidden" name="action" value="insert">
	
	<label for="Codice">Codice:</label><br>
	<input name="Codice" type="text" maxlength="20" required placeholder="inserisci codice"><br>
	
	<label for="description">Descrizione:</label><br>
	<textarea name="description" maxlength="100" rows="3" required placeholder="inserisci descrizione"></textarea><br>
	
	<label for="marca">Marca:</label><br>
	<textarea name="marca" maxlength="100" rows="3" required placeholder="inserisci marca"></textarea><br>
	
	
	<label for="prezzoV">Prezzo:</label><br>
	<input name="prezzoV" type="number" min="0" value="0" required><br>
	
	<label for="ivaV">Iva:</label><br>
	<input name="ivaV" type="number" min="0" value="0" required><br>
	
		<label for="codC">CodiceCategoria:</label><br>
	<textarea name="codC" type="number" min="0" value="0"></textarea><br>
	
	<label for="quantity">Quantity:</label><br>
	<input name="quantity" type="number" min="1" value="1" required><br>	
	
	
	<input type="submit" value="Insert">
	<input type="reset" value="Reset">
	
</form>









	
</body>
</html>