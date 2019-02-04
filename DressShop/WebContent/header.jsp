<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>HEADER-DRESS-SHOP</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <link rel="stylesheet" href="css/stile.css">
   
</head>
<body>
<nav class="navbar navbar-inverse">

  <div class="container-fluid">
  
    <ul class="nav navbar-nav sinistra">
     
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><font color= midnightblue>UOMO</font> <span class="caret"></span></a>
        <ul class="dropdown-menu"> 
          <li><a href="visualizzaProdotto.jsp">Giacche</a></li>
          <li><a href="visualizzaProdotto.jsp">Jeans</a></li>
          <li><a href="visualizzaProdotto.jsp">Camicie</a></li>
          <li><a href="visualizzaProdotto.jsp">Intimo</a></li>
          <li><a href="visualizzaProdotto.jsp">Shirt e felpe</a></li>
          <li><a href="visualizzaProdotto.jsp">Cappotti</a></li>
          <li><a href="visualizzaProdotto.jsp">Pantaloni</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><font color= #FF0000>DONNA</font><span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="visualizzaProdotto.jsp">Giacche</a></li>
          <li><a href="visualizzaProdotto.jsp">Jeans</a></li>
          <li><a href="visualizzaProdotto.jsp">Camicie</a></li>
          <li><a href="visualizzaProdotto.jsp">Intimo</a></li>
          <li><a href="visualizzaProdotto.jsp">Shirt e felpe</a></li>
          <li><a href="visualizzaProdotto.jsp">Cappotti</a></li>
          <li><a href="visualizzaProdotto.jsp">Pantaloni</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><font color= "brown">ACCESSORI</font><span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="visualizzaProdotto.jsp">Borse</a></li>
          <li><a href="visualizzaProdotto.jsp">Occhiali</a></li>
          <li><a href="visualizzaProdotto.jsp">Cappelli</a></li>
          <li><a href="visualizzaProdotto.jsp">Cinture</a></li>
          <li><a href="visualizzaProdotto.jsp">Sciarpe</a></li>
        </ul>
      </li>
      
    </ul>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
    	<a href= "index.jsp">
    	<img  src="img/logodre.png" alt="Logo" height="80px" width="280px"> 
    	</a>

    <%! String s = new String();
    	String r = new String();%>
    <%s = (String) request.getSession().getAttribute("tipo");
    	System.out.println(s);
    	if(s == null){
    		s = "Login";
    		r = "login.jsp";
    	} else {
    		s = "Logout";
    		r = "LogoutControl";
    	}
    %>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="carrello.jsp"><font color= GRAY><span class="glyphicon glyphicon-shopping-cart"></span> Carrello</font></a></li>
      <li><a href="area_utente.jsp"><font color= GRAY><span class="glyphicon glyphicon-user"></span> Area Utente</font></a></li>
      <li><a href= <%= r %> ><font color= GRAY><span class="glyphicon glyphicon-log-in"></span> <%= s %></font></a></li>
      
    </ul>
  </div>
</nav>
   <script src="scripts/animation.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>