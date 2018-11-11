<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
HttpSession sesija = request.getSession();
Korisnik admin=(Korisnik)sesija.getAttribute("admin");

if(admin!=null){
	
	ArrayList<Zanr> zanrovi=(ArrayList)sesija.getAttribute("zanrovi");
 
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
						<li><a href="Admin?akcija=unosKategorije">Unos Kategorija</a></li>
						<li  class="active"><a href="Admin?akcija=kategorije">Sve kategorije </a></li>
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
		<div class="container-fluid fill text-center">
			<div class="row " style="background: grey;color: black">
				<div class="col-md-3">
					<h2 style="color: red;">${succmsg}</h2><!-- USPESNA PROMENA KATEGORIJE -->
				</div>
				<div class="col-md-6" >
					<br><br>
					<table class="table table-striped table-bordered" style="text-align: left;background-color: white;"  >
						<%
						if(zanrovi!=null && zanrovi.size()>0){
						%>
						
						<tr >
							<th style="text-align: center;">Naziv kategorije</th>
							<th style="text-align: center;" colspan="2">Akcija</th>
						</tr>
						<%
						for(Zanr z:zanrovi){
						%>
						<tr >
							<td><%=z.getNaziv() %></td>
							<td><a href="Admin?akcija=izmenaKategorije&id=<%=z.getId() %>"  style="color: red">Izmeni</a></td>
							<td><a href="Admin?akcija=brisanjeKategorije&id=<%=z.getId() %>"  style="color: blue">Obrisi</a></td>
						</tr>
						<%}}else{%>
						<tr >
							<td colspan="2">${msg}</td>
							
						</tr>
						
						
						<% }%>	
						
					</table>
				</div>
					
				<div class= "col-md-3" >
				
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