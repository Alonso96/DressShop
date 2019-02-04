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
	<%	
		
	String email = (String)session.getAttribute("email");
	System.out.println(email);
	int flag= (int)session.getAttribute("tipo");
	System.out.println(flag);
	
if(email !=null)
{
	
	if(tipo==3){
		System.out.println("loggato come amministratore");
	}
	else
		
		response.sendRedirect("index.jsp");
}

else {
	
	response.sendRedirect("index.jsp");
}
%>

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
        <h4 class="card-title">Gestore Marketing</h4>
          <p class="card-text"><br>Cognome <%--=session.getAttribute("cognome")--%><br> E-Mail<%--=session.getAttribute("eMail")--%><br> Data di nascita.<%--=session.getAttribute("dataDiNascita")--%></p>
      </div>
    </div>
  </div>
 

</div>
<div class="btn-group-vertical pull-left">
  <button type="button" class="btn btn-secondary btn-lg" onclick=location.href='prodottiSenzaPrezzo.jsp'>Scegli il prezzo dei Prodotti</button>
  <button type="button" class="btn btn-secondary btn-lg" onclick=location.href='inserisciPromozione.jsp'>Inserisci Promozione</button>

</div>
<div class="container" id="modi">

    <h3 class="h3">Resi da Effettuare </h3>
    <div class="row">
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
            <%--
		if(products.size() > 0) {
		//ok
		Iterator<?> it = products.iterator();
		
		while(it.hasNext()) {
			ProdottoBean bean = (ProdottoBean) it.next();
*/	--%>
                <div class="product-image6">
                    <a href="#">
                        <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" <%--src="<%=bean.getFoto()--%>>
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#">Women's Red Top</a></h3>
                    <div class="price"> &euro; 11.00 <%--= //bean.getPrezzoV()--%>
                        <span>$14.00</span>
                    </div>
                </div>
            <form action="ProductControl" method="post">
                  <button type="button" class="btn btn-secondary btn-lg" onclick="" name="reso">Effettua reso</button>
               </form>
            </div>
        </div>
        <%-- 		} 
		} else {
	--%>	
		<%--<tr>
			<td colspan="4">No product available</td>
		</tr>--%>
<%--/*}*/--%> 

</div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>