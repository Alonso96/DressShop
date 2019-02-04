<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/css/indirizzo.css" rel="stylesheet" >
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>

<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;AGGIUNGI CARTA DI CREDITO</h4>
<hr>

<a href="mostra_carte.jsp"><img src="img/left.png"></a>

<div id="wrapper" class="container">
  
  

    <form id="form-work" class="" name="aggiungi_carta" action="aggiungi_carta">
      
      <fieldset>
      
        <div class="form-group">
          <div class="col-md-6">
            <label class="control-label" for="nome">Nome</label>
            <input name="nome" class="form-control" placeholder="Mario" type="text">
            </div>
          </div>

        <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="surname">Cognome</label>
              <input name="cognome" class="form-control" placeholder="Rossi" type="text">
            </div>
          </div>

         

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="mobile">Numero Carta</label>
              
                <input name="cellulare" class="form-control" placeholder="1234 5678 9876 5432" type="text">
             
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="email">CVV</label>
              <input name="CVV" class="form-control" placeholder="123" type="text">
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Data Scadenza</label>
              <input name="data_scadenza" class="form-control" placeholder="01/22" type="text">
            </div>
          </div>
          
          
         
        
        
          <div class="form-group">
            <div class="col-md-12">
              <button type="button" class="btn btn-primary btn-lg btn-block info">INVIA</button>
            </div>
          </div>     
      </fieldset> 
    </form>
</div>




</body>
</html>