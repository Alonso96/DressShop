<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Registrazione Effetuata</title>
<style>
body{
background-image: radial-gradient(white, white, #f7af62);
}
</style>

</head>
<body>
	<div id="divLogo" style="border:none">
		<img src="immagini/dressLogo.png" width="700" height="200"
			style="margin-left: 90px">
	</div>
	<hr>
	<div id="menu">
		<ul>
			<li><a href="home.jsp" style="color: red">HOME</a></li>
			<li><a href="woman.jsp">WOMAN</a></li>
			<li><a href="">MAN</a></li>
			<li><a href="">BLOG</a></li>
			<li><a href="">CONTACTS</a></li>
		</ul>
	</div>
	<hr>
	Benvenuto <% String h = (String) request.getParameter("firstName");%>
			<% out.println(h); %>
	<p>Ti confermiamo che la registrazione è stata effettuata con successo ,
	controlla la tua email per confermare il tuo nuovo account !
	Torna alla <a href="home.jsp">home</a> per iniziare a comprare.
	

</body>
</html>