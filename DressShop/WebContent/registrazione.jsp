<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione</title>

<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

<%@ include file="header.jsp" %>

<div class="container">
<hr>
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Crea un Account</h4>
	<form>
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
        <input name="" class="form-control" placeholder="Nome" type="text">
   		 </div>
   
    </div> <!-- form-group// -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
        <input name="" class="form-control" placeholder="Cognome" type="text">
    </div> <!-- form-group// -->
    	</div>
    
     <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
        <input name="" class="form-control" placeholder="Data di nascita dd/mm/yy" type="text">
   		 </div>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
        <input name="" class="form-control" placeholder="Email" type="email">
		 </div>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		
		<select class="custom-select" style="max-width: 55px; min-height:33px;">
		    <option selected="" >+39</option>
		</select>
    	<input name="" class="form-control" placeholder="Numero di telefono" type="text">
    </div> <!-- form-group// -->
    </div>
    
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		
        <input class="form-control" placeholder="Inserisci password" type="password">
    		 </div>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
        <input class="form-control" placeholder="Ripeti password" type="password">
    		 </div>
    
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Crea Account  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Hai già un account? <a href="login.jsp">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->
</div> 
<!--container end.//-->
<br><br>
<br><br>
</article>
 <%@ include file="footer.jsp" %>
</body>
</html>