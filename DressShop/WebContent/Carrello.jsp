<%

ProductBean product = (ProductBean) request.getAttribute("product");

Carrello cart = (Carrello) session.getAttribute("cart"); %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.ProductBean, model.Carrello"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Carrello</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<style>
body{
background-image: white;
}

</style>

<h2>Carrello</h2>
<table>
	<tr>
		<th>Nome</th>
		<th>Azione</th>
	</tr>
	<%
		
		List<ProductBean> prodcart = cart.ottieniElem();
		if(prodcart.size()==0){
			response.sendRedirect("VisualizzaProdotti.jsp");
		}else{
		for(ProductBean beancart: prodcart) {
			System.out.println(prodcart);
		
	%>
		<tr>
			<td><%=beancart.getCodice() %></td>
			<td><a href="CartControl?action=delCart&id=<%=beancart.getId()%>">Cancella da carrello</a>
			

		</tr>
					
	<%
		}
		}
	%>
	
</table>
<form method="get" action="ProcediAcquisto" name ="ProcediAcquisto" >
<input type="hidden" name="action" value="ProcediAcquisto">
<input type="submit" value="Acquista!">


</form>

</body>
</html>