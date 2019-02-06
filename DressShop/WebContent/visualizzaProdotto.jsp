<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.Collection, java.util.Iterator, model.ProdottoBean, java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VISUALIZZA PRODOTTO</title>
<link rel="stylesheet" href="css/css/bootstrap.min.css">
<link href="css/stile.css" rel="stylesheet" >
</head>

<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<%@ include file="header.jsp" %>
	<form action="CartControl" method="post">
	


<%
    	ProdottoBean prod = (ProdottoBean) request.getAttribute("product");
		DecimalFormat formatter = new DecimalFormat("#0.00");
%>    
	<div class="container">
	
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="<%=prod.getFoto()%>" /></div>
						  
						</div>
						
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title"><%=prod.getMarca().toUpperCase() + " - " + prod.getModello() %></h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							
						</div>
						<p class="product-description"><%=prod.getDescrizione() %></p>
						<h4 class="price">Prezzo: &euro; <%= formatter.format(prod.getPrezzo_compl()) %></h4>
						<%--if(podotto.getPromozione!=0){ 
						<p class="vote"><strong><%=prod.getPromozione() %> </strong></p>
						 --%>
						
						<h5 class="sizes" name="colore">sizes:
					       <%--switch(prodotto.getTaglia()){ --%>
							<%--case("S") :--%><button class="size" data-toggle="tooltip" >s</button>
							<%--case("M") :--%><button class="size" data-toggle="tooltip" >m</button>
							<%--case("L") :--%><button class="size" data-toggle="tooltip" >l</button>
							<%--case("XL") :--%><button class="size" data-toggle="tooltip" >xl</button><%--break;
							} --%>
						</h5>
						
						
						<div class="action">
								<a href="ProductControl?action=addCart&id=<%=prod.getId_prodotto()%>">Aggiungi a carrello</a>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</form>
	<%@include file="footer.jsp" %>
</body>
</html>