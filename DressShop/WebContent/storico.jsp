<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/css/bootstrap.min.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>STORICO ACQUISTI</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ page import = "java.util.*, model.indirizzo.*, model.ordine.*, model.prodotto.*, java.text.DecimalFormat" %>
<%
if(request.getSession().getAttribute("tipo") != null){
	int tipo = (int) session.getAttribute("tipo");
	if( tipo ==2 || tipo ==3 || tipo == 4)
		response.sendRedirect("index.jsp");
}
%>
<%	
	Collection<OrdineBean> listaOrdini = new ArrayList<OrdineBean>();
	if(request.getSession().getAttribute("listaOrdini") != null){
		listaOrdini = (Collection<OrdineBean>) request.getSession().getAttribute("listaOrdini");
	}	
%>
<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;STORICO ACQUISTI</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>
<%
	if(!listaOrdini.isEmpty()){
		DecimalFormat formatter = new DecimalFormat("#0.00");
%>
<section class="pricing py-5">
  <div class="container">
    <div class="row">
<%
		for(OrdineBean ordine : listaOrdini){
			IndirizzoModel indModel = new IndirizzoModelDM();
			IndirizzoBean indirizzo = (IndirizzoBean) indModel.doRetrieveByKey(ordine.getIndirizzo());
			
			ProdottoInOrdineModelDM prodModel = new ProdottoInOrdineModelDM();
			Collection<ProdottoBean> prodotti = prodModel.doRetrieveByOrder(ordine.getId_ordine());
		
%>      
      <div class="col-lg-4">
        <div class="card mb-5 mb-lg-0">
          <div class="card-body">
          <center> <img alt="ordini effettuati" src="img/delivery-cart.png"></center> 
            <hr>
            <ul class="fa-ul">
              <li><span class="fa-li"><i class="fas fa-check"></i></span>SPEDITO A:
              <br><%= indirizzo.getNome() + " " + indirizzo.getCognome() + ", " + indirizzo.getVia() + ", " + 
              indirizzo.getCitta() + "(" + indirizzo.getProvincia() + ")" %></li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>EFFETTUATO IL:<br><%= ordine.getData() %></li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>TOTALE:<br>&euro; <%= formatter.format(ordine.getTotale()) %></li>
              <li><span class="fa-li"><i class="fas fa-check"></i></span>LISTA PRODOTTI ACQUISTATI:
<%
			for(ProdottoBean prodotto : prodotti){
%>
              		<br><img src="<%= prodotto.getFoto() %>" width="30%" ><br><%= prodotto.getMarca().toUpperCase() + " - " + prodotto.getModello() %>
              		<br>Taglia: <%= ((ProdottoInOrdineBean)prodotto).getTaglia() %><br>Quantit&agrave;: <%= ((ProdottoInOrdineBean)prodotto).getQuantita() %><br>&euro; <%= formatter.format(prodotto.getPrezzo_compl()) %>
<%
			}
%>
              </li>
            </ul>
            
          </div>
        </div>
      </div>
<%
		}
%>
   </div>
  </div>
</section>
<%
	}
%>
 <%@ include file="footer.jsp" %>
</body>
</html>