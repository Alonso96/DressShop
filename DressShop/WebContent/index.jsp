<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/css/bootstrap.min.css" rel="stylesheet" >

<title>HOME</title>
</head>

<body>
<%@ include file="header.jsp" %>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active" style="">
      <img id="sasa" class="d-block w-100" src="img/12.jpg" alt="First slide" >
      <div class="carousel-caption d-none d-md-block">
   <a class="bordo1 box bounceIn" href="CategoriaControl?shirt.donna"> <h2>GUARDA ORA</h2> </a>
    <p class="bordo" >Gli ultimi modelli shirt donna: ora disponibili!</p>
  </div>
    </div>
    <div class="carousel-item">
      <img id="sasa" class="d-block w-100" src="img/lo.jpg" alt="Second slide">
      <div class="carousel-caption d-none d-md-block">
    <a class="bordo box bounceIn"  href="CategoriaControl?shirt.uomo"> <h2>GUARDA ORA</h2> </a>
    <p class="bordo" >Disponibile la nuova collezione di felpe</p>
  </div>
    </div>
    <div class="carousel-item">
      <img id="sasa" class="d-block w-100" src="img/lolo.jpg" alt="Third slide">
      <div class="carousel-caption d-none d-md-block">
    <a class="bordo1" href="CategoriaControl?borse.accessori"> <h2>GUARDA ORA</h2> </a>
    <p class="bordo">-10% su tutte le borse</p>
  </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>




 <%@ include file="footer.jsp" %>
</body>
</html>