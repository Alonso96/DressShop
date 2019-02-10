<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INSERISCI PREZZO</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="css/stile.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>



<form action="ProductControl" method="post">
               <input type="text" class="form-control form-control-sm" id="myText" placeholder="Inserisci prezzo" name="prezzo">
               <button class="btn btn-primary" type="submit" onclick="aggiungiPrezzo()">Aggiungi prezzo</button>
                </form>
        



</body>
</html>