<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca Prodotto</title>


</head>
<body>



<%@ include file="header.jsp" %>
<%@ page import="java.util.Collection, java.util.Iterator, model.ProdottoBean, java.text.DecimalFormat" %>


<%
    	Collection<ProdottoBean> products = (Collection<ProdottoBean>) request.getAttribute("prodotti");
%>    
   
	
	
<div class="container">

    <div class="row">
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
<%
		if((products != null) && (products.size() > 0)) {
		Iterator<?> it = products.iterator();
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		while(it.hasNext()) {
			ProdottoBean bean = (ProdottoBean) it.next();
%>
                <div class="product-image6">
                    <a href="ProductControl?action=detail&id=<%=bean.getId_prodotto()%>">
                        <img class="pic-1" src= <%= bean.getFoto()%>>
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="ProductControl?action=detail&id=<%=bean.getId_prodotto()%>"><%= bean.getMarca().toUpperCase() + " - " + bean.getModello() %></a></h3>
                    <div class="price"> &euro;<%= formatter.format(bean.getPrezzo_compl()) %>
                    </div>
                </div>
                              
            </div>
        </div>
        <% 		} 
		} else {
	%>	
		<tr>
			<td colspan="4">No product available</td>
		</tr>
<% } %> 
    </div>
</div>
<hr>
 <%@ include file="footer.jsp" %>
</body>
</html>