<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.UserBean, model.UserBeanDM"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%=session.getAttribute("name")%></title>
<link rel="stylesheet" type="text/css" href="style.css">

<style>
body{
		background-color: white;
		background-image: radial-gradient(white, white, grey);
}
#nav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 200px;
    background-color: #f1f1f1;
    border: 1px solid #555;
}

#nav li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

#nav li {
    text-align: center;
    border-bottom: 1px solid #555;
}

#nav li:last-child {
    border-bottom: none;
}

#nav li a.active {
    background-color: #4CAF50;
    color: white;
}

#nav li a:hover:not(.active) {
    background-color: #555;
    color: white;
}
</style>
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
			<p class="tagHeader3" style="margin-top: -20px">shopping cart
		</div>
	
	<hr>

	<div id="divLogo">
		<img src="immagini/dressLogo.png" width="900" height="300"
			style="margin-left: 50px">
	</div>
	<hr>
   
    <h3>
        Ciao,
        <%=session.getAttribute("name")%> è un piacere rivederti </h3>
        
        
    		<ul id="nav">	   
			<li><a href="home.jsp" style="color: red">HOME</a></li>
			<li><a href="VisualizzaProdotti.jsp">Inzia a comprare</a></li>
			<li><a href="storico.jsp">Visualizza lo storico acquisti</a></li>
			<li><a href="logout.jsp">Logout</a> </li>
		</ul>
	
        
      
        </body>
</html>