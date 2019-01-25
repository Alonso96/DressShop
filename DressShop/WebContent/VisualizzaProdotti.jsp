<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.ProductBean, model.Carrello"%>
    
<%
    	Collection<?> products = (Collection<?>) request.getAttribute("products");
    	if(products == null) {
    		response.sendRedirect("./ProductControl");
    		return;
    	}
    	
    	ProdottoBean product = (ProdottoBean) request.getAttribute("product");
    %>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css">
<title>EStore</title>
<style>
body {
	background-color: white;
	background-image: radial-gradient(white, white,grey); 	
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
		
		if(flag.equals("1"))
			 out.print("<a href=\"amministrazione.jsp\" </a>Ciao" + name + "!");
		else
			
	    out.print("<a href=\" userLogged.jsp\" </a>Ciao" + name + "! </a>");
	}

	else {
		
		out.println("<a class =" +"\"tagHeader\"" + "href= \"" +" login.jsp \"" +"style="+"\"font-family: cursive ; font-weight: bold; color black; text-decoration:none\""+"> Login </a>"
		+ " <p class= \" tagHeader\"> or <a class = \"tagHeader\" href=\"Registration.html \" style = \" font-family: cursive \"> Register  </a>");
	}
	%>
		
		<p class="tagHeader" style="margin-left: 150px">
			lingua corrente : IT
		<div id="header2">
		
		<a  class="tagHeader2" href="Carrello.jsp">
				<img src="immagini/shopping-cart-symbol-for-e-commerce_icon-icons.com_56124.png" alt="vai al modulo"
				width="30" height="30" style="margin-top: 30px">
				<span>Carrello</span>
				
			</a>
	
		</div>
		</div>
<!-- form -->	
	<div id="divLogo">
		<img src="immagini/dressLogo.png" width="900" height="300"
			style="margin-left: 50px">
	</div>
	
<div id="menu">
		<ul>
			<li><a href="home.jsp" >HOME</a></li>
			<li><a href="woman.jsp">WOMAN</a></li>
			<li><a href="contacts.html">CONTACTS</a></li>
			<li><a href="VisualizzaProdotti.jsp" style="color: red">E-Store</a></li>
		</ul>
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
			ProdottoBean bean = (ProdottoBean) it.next();
	%>
		<tr>
			<td> <img src="<%=bean.getUrlPercorso() %>" alt="Smiley face" height="60" width="50" onmouseover="this.width=596;this.height=435;" onmouseout="this.width=50;this.height=60;" ></td>
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
			
			<a href="ProductControl?action=addCart&id=<%=bean.getId()%>">Aggiungi a carrello</a>
			</td>
		</tr>
	<% 		} 
		} else {
	%>	
		<tr>
			<td colspan="4">No product available</td>
		</tr>
	<% } 
	%>
</table>
	
	<%
	   if(product != null) {
	%>
		<h2>Details</h2>
		<table>
			<tr>
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









 
</body> 
</html>