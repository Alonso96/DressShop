<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dress Shop</title>
<link rel="stylesheet" type="text/css" href="style.css">
<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
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
		
    out.print("<a href=\" userLogged.jsp\"> <img src=\"immagini/account.png\" width=\"25px\" height=\"25px\" </a> Ciao" + name + "!");
}

else {
	
	out.println("<a class =" +"\"tagHeader\"" + "href= \"" +" login.jsp \"" +"style="+"\"font-family: cursive ; font-weight: bold; color black; text-decoration:none\""+"> Login </a>"
	+ " <p class= \" tagHeader\"> or <a class = \"tagHeader\" href=\"Registration.html \" style = \" font-family: cursive \"> Register </p></a>");
}
%>
		
		<p class="tagHeader" style="margin-left: 150px">
			lingua corrente : IT
	
<!-- form -->	
		
<!-- fine form -->		
			<a  class="tagHeader2" href="Carrello.jsp">
				<img src="immagini/shopping-cart-symbol-for-e-commerce_icon-icons.com_56124.png" alt="vai al modulo"
				width="30" height="30">
				
			</a>
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
			<li><a href="" style="color: red">HOME</a></li>
			<li><a href="woman.jsp">WOMAN</a></li>
			<li><a href="contacts.html">CONTACTS</a></li>
			<li><a href="VisualizzaProdotti.jsp">E-Store</a></li>
		</ul>
	</div>
	<hr>
	
	<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="vestiti_donna/slide2.jpg" style="width:100%">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="vestiti_donna/slide3.jpg" style="width:100%">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="immagini/ragazzaSfondo2.jpg" style="width:100%">
  <div class="text"></div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
       slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";
    setTimeout(showSlides, 4000); // Change image every 4 seconds
}
</script>
		

	<h2 style="text-align: center">Prodotti In Evidenza</h2>
	<hr>

	<div class="bottomImage">
		<h3 style="margin-left: 200px">50% Sconto</h3>
		<a href=""><img src="vestiti_donna/imgd8.jpg" width="350"
			height="500" style="margin-left: 90px"></a>
	</div>

	<div class="bottomImage">
		<h3 style="margin-left: 600px; margin-top: -544px">Spedizioni in tutta italia</h3>
		<a href="woman.jsp"><img src="vestiti_donna/imgd13.jpg" width="350"
			height="500" style="margin-left: 500px"></a>
	</div>

	<div class="bottomImage">
		<h3 style="margin-left: 1000px; margin-top: -544px">Scopri la nuova collezione</h3>
		<a href="woman.jsp"><img src="vestiti_donna/imgd14.jpg" width="350"
			height="500" style="margin-left: 900px"></a>
	</div>

	<hr>
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
<!--  	<script type="text/javascript">
	
		setTimeout(activeAlert,3000);
		
		function activeAlert(){
		alert("this website uses cookies to track an user session , to make persistance...");
		}
	</script>
-->
</body>


</html>