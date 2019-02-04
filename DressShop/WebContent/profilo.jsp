<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<%@ include file="header.jsp" %>
<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;DATI PERSONALI</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>

<div class= "contenitore">
<table class="table">
    <tbody>
    <tr>
        <th>
            Nome
        </th>
        <td>
            Primo Nome
        </td>
        
    </tr>
    <tr>
        <th>
            Cognome
        </th>
        <td>
            Primo Cognome
        </td>
        
    </tr>
    <tr>
        <th>
            Anno di nascita
        </th>
        
        
        <td>
            Primo Anno di nascita
        </td>
		</tr>
		<tr>
        <th>
           Email
        </th>
        <td>
            email@
        </td>
		</tr>
		
		
		<tr>
        <th>
            Numero Cellullare
        </th>
        <td>
            Primo Anno di nascita
        </td>
		</tr>
			
		<tr>
        <th>
            	Password
        </th>
        
        
        <td>
            ******
        </td>
        <td>
           <a href="#" class="myButton">MODIFICA PASSWORD</a>
        </td>
		</tr>
    </tbody>
</table>

</div>






 <%@ include file="footer.jsp" %>
</body>
</html>