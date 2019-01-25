<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Woman</title>
<link rel="stylesheet" type="text/css" href="style.css">
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
		
    out.print("<a href=\" userLogged.jsp\" </a>Ciao" + name + "!");
}

else {
	
	out.println("<a class =" +"\"tagHeader\"" + "href= \"" +" login.jsp \"" +"style="+"\"font-family: cursive ; font-weight: bold; color black; text-decoration:none\""+"> Login </a>"
	+ " <p class= \" tagHeader\"> or <a class = \"tagHeader\" href=\"Registration.html \" style = \" font-family: cursive \"> Register </p></a> ");
}
%>
		
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
	</div>	
	<hr>

	<div id="divLogo">
		<img src="immagini/dressLogo.png" width="900" height="300"
			style="margin-left: 50px">
	</div>

	
	<hr>

	<div id="menu">
		<ul>
			<li><a href="home.jsp">HOME</a></li>
			<li><a href="woman.jsp"  style="color: red">WOMAN</a></li>
		
			<li><a href="contacts.html">CONTACTS</a></li>
			<li><a href="VisualizzaProdotti.jsp">E-Shop</a></li>
			
		</ul>
	</div>
	<hr>
	
	
	<div id="prodotti">

	<img src="vestiti_donna/imgd15.jpg" width="300" height="400">
	<img src="vestiti_donna/imgd16.jpg" width="300" height="400">
	<img src="vestiti_donna/imgd8.jpg" width="300" height="400">
		</div>
<div id="prodotti2">
	<img src="vestiti_donna/imgd9.jpeg" width="300" height="400">
	<img src="vestiti_donna/imgd11.jpg" width="300" height="400">
	<img src="vestiti_donna/imgd12.jpg" width="300" height="400">

</div>
	<ul style="margin-left: 400px">
		<li><a href=""><input type="image" src="immagini/iconaFB.png"
				alt="Facebook" width="30" height="30"></a></li>
		<li><a href=""><input type="image"
				src="immagini/iconaTwitter.png" alt="Twitter" width="30" height="30"></a></li>
		<li><a href=""><input type="image"
				src="immagini/iconaYoutube.png" alt="Youtube" width="30" height="30"></a></li>
		<li><a href=""><input type="image"
				src="immagini/iconaInstagram.png" alt="Instagram" width="30"
				height="30"></a></li>
		<li><a href=""><input type="image"
				src="immagini/iconaWhatsapp.png" alt="Whastapp" width="30"
				height="30"></a></li>
		<li><a href=""><input type="image" src="immagini/iconaIn.png"
				alt="Linkedin" width="30" height="30"></a></li>
	</ul>
	<hr>
	
	<div id="footer">
		<p class="tagFooter" style="margin-left: 150px"><b>Data odierna :</b> <%= new java.util.Date() %>
		<p class="tagFooter" style="margin-left: 550px; margin-top: -37px"><b>Creato da : </b>FonzoTeam
		<p class="tagFooter" style="margin-left: 850px; margin-top: -37px"><b>Manda e-mail : </b><a href="">AlfAlexLuca@mail.com </a>
	</div>
	<hr>
	<p style="margin-left: 580px">&copy; FonzoAlexLuca.com<p>
<div align="center">
  DressShop: corso Umberto I, 150| Battipaglia (sa)| tel: +39 089 342041|info@dresshop.it| P.I.: 04665140655
  </div>
</body>
</html>