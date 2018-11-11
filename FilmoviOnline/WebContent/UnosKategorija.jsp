<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
HttpSession sesija = request.getSession();
Korisnik admin=(Korisnik)sesija.getAttribute("admin");

if(admin!=null){
	
	
	
%>



<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1 ">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <link href="stilovi/style.css" rel="stylesheet" type="text/css">


<title>kategorije</title>
</head>
<body>

	<div class="container-fluid">
		<!-- HEADER -->
		<header>
			<div class="container text-center">
				<p>
					<br> <br> <br>
				<h1 style="font-size: 70px;">FILMOVI ONLINE</h1>
				</p>

			</div>
		</header>
		<!-- KRAJ HEADER-A -->
		<!-- NAV BAR -->

		<nav class="navbar navbar-inverse navbar-default">
			<div class="container-fluid">
				<div class="col-md-9">
					<ul class="nav navbar-nav">
						<li ><a href="indexSesijaAdmin.jsp">Pocetna</a></li>
						<li><a href="Film?akcija=najnoviji">Najnoviji filmovi</a></li>
					
						
						<li ><a href="Admin?akcija=unosFilma">Unos filmova</a></li>
						<li ><a href="Admin?akcija=filmovi">Svi filmovi</a></li>
						<li class="active"><a href="Admin?akcija=unosKategorije">Unos Kategorija</a></li>
						<li ><a href="Admin?akcija=kategorije">Sve kategorije </a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<div class="col-md-6" >
						<p style="text-align: right;color: white"><%=admin.getIme() %></p>
					</div>
					<div class="col-md-6" >
						<a href="Login" style="color: green;text-align: right;">LOGOUT</a>
					</div>					
				</div>
					
				
			</div>
		</nav>
		<!-- KRAJ NAV BAR-A -->



		<nav class="navbar navbar-inverse navbar-default">
			<div class="container-fluid">



				<form action="Film" method="post" class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" name="word" value="${param.word }" class="form-center">
					</div>
					<input type="hidden" name="pageName" value="<%= request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1)%>" >
					<button type="submit" name="akcija" value="search" class="btn btn-primary">search</button>
				</form>
				<h4 style="color: gold;text-align: right;">${msg }</h4>
			</div>
		</nav>




				



		<!-- LEVI MENI,CONTENT  -->
		<div class="container-fluid  text-center">
			<div  class="row " style="background: grey; " >
				<div class="col-md-5">
				
				</div>
				<div class="col-md-2 " style="height: 500px;">
					<br>
					<br>
					<form action="Admin" method="post">
						<div class="form-group" >
							<label for="naziv" >Naziv kategorije</label>
							<input type="text" name="naziv" class="form-control" value="${param.naziv}">
						</div>
							
						<div class="form-group">
							
							<input type="submit" name="akcija"  class="btn btn-default" value="unesi kategoriju">
						</div>
					</form>
					<h2 style="color: red;">${errmsg}</h2>
					<h2 style="color: red;">${succmsg}</h2>
					
					
				</div>


				<div class="col-md-5">
				</div>

			</div>
		</div>

				
		<footer class="container-fluid text-center">
			<p>
			<h2>Autor:</h2>
			Stefan Simonovic
			</p>
		</footer>
	</div>
</body>
<%
}else{
	response.sendRedirect("index.jsp");
}
%>
</html>