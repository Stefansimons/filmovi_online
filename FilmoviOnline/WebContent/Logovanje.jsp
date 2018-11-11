<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%

DAO dao=new DAO();
ArrayList<Zanr> lz=dao.getZanrovi();
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


<title>logovanje</title>
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

				<ul class="nav navbar-nav">
					<li ><a href="index.jsp">Pocetna</a></li>
					<li><a href="Film?akcija=najnoviji">Najnoviji filmovi</a></li>
					
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="Registracija.jsp"><span class="glyphicon glyphicon-user"></span>
							Registracija</a></li>
					<li class="active"><a href="Logovanje.jsp"><span class="glyphicon glyphicon-log-in"></span>
							Logovanje</a></li>
				</ul>
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
			<div class="row content ">
				<div class="col-sm-2 sidenav">
					<h2 class="h2">Kategorije</h2>
						<ul>
							<% if(lz!=null && lz.size()>0){
								for(Zanr z:lz){
							%>
							
							<li><a href="Kategorija?akcija=kat&id=<%=z.getId()%>"><%=z.getNaziv() %></a>
							<%}}else { %>
							<li>NEMA KATEGORIJA</li>
							<%} %>
						</ul>
				</div>


				<div class="col-sm-10  text-center " >
					<div class="col-sm-3">
					
					</div>
					<div class="col-sm-3 " style="color: white;">
						<span style="color: red;">${succmsg}</span>
						<h2 class="h2">Unesi podatke:</h2>
						<form action="Login" method="post">
							<div class="form-group">
								<label for="user" >Username</label>
								<input type="text" name="username" id="username" class="form-control" value="${param.username }">
							</div>
							<div class="form-group">
								<label for="user" >Password</label>
								<input type="password" name="pass" id="password" class="form-control" value="${param.pass }">
							</div>
							<div class="form-group">
							
								<input type="submit" name="akcija" id="submit" class="btn btn-default" value="prijava">
							</div>
						
					
						</form>	
						<h2 style="color: red;">${errmsgl}</h2>
					</div>
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
</html>