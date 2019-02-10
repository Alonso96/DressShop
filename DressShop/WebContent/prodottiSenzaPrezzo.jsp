<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.* ,java.text.DecimalFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRODOTTI SENZA PREZZO</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="css/stile.css" rel="stylesheet" >
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<%		ProdottoModel<ProdottoBean>  products = new ProdottoModelDM();
    	Collection<ProdottoBean> prod = products.doRetrieveAllPrezzoZero();
%>    

<%@ include file="header.jsp" %>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<%--
    	Collection<?> products = (Collection<?>) request.getAttribute("product");
    	if(products == null) {
    		response.sendRedirect("./ProductControl");
    		return;
    	}
    	
    	ProdottoBean product = (ProdottoBean) request.getAttribute("product");
    --%>    
    <div class="container">
     <h3 class="h3">Prodotti</h3>
<%
		if((products != null) && (prod.size() >= 0)) {
		Iterator<?> it = prod.iterator();
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		while(it.hasNext()) {
			ProdottoBean bean = (ProdottoBean) it.next();
%>
    
    <div class="row">
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
            <%--
		if(products.size() > 0) {
		
		Iterator<?> it = products.iterator();
		
		while(it.hasNext()) {
			ProdottoBean bean = (ProdottoBean) it.next();
			if(bean.getPrezzo()==null){
*/	--%>		<form action="InsPrezzoControl" method="post" name="insP">

					<div class="product-image6">
                   
                        <img class="pic-1" src=<%=bean.getFoto() %> <%--src="<%=bean.getFoto()--%>>
                    
                </div>
                <div class="product-content">
                	<input type ="hidden" name=id_prodotto value=<%=bean.getId_prodotto() %> >
                    <h3 class="title"><%=bean.getMarca() + " "+  bean.getModello() %></h3>
                    <div class="price" id='prezzo'> &euro; x <%=bean.getPrezzo_compl() %>
                    
               <input type="text" class="form-control form-control-sm" id="myText" placeholder="Inserisci prezzo" name="prezzo">
               <button type="submit"class="btn btn-primary" >Aggiungi prezzo</button>
               </div>
               </div>
                </form>
                
                       
                    </div>
                </div>
              </div>
              </div>
                <% 		} 
		} else {
	%>	
		
			<p>Nessun prodotto disponibile</p>
		
<% } %> 



        
        <%-- 	}
        	} 
		} else {
	--%>	
		<%--<tr>
			<td colspan="4">No product available</td>
		</tr>--%>
<%--/*}*/--%> 
       
<hr>
<script>
function aggiungiPrezzo() {
  var x = document.getElementById("myText").value;
  document.getElementById("prezzo").innerHTML = "&euro;"+x;
  
}
</script>
</body>
</html>