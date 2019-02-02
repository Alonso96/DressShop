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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<%@ include file="header.jsp" %>
	<form action="CartControl" method="post">
	<%--
ProdottoBean prodotto= (ProdottoBean) session.getAttribute("product");

--%>
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">
						
						<div class="preview-pic tab-content">
						  <div class="tab-pane active" id="pic-1"><img src="<%--prodotto.getFoto() --%> http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></div>
						  <div class="tab-pane" id="pic-2"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></div>
						  <div class="tab-pane" id="pic-3"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></div>
						  <div class="tab-pane" id="pic-4"><img src="http://placekitten.com/400/252" /></div>
						  <div class="tab-pane" id="pic-5"><img src="http://placekitten.com/400/252" /></div>
						</div>
						<ul class="preview-thumbnail nav nav-tabs">
						  <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-2" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-3" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-4" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-5" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						</ul>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">men's shoes fashion<%--prodotto.getMarca(); prodotto.getModello() --%></h3>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							
						</div>
						<p class="product-description"><%--prodotto.getDescrizione() --%>Suspendisse quos? Tempus cras iure temporibus? Eu laudantium cubilia sem sem! Repudiandae et! Massa senectus enim minim sociosqu delectus posuere.</p>
						<h4 class="price">Prezzo: &euro; 180<%--prodotto.getPrezzo()>--%></h4>
						<%--if(podotto.getPromozione!=0){ --%>
						<p class="vote"><strong>Scontato del 91%<%--prodotto.getPromozione() --%></strong> </strong></p>
						<%-- --%>
						<form>
						<h5 class="sizes" name="colore">sizes:
					       <%--switch(prodotto.getTaglia()){ --%>
							<%--case("S") :--%><button class="size" data-toggle="tooltip" >s</button>
							<%--case("M") :--%><button class="size" data-toggle="tooltip" >m</button>
							<%--case("L") :--%><button class="size" data-toggle="tooltip" >l</button>
							<%--case("XL") :--%><button class="size" data-toggle="tooltip" >xl</button><%--break;
							} --%>
						</h5>
						</form>
						<form name="colore">
						<h5 class="colors">colors:
							<button class="color green" style="background-color: orange<%--prodotto.getColore()--%>;" > </button>
							<button class="color green"></button>
							<button class="color blue"></button>
						</h5>
						</form>
						<div class="action">
							<button class="add-to-cart btn btn-default" type="button" name="prodotto">Aggiungi al carrello</button>
							
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