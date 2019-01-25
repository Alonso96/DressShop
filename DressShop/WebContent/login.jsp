<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Accedi</title>
<link rel="stylesheet" type="text/css" href="style.css">

<style>
body {
	background-color: white;
	background-image: radial-gradient(white, white,pink); 	
}

label {
	font-family: Verdana, sans-serif;
	font-weight: bold;
	float: left;
}

input {
	margin-top: 8px;
	margin-left: 50px;
}

h2 {
	margin-left: 585px;
	font-family: cursive;
	font-style: italic;
	color: red;
}

div {
	margin-left: 500px;
	border: 1px solid black;
	margin-right: 500px;
	text-align: center;
	padding: 10px;
}
h2{
border:1px solid grey; padding-left:620px; margin-left: 0px
}
.button {
	margin: 15px 0px 0px 0px;
	]
}
p{margin-left: 600px; margin-top: 10px}
@media screen and (max-width: 970px) {
    body {
       width: 100%;
    }
    div{
    clear:both;
    margin-left:0px;
    border:5px;
    border-color:black;
    border-style:solid;
  width:50%;
  margin-right: none;
  text-align: center;
    }
          #divLogo{
	margin-left: 0px;
	 width:100%;
    
}
p{
margin-left:20%;

}
h2{
margin-left:0px;
padding-left:50%;
}
}
@media screen and (max-width: 600px){
#divLogo{
	margin-left: -10%;
	 width:100%;
	
    
}
.immage{
    width: 80%;
    height: auto;
    margin-left: 0px;
    }
    }
</style>
</head>

<body>
	<div id="divLogo" style="border:none">
		<img src="immagini/dressLogo.png" width="700" height="200"
			style="margin-left: 120px" class="immage";>
	</div>

	<hr style="margin-top: 20px">
	<div id="menu" style="border: 0px">
		<ul>
	
			<li><a href="home.jsp" style="color: red">HOME</a></li>
			<li><a href="woman.jsp">WOMAN</a></li>
			<li><a href="contacts.html">CONTACTS</a></li>
	
		
		</ul>
	</div>
	<hr style="margin-top: -20px">
	<h2 >Accedi</h2><br>
	
	<div>
	<form action="LoginControl" method="post">
		<input type="hidden" name="action" value="login">
			
		<label for="userName">Nickname</label><br>
		<input name="userName" type="text" maxlength="20" required placeholder="Insert your Nick"><br>
		
		<label for="password">Password</label><br>
		<input name="password" type="password" required pattern=".{4,}" title="Minimo 4 caratteri" maxlength="20" required placeholder="enter password"><br>
	
		
	
		<input class="button" type="submit" value="Login">
		<input class="button" type="reset" value="Cancel"><br>
	</form>
	</div>
	
	<p >&copy; AlexBacco.com<p>
	
</body>
</html>