<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PROPRIETARIO</title>
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
	
	if(tipo==4){
		System.out.println("loggato come proprietario");
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
        <h4 class="card-title">Proprietario</h4>
          <p class="card-text"><br>Cognome<br> E-Mail<br> Data di nascita.</p>
      </div>
    </div>
  </div>
            

</div>

<div class="btn-group-vertical pull-left">
  <button type="button" class="btn btn-secondary btn-lg" onclick="visualizza(1)">Inserisci prodotto</button>
  <button type="button" class="btn btn-secondary btn-lg" onclick=location.href='eliminaUtenti.jsp'>Elimina utenti</button>
</div>

<div class="container" id="modi">

    <h3 class="h3">Modifica prodotti </h3>
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
                    <a href="modificaProdotto.jsp">
                        <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-2.jpg" <%--src="<%=bean.getFoto()--%>>
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="modificaProdotto.jsp">Women's Red Top</a></h3>
                    <div class="price"> &euro; 11.00 <%--= //bean.getPrezzoV()--%>
                        <span>$14.00</span>
                    </div>
                </div>
            </div>
        </div>
        <%-- 		} 
		} else {
	--%>	
		<%--<tr>
			<td colspan="4">No product available</td>
		</tr>--%>
<%--/*}*/--%> 
        <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
                <div class="product-image6">
                    <a href="#">
                        <img class="pic-1" src="http://bestjquery.com/tutorial/product-grid/demo10/images/img-1.jpg">
                    </a>
                </div>
                <div class="product-content">
                    <h3 class="title">Men's Shirt<a href="#"></a></h3>
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
    </div>
</div>
 

 <script > 

 document.getElementById("ins").style.display="none";
 document.getElementById("com").style.display="none";
 //document.getElementById("asd").style.display="block";
 //document.getElementById("asd").style.display="block";
 function visualizza(flag){


	 switch(flag){
	       case(1):
		    document.getElementById("ins").style.display="block";
	       document.getElementById("com").style.display="none";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
		   break; 
	       case(2):
		   document.getElementById("com").style.display="block";
	       document.getElementById("ins").style.display="none";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
	       	break;
	       case(3):
			    document.getElementById("asd").style.display="none";
	       document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
		       	break;
	       case(4):
			    document.getElementById("asd").style.display="none";
	       document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
	       //document.getElementById("asd").style.display="block";
		       	break;
				
		}
 }</script>
 <br>
 <div class="container" id="np">
<div class="col-md-3 col-sm-6">
</div>
<div class="col-md-3 col-sm-6">
</div>
<div class="col-md-3 col-sm-6">
</div>
</div>

 <%@ include file="footer.jsp" %>

</body>
</html>