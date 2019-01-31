<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/css/bootstrap.min.css">
<link href="css/stile.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="css/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	

    


<div class="row">

  <div class="col-sm-6">
    <div class="card">
      <h4 class="card-header bg-dark text-white">Nome  <%--=session.getAttribute("nome")--%>
      </h4>
      <div class="card-body">
          <div class="image float-left user-l">
            <img src="http://31.media.tumblr.com/tumblr_lw2lhqjrel1qfmi03o9_r1_500.gif" class="img-thumbnail" alt="avatar"/>
          </div>
        <h4 class="card-title">Magazziniere</h4>
          <p class="card-text"><br>Cognome<br> E-Mail<br> Data di nascita.</p>
      </div>
    </div>
  </div>
            

</div>

<div class="btn-group-vertical pull-left">
  <button type="button" class="btn btn-secondary btn-lg" onclick="visualizza(1)">Inserisci prodotto</button>
  <button type="button" class="btn btn-secondary btn-lg" onclick="visualizza(2)">Comunica esaurimento prodotto</button>
  <button type="button" class="btn btn-secondary btn-lg" onclick=location.href='esaurimentoScorte.jsp'>Scorte in esaurimento</button>
  <button type="button" class="btn btn-secondary btn-lg">Large button</button>
</div>

 <form class="container col-sm-6">
 
  <div class="form-group" id='ins'>
<input class="form-control form-control-lg" type="text" placeholder="Inserisci categoria">   
<input class="form-control form-control-lg" type="text" placeholder="Inserisci tipo">
<input class="form-control form-control-lg" type="text" placeholder="Inserisci marca"> 
<input class="form-control form-control-lg" type="text" placeholder="Inserisci modello"> 
<input class="form-control form-control-lg" type="text" placeholder="Inserisci foto"> 
<input class="form-control form-control-lg" type="text" placeholder="Inserisci taglia"> 
<input class="form-control form-control-lg" type="text" placeholder="Inserisci quantità"> 
<input class="form-control form-control-lg" type="text" placeholder="Inserisci colore"> 
  	<button type="button" class="btn btn-secondary btn-lg" onclick="">Inserisci</button> 
  </div>
  <div class="form-group" id='com'>

  <p>Invia a</p>   
    <input type="email" class="form-control"  placeholder="name@example.com">
<input class="form-control form-control-lg" type="text" placeholder="Id Prodotto">

</div>
</form>

 <script > 

 document.getElementById("ins").style.display="none";
 document.getElementById("com").style.display="none";
 //document.getElementById("asd").style.display="block";
 //document.getElementById("asd").style.display="block";
 function visualizza(flag){


	 switch(flag){
	       case(1):
		    document.getElementById("ins").style.display="block";
	       document.getElementById("com").style.display="none";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
		   break; 
	       case(2):
		   document.getElementById("com").style.display="block";
	       document.getElementById("ins").style.display="none";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
	       	break;
	       case(3):
			    document.getElementById("asd").style.display="none";
	       document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
		       	break;
	       case(4):
			    document.getElementById("asd").style.display="none";
	       document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
		       	break;
				
		}
 }</script>
 <br>
 
 <%@ include file="footer.jsp" %>

</body>
</html>