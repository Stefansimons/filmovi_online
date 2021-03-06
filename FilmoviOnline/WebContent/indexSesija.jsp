<%@page import="rs.model.Film"%>
<%@page import="rs.model.SearchedFilm"%>
<%@page import="rs.model.DAO"%>
<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
HttpSession sesija = request.getSession();
Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");

if(ulogovani!=null){
	ArrayList<Zanr> zanrovi=(ArrayList)sesija.getAttribute("zanrovi");
	ArrayList<SearchedFilm> najnovijiF=(ArrayList)sesija.getAttribute("najnovijiFilmovi");
	ArrayList<Film> lf=(ArrayList)sesija.getAttribute("filmovi");//POSALJEM IZ SERVLETA SVE FILMOVE
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

<title>index</title>
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
						<li class="active"><a href="indexSesijaAdmin.jsp">Pocetna</a></li>
						<li><a href="Film?akcija=najnoviji">Najnoviji filmovi</a></li>
					
						
					</ul>
				</div>
				<div class="col-md-3">
					<div class="col-md-6" >
						<p style="text-align: right;color: white"><%=ulogovani.getIme() %></p>
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
						<input type="text" name="word" value="${param.word }"
							class="form-center">
					</div>
					<input type="hidden" name="pageName"
						value="<%=request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1)%>">
					<button type="submit" name="akcija" value="search"
						class="btn btn-primary">search</button>
				</form>
				<h4 style="color: gold; text-align: right;">${msg }</h4>
			</div>
		</nav>



		<!-- LEVI MENI,CONTENT  -->
		<div class="container-fluid fill text-center">
			<div class="row content">
				<div class="col-sm-2 sidenav">
					<h2 class="h2">Kategorije</h2>
						<ul>
							<% if(zanrovi!=null && zanrovi.size()>0){
								for(Zanr z:zanrovi){
							%>
							
							<li><a href="Kategorija?akcija=kat&id=<%=z.getId()%>"><%=z.getNaziv() %></a>
							<%}}else { %>
							<li>NEMA KATEGORIJA</li>
							<%} %>
						</ul>
					
				</div>


				<div class="col-sm-10 text-center ">
					<div class="col-sm-12 text-center ">
						

					</div>
					<div class="col-sm-12 text-center">
					<% if(lf!=null && lf.size()>0){ 
						for(Film f:lf){
					%>
						<div class="col-sm-3">
							<a href="Film?akcija=gledaj&id_videa=<%=f.getIdVidea() %>"><img alt="<%=f.getNaziv() %>"
								src="<%=f.getUrlSlike() %>" class=" img-thumbnail slika"></a>

						</div>
						<%}}else{ %>
						<div class="col-sm-3">
							<h3>NEMA FILMOVA</h3>

						</div>
						<%} %>
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
<%}else{
response.sendRedirect("index.jsp");
}
%>


</html>