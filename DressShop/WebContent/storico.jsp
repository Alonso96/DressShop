<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.* , java.util.*"%>
    
    <%
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	Collection<?> date = (Collection<?>) request.getAttribute("date");
	if(products == null) {
		response.sendRedirect("./StoricoControl");
		return;
	}
	
	
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Storico Acquisti</title>
<link href="style.css" rel="stylesheet" type="text/css">
<style>
body{
background:white;
}
#nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
   background-color: #f1f1f1;
   
}

li a {
    display: block;
    color: pink;
    padding: 6px 12px;
    text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
    background-color: #555;
    color: white;
}
</style>
</head>

<body>
<h2>Storico degli acquisti</h2>
<ul id=nav>


<li><a href="userLogged.jsp" ><img src="immagini/account.png" width="25px" height="25px">Profilo</a></li>
<li><a href="home.jsp">Home</a></li>
</ul>
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
				String data =  (String) it2.next();
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
</body>
</html>