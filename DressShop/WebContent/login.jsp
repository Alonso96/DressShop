<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>LOGIN</title>

</head>
<body>
<%@ include file="header.jsp" %>


<form action="LoginControl" method="post" name="login">
<div class="container login-container"> 
            <div class="row">
                <div class="col-md-12 login-form-1">
                    <h3>Login</h3>
                    
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Email *" name ="email"   required oninput ="controlloEmail()">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password *" name ="password" required oninput ="controlloPassword()" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" name="invio" value="Login" name="login" onclick="validazione()"/>
                        </div>
                    	<div class="form-group">
                       <p class="btnForgetPwd">Non hai un account? <a href="registrazione.jsp" >registrati</a></p>
                        </div>
                </div>
                
                    
                </div>
            </div>
       
    </form>    
    <script src="scripts/ValidazioneLogin.js"></script>
        <%@ include file="footer.jsp" %>
</body>
</html>