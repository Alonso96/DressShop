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
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;AGGIUNGI INDIRIZZO</h4>
<hr>

<div id="wrapper" class="container">
  
  

    <form id="form-work" class="" name="aggiungi_indirizzo" action="aggiungi_indirizzo">
      
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
              <label class="control-label" for="mobile">Cellulare</label>
              <div class="input-group">
                <span class="input-group-addon">+39</span>
                <input name="cellulare" class="form-control" placeholder="3334576298" type="text">
              </div>
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="email">Città</label>
              <input name="citta" class="form-control" placeholder="Napoli" type="text">
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Via</label>
              <input name="via" class="form-control" placeholder="Roma" type="text">
            </div>
          </div>
          
          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Cap</label>
              <input name="cap" class="form-control" placeholder="80100" type="text">
            </div>
          </div>
          
          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Provincia</label>
              <input name="provincia" class="form-control" placeholder="NA" type="text">
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



 <%@ include file="footer.jsp" %>
</body>
</html>