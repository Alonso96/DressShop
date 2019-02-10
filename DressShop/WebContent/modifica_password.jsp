<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modifica Password</title>

</head>
<body>
<%@ include file="header.jsp" %>
<%
String email= (String) session.getAttribute("email");
if (email == null)
	response.sendRedirect("index.jsp"); // 
else {}
%>

<form action="PasswordControl" method="post" name="modificaP">
<div class="container login-container"> 
            <div class="row">
                <div class="col-md-12 login-form-1">
                    <h3>Modifica Password</h3>
                    
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Nuova password *" name ="password"   required oninput ="controlloPassword()">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Ripeti password *" name ="password2" required oninput ="controlloPassword()" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" name="invio" value="Conferma Password" name="conferma" onclick="validazione()"/>
                        </div>
                    	
                </div>
                
                    
                </div>
            </div>
       
    </form>    
    <script src="scripts/ValidazioneLogin.js"></script>
        <%@ include file="footer.jsp" %>
</body>
</html>