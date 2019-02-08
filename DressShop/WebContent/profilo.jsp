<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILO</title>

</head>
<body>
<%@ include file="header.jsp" %>
<% UtenteModel<UtenteBean> model = new UtenteModelDM();
	UtenteBean utente = new UtenteBean();
	utente= model.doRetrieveByEmail((String)session.getAttribute("email"));
%>
<hr>
<h4 class="scrittacarrello , bordo1" >&emsp; &emsp; &emsp;DATI PERSONALI</h4>
<hr>
<a href="area_utente.jsp"><img src="img/left.png"></a>

<div class= "contenitore">
<table class="table">
    <tbody>
    <tr>
        <th>
            Nome <br>
            
        </th>
        <td>
         
            <%=utente.getNome() %>
        </td>
        
    </tr>
    <tr>
        <th>
            Cognome
        </th>
        <td>
          <%=utente.getCognome() %>
        </td>
        
    </tr>
   
   <tr>
        <th>
           Anno di Nascita
        </th>
        <td>
            <%=utente.getData_nascita()%>
        </td>
		</tr>
		<tr>
        <th>
           Email
        </th>
        <td>
            <%=utente.getEmail() %>
        </td>
		</tr>
		
		
		
		<tr>
        
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