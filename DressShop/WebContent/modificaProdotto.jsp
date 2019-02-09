<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.*, controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MODIFICA PRODOTTO</title>
<link rel="stylesheet" href="css/css/bootstrap.min.css">
<link href="css/stile.css" rel="stylesheet" >
</head>

<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<%@ include file="header_gestori.jsp" %>
	<%
ProdottoBean prodotto= (ProdottoBean) session.getAttribute("product");

%>
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
						<form action="ProductControl" method="post">
						<input class="form-control form-control-sm" type="text" placeholder="modifica foto" id="foto" name="foto">
						<button type="submit" value="submit" class="btn btn-secondary btn-lg"  >invia</button>  
						</form>
						<ul class="preview-thumbnail nav nav-tabs">
						  <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-2" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-3" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-4" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						  <li><a data-target="#pic-5" data-toggle="tab"><img src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" /></a></li>
						</ul>
						
					</div>
					<div class="details col-md-6">
						<h3 class="product-title">Modello Marca<%--prodotto.getMarca(); prodotto.getModello() --%></h3>
						<form action="ProductControl" method="post">
						<input class="form-control form-control-sm" type="text" placeholder="modifica marca" id="marca" name="marca">  
						<button type="submit" value="submit" class="btn btn-secondary btn-lg" >invia</button> 
						</form>
						<form action="ProductControl" method="post">
						<input class="form-control form-control-sm" type="text" placeholder="modifica modello" id="modello" name="modello">
						<button type="submit" value="submit" class="btn btn-secondary btn-lg" onclick="modificaModello()">invia</button>  
						</form>
						<div class="rating">
							<div class="stars">
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star checked"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
							
						</div>
						<h5 class="sizes">sizes:
						<form action="ProductControl" method="post">
						<input class="form-control form-control-sm" type="text" placeholder="modifica taglia" id="taglia" name="taglia">
						<button type="submit" value="submit" class="btn btn-secondary btn-lg" onclick="modificaTaglia()">invia</button> 
					       </form>
					       <%--switch(prodotto.getTaglia()){ --%>
							<%--case("S") :--%><button class="size" data-toggle="tooltip" >s</button>
							<%--case("M") :--%><button class="size" data-toggle="tooltip" >m</button>
							<%--case("L") :--%><button class="size" data-toggle="tooltip" >l</button>
							<%--case("XL") :--%><button class="size" data-toggle="tooltip" >xl</button><%--break;
							} --%>
						</h5>
						<form action="ProductControl" method="post">
						<input class="form-control form-control-sm" type="text" placeholder="modifica colore" id="colore" name="colore">
						<button type="submit" value="submit" class="btn btn-secondary btn-lg" onclick="modificaColore()">invia</button> 
						</form>
						<h5 class="colors">colors:
							<button class="color green" style="background-color: orange<%--prodotto.getColore()--%>;" > </button>
							<button class="color green"></button>
							<button class="color blue"></button>
						</h5>
						<form action="ProductControl" method="post">
						<input class="form-control form-control-sm" type="text" placeholder="modifica quantita'" id="quantita" name="quantita">
						<button type="submit" value="submit" class="btn btn-secondary btn-lg" onclick="modificaQuantita()">invia</button> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
<script>
	function modificaMarca() {
  var x = document.getElementById("marca").value;
 ;
  
}
	function modificaQuantita() {
		  var x = document.getElementById("quantita").value;
		 ;
		  //bean.setQuantita(x);
		}
	function modificaFoto() {
		  var x = document.getElementById("foto").value;
		 ;
		  //bean.setFoto(x);
		}
	function modificaModello() {
		  var x = document.getElementById("modello").value;
		 ;
		  //bean.setModello(x);
		}
	function modificaTaglia() {
		  var x = document.getElementById("Taglia").value;
		 ;
		  //bean.setTaglia(x);
		}
	function modificaColore() {
		  var x = document.getElementById("Colore").value;
		 ;
		  //bean.setColore(x);
		}
	</script>
</body>
</html>