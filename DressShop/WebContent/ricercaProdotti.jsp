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
    /*	if(products == null) {
    		response.sendRedirect("./ProductControl");
    		return;
    	}
    	
    	ProdottoBean product = (ProdottoBean) request.getAttribute("product");*/
%>    
   
	
	
<div class="container">

    <div class="row">
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
<%
		if(products.size() > 0) {
		//ok
		Iterator<?> it = products.iterator();
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		while(it.hasNext()) {
			ProdottoBean bean = (ProdottoBean) it.next();
%>
                <div class="product-image6">
                    <a href="#">
                        <img class="pic-1" src= <%= bean.getFoto()%>>
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#"><%= bean.getMarca().toUpperCase() + " - " + bean.getModello() %></a></h3>
                    <div class="price"> &euro;<%= formatter.format(bean.getPrezzo_compl()) %>
                    </div>
                </div>
                <form action="CartControl" method="post">
                <button class="btn btn-primary" type="submit" name="aggiungi_carrello">Aggiungi al carrello</button>
                </form>
            </div>
        </div>
        <% 		} 
		} else {
	%>	
		<tr>
			<td colspan="4">No product available</td>
		</tr>
<% } %> 
 <%--        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
                <div class="product-image6">
                    <a href="#">
                        <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg">
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#">Women's Red Top</a></h3>
                    <div class="price">$8.00
                        <span>$12.00</span>
                    </div>
                </div>
                <ul class="social">
                    <li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
                    <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
                    <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
                <div class="product-image6">
                    <a href="#">
                        <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-3.jpg">
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#">Men's Shirt</a></h3>
                    <div class="price">$11.00
                        <span>$14.00</span>
                    </div>
                </div>
                <ul class="social">
                    <li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
                    <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
                    <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
                <div class="product-image6">
                    <a href="#">
                        <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-4.jpg">
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#">Men's Shirt</a></h3>
                    <div class="price">$11.00
                        <span>$14.00</span>
                    </div>
                </div>
                <ul class="social">
                    <li><a href="" data-tip="Quick View"><i class="fa fa-search"></i></a></li>
                    <li><a href="" data-tip="Add to Wishlist"><i class="fa fa-shopping-bag"></i></a></li>
                    <li><a href="" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a></li>
                </ul>
            </div>
        </div>
        --%>
    </div>
</div>
<hr>
 <%@ include file="footer.jsp" %>
</body>
</html>