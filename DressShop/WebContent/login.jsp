<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

</head>
<body>
<%@ include file="header.jsp" %>



<div class="container login-container">
            <div class="row">
                <div class="col-md-12 login-form-1">
                    <h3>Login</h3>
                    
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Email *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password *" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Login" />
                        </div>
                    	<div class="form-group">
                       <p class="btnForgetPwd">Non hai un account?     <a href="registrazione.jsp" >registrati</a></p>
                        </div>
                </div>
                
                    </form>
                </div>
            </div>
        </div>
        <%@ include file="footer.jsp" %>
</body>
</html>