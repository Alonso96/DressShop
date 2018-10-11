<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 


Collection<?> products = (Collection<?>) request.getAttribute("products");
Collection<?> date = (Collection<?>) request.getAttribute("date");
if(products == null) {
	response.sendRedirect("./StoricoControl");
	return;
}


%>    



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Il tuo storico prodotti</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
		<p class="tagHeader" style="margin-left: 150px">
			lingua corrente : IT
		<div id="header2">
<!-- form -->	
		<form id="topForm" action="" method="GET" style="margin-left:-260px; margin-top:10px">
			<input type="text" id="search-in" value="cerca nel sito"> 
			<input name="lente" type="image" src="immagini/lente.png" alt="lente" width="20" height="20" style="margin-top: 0px">
		</form>	
<!-- fine form -->		
			<input class="tagHeader2" name="vai al carrello" type="image"
				src="immagini/shopping-cart-symbol-for-e-commerce_icon-icons.com_56124.png" alt="vai al modulo"
				width="30" height="30" style="margin-top: -30px">
			<p class="tagHeader3" style="margin-top: -20px">shopping cart</p>
		</div>
	
	<hr>

	<div id="divLogo">
		<img src="immagini/dressLogo.png" width="900" height="300"
			style="margin-left: 50px">
	</div>
	<hr>
	<div id="menu">
		<ul>
			<li><a href="home.jsp" style="color: red">HOME</a></li>
			<li><a href="woman.jsp">WOMAN</a></li>
			<li><a href="contacts.html">CONTACTS</a></li>
			<li><a href="VisualizzaProdotti.jsp">E-Store</a></li>
		</ul>
	</div>
	<hr>
	
	<h4>
        <!-- Questo è lo storico -->
        
        <h2>Colored Table Header</h2>


<table>
	<tr><th>Immagine</th>
	    <th>Prodotto</th>
	    <th>Data Acquisto</th>
		
	</tr>
	<%	System.out.println(products.size());
		if(products.size() > 0) {
			
			Iterator<?> it = products.iterator();
			Iterator<?> it2 = date.iterator();
			
			while(it.hasNext()) {
				ProductBean bean = (ProductBean) it.next();
				String data =(String) it2.next();
	%>
		<tr>
			<td><img src="<%=bean.getUrlPercorso() %>" alt="Smiley face" height="60" width="50"> </td>
			<td><%= bean.getDescription() %></td>
			<td><%= data%></td>
		
			<% 		} 
		} else {
	%>	
		<tr>
			<td colspan="4">No product available</td>
		</tr>
	<% } 
	%>
	</table>
        
    </h4> 
    
    <form method="get" action="StoricoControl" name ="StoricoAcquisti" >
		<input type="hidden" name="action" value="StoricoAcquisti">
		<input type="submit" value="Visualizza Qui!">
	</form>
    <script> 
$(document).ready(function(){
    $("immagine prodotto").click(function(){
        $("div").animate({
            left: '250px',
            opacity: '0.5',
            height: '150px',
            width: '150px'
        });
    });
});
</script> 
</body>

</html>