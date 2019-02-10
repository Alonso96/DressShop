<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGGIUNGI INDIRIZZO</title>
<link href="css/css/indirizzo.css" rel="stylesheet" >
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
<%@ include file="header.jsp" %>
<%
if(request.getSession().getAttribute("tipo") != null){
	int tipo = (int) session.getAttribute("tipo");
	if( tipo ==2 || tipo ==3 || tipo == 4)
		response.sendRedirect("index.jsp");
}
%>

<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;AGGIUNGI INDIRIZZO</h4>
<hr>

<a href="mostra_indirizzi.jsp"><img src="img/left.png"></a>

<div id="wrapper" class="container">
  
  

    <form id="form-work" class="" name="aggiungi_indirizzo" action="AggiungiIndirizzo" method ="post">
      
      <fieldset>
      
        <div class="form-group">
          <div class="col-md-6">
            <label class="control-label" for="nome">Nome</label>
            <input type="text" name="nome" class="form-control" placeholder="Mario"  required oninput ="controlloNome()">
            </div>
          </div>

        <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="surname">Cognome</label>
              <input type="text" name="cognome" class="form-control" placeholder="Rossi" required oninput ="controlloCognome()">
            </div>
          </div>

         

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="mobile">Cellulare</label>
              <div class="input-group">
                <span class="input-group-addon">+39</span>
                <input type="text" name="cellulare" class="form-control" placeholder="3334576298" required oninput ="controlloCellulare()">
              </div>
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="email">Città</label>
              <input type="text" name="citta" class="form-control" placeholder="Napoli" required oninput ="controlloCitta()">
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Via</label>
              <input type="text" name="via" class="form-control" placeholder="Via Roma"  required oninput ="controlloVia()">
            </div>
          </div>
          
          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Cap</label>
              <input type="text" name="cap" class="form-control" placeholder="80100"  required oninput ="controlloCap()">
            </div>
          </div>
          
          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Provincia</label>
              <input type="text" name="provincia" class="form-control" placeholder="NA"  required oninput ="controlloProvincia()">
            </div>
          </div>
        
        
          <div class="form-group">
            <div class="col-md-12">
              <button type="button" value ="Aggiungi" class="btn btn-primary btn-lg btn-block info" onclick="validazione();">INVIA</button>
              <button class="btn btn-primary btn-lg btn-block info" type="reset" value="Cancella" name="reset"> RESET</button>
            </div>
          </div>     
      </fieldset> 
    </form>
</div>


<script src="scripts/ValidazioneIndirizzo.js"></script>
 <%@ include file="footer.jsp" %>
</body>
</html>