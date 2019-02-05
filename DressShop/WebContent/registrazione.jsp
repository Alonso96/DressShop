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

<form action="RegistrationControl" method="post" name ="registration">
 <input type="hidden" name="action" value="registration">
<div class="container">
<hr>

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Crea un Account</h4>
	
	
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
        <input type="text" class="form-control" placeholder="Nome" name="nome" >
   		 </div>
   
    </div> <!-- form-group// -->
    <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
        <input type="text" class="form-control" placeholder="Cognome" name="cognome" >
    </div> <!-- form-group// -->
    	</div>
    
     <div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
        <input type="date" class="form-control" placeholder="Data di nascita dd/mm/yy" name="data_nascita" >
   		 </div>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
        <input type="email" class="form-control" placeholder="Email" name="email">
		 </div>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
        <input type="password" class="form-control" placeholder="Inserisci password" name="password">
    		 </div>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
        <input class="form-control" placeholder="Ripeti password" type="password">
    		 </div>
     </div> <!-- form-group// -->                                      
    <div class="form-group">
        <input type="submit" class="btn btn-primary btn-block" value="Registrati">
        
</div>
    <p class="text-center">Hai già un account? <a href="login.jsp">Log In</a> </p>                                                                 
 
</article>
</div> <!-- card.// -->
</div>

<!--container end.//-->
<br><br>
<br><br>
</form>
 <%@ include file="footer.jsp" %>
</body>
</html>