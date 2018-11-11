<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/* HttpSession sesija = request.getSession();
Korisnik ulogovani=(Korisnik)sesija.getAttribute("ulogovani");

if(ulogovani!=null){
	
	ArrayList<Zanr> lz=(ArrayList)sesija.getAttribute("zanrovi");
	Zanr za=(Zanr)request.getAttribute("nazivZanra");
	ArrayList<FilmVideoKategorija> lfvk=(ArrayList)request.getAttribute("filmoviByKat"); */
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


<title>template film</title>
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
						<p style="text-align: right;color: white">Ime</p>
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

				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-center">
					</div>
					<button type="submit" class="btn btn-primary">search</button>
				</form>
			</div>
		</nav>

		<!-- CONTENT FILM  -->
		<div class="container-fluid">
			<div class="row content"  style="color: white;text-align: left;">
				<div  class="col-md-12 " style="border: 2px solid;border-color: gold;">			
					<div class="col-md-3">
			<%-- 			<a href="Film?akcija=gledaj&id_videa=<%=fv.getId_videa() %>"><img alt="<%=fv.getNazivFilma() %>"
								src="<%=fv.getUrlSlike() %>" class=" img-thumbnail slika"></a>
			 --%>		</div>
					<div class="col-md-3">
					
					</div>
					<div class="col-md-3">
						
					</div>
					<div class="col-md-3">
						
					</div>
				</div>
				<div class="col-md-8">
					<video width="100%" height="700px" controls preload="metadata">
						<source src="videos/10,000_BC_(2008).mp4" type="video/mp4">
						<track src="subtitle/10,000_BC_(2008).vtt" kind="subtitles"
							srclang="sr" label="Serbian" default>
					</video>
				</div>
				<div class="col-md-8">
				
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
<%-- <%}else{
	response.sendRedirect("index.jsp");
} %> --%>
</html>