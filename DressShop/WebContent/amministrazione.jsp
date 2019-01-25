<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Pannello Amministratore</title>


<style>
#header {
	background-color: #ff8533;
}
</style>
</head>
<body>

<%	
		
	String name = (String)session.getAttribute("name");
	System.out.println(name);
	String flag= (String)session.getAttribute("flag");
	System.out.println(flag);
	
if(name !=null)
{
	
	
}

else {
	response.sendRedirect("home.jsp");	
}
%>

	<div id="wrapper">
		<div id="header" class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <img
						src="immagini/dressLogo.png" style="height: 200px; width: 800px">

					</a>

				</div>


			</div>
		</div>
		<nav class="navbar-default navbar-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav" id="main-menu">



				<li class="active-link"><a href="#"><i
						class="fa fa-desktop "></i>Dashboard </a></li>


				<li><a href="inserisciProdotti.jsp"><i class="fa fa-edit "></i>Inserisci nuovo
						prodotto</a></li>
				
				<li><a href="home.jsp"><i class="fa fa-mail-reply "></i>Torna
						al sito</a></li>
				<li><a href="logout.jsp"><i class="fa fa-mail-reply "></i>Logout</a></li>
						


			</ul>
		</div>

		</nav>

		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-lg-12">
						<h2>Pannello Amministratore</h2>
					</div>
				</div>

				<hr />


				<div class="row text-center pad-top">

					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
						<div class="div-square">
							<a href="home.jsp"> <i class="fa fa-desktop fa-5x"></i>
								<h4>Sito Web</h4>
							</a>
						</div>


					</div>
				

				
				</div>

				<hr />
				<h4>Abbigliamento</h4>

				<div class="row text-center pad-top">


					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
						<div class="div-square">
							<a href="woman.jsp"> <i class="fa fa-book fa-5x"></i>
								<h4>Donna</h4>
							</a>
						</div>


				</div>
				<hr />
				<h4>Utenti</h4>

				<div class="row text-center pad-top">


					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-6">
				
				
				
					
					  <form action="DeleteUser" method="post">
                		<h5>Rimuovi utente</h5>
                		<input type="text" placeHolder="Nickaname" name="Nickname"/>
                		<input type="submit" value="Click" name="DeleteUser"/>
                     </form>
					  
						</div>

					</div>
				</div>
			</div>
			
			
			
</body>
</html>