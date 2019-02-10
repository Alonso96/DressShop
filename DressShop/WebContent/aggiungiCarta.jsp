<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AGGIUNGI CARTA</title>
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
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;AGGIUNGI CARTA DI CREDITO</h4>
<hr>

<a href="mostra_carte.jsp"><img src="img/left.png"></a>

<div id="wrapper" class="container">
  
  

    <form id="form-work" class="" name="aggiungiCarta" action="AggiungiCarta" method="post">
      
      <fieldset>
      
        <div class="form-group">
          <div class="col-md-6">
            <label class="control-label" for="nome">Nome</label>
            <input type="text" name="nome" class="form-control" placeholder="Mario"   oninput ="controlloNome()" >
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
              <label class="control-label" for="mobile">Numero Carta</label>
              
                <input type="text" name="numero_carta" class="form-control" placeholder="1234 5678 9876 5432"  required oninput ="controlloNumero()">
             
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="email">CVV</label>
              <input type="text" name="cvv" class="form-control" placeholder="123"  required oninput ="controlloCvv()">
            </div>
          </div>

          <div class="form-group">
            <div class="col-md-6">
              <label class="control-label" for="district">Data di Scadenza</label>
              <input type="text" name="anno" class="form-control" placeholder="anno" required oninput ="controlloAnno()" >
              <input type="text" name="mese" class="form-control" placeholder="mese"  required oninput ="controlloMese()">
              <input type="text" name="giorno" class="form-control" placeholder="giorno"  required oninput ="controlloGiorno()">
            </div>
          </div>     
          <div class="form-group">
            <div class="col-md-12">
              <button type="button" value ="Aggiungi" class="btn btn-primary btn-lg btn-block info" onclick="validazione();"name="invia">INVIA</button>
               <button class="btn btn-primary btn-lg btn-block info" type="reset" value="Cancella" name="reset"> RESET</button>
            </div>
          </div>     
      </fieldset> 
    </form>
</div>



<script src="scripts/ValidazioneAddCarta.js"></script>

</body>
</html>