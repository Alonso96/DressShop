<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACQUISTO COMPLETATO</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
if(request.getSession().getAttribute("tipo") != null){
	int tipo = (int) session.getAttribute("tipo");
	if( tipo ==2 || tipo ==3 || tipo == 4)
		response.sendRedirect("index.jsp");
}
%>
<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;ACQUISTO COMPLETATO</h4>
<hr>

<h2>&emsp; &emsp; &emsp;Complimenti hai completato il tuo acquisto! Vai allo <a href="StoricoControl">storico</a> per visualizzare il tuo ordine</h4>







 <%@ include file="footer.jsp" %>

</body>
</html>