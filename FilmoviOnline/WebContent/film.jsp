<%@page import="rs.model.KorisnikVideoKomentar"%>
<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.FilmVideoKategorija"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

HttpSession sesija=request.getSession();


	ArrayList<Zanr> lz=(ArrayList)sesija.getAttribute("kategorije");
	ArrayList<Zanr> filmKat=(ArrayList)sesija.getAttribute("filmKat");
	
	FilmVideoKategorija fv=(FilmVideoKategorija)sesija.getAttribute("film");
	
	ArrayList<KorisnikVideoKomentar> lk =(ArrayList)sesija.getAttribute("komentari");

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

<title> film</title>
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

				<ul class="nav navbar-nav">
					<li ><a href="index.jsp">Pocetna</a></li>
					<li><a href="Film?akcija=najnoviji">Najnoviji filmovi</a></li> 
				
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="Registracija.jsp"><span class="glyphicon glyphicon-user"></span>
							Registracija</a></li>
					<li><a href="Logovanje.jsp"><span class="glyphicon glyphicon-log-in"></span>
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

		<!-- CONTENT FILM  -->
		<div class="container-fluid">
			<div class="row content"  style="color: white;text-align: left;">
				<div  class="col-md-12 " style="border: 2px solid;border-color: gold;">			
					<div class="col-md-3">
						<a href="Film?akcija=gledaj&id_videa=<%=fv.getId_videa() %>"><img alt="<%=fv.getNazivFilma() %>"
								src="<%=fv.getUrlSlike() %>" class=" img-thumbnail slika"></a>
					</div>
					<div class="col-md-3">
						<h4 style="color: gold;">Naziv filma</h4>
						<%=fv.getNazivFilma()%>
						<h4 style="color: gold;">Drzava</h4>
						<%=fv.getDrzava()%>
						<h4 style="color: gold;">Reziser</h4>
						<%=fv.getReziser()%>
						<h4 style="color: gold;">Godina premijere</h4>
						<%=fv.getGodinaPremijere()%>
						<h4 style="color: gold;">Jezik</h4>
						<%=fv.getJezik()%>
					</div>
					<div class="col-md-3">
						<h4 style="color: gold;">Opis</h4>
						<%=fv.getOpis()%>
						<h4 style="color: gold;">Glumci</h4>
						<%=fv.getGlumci()%>

					</div>
					<div class="col-md-3">
						<h4 style="color: gold;">Kategorije</h4>
						<%if(filmKat!=null && filmKat.size()>0){ %>
						<ul>
						<%for(Zanr z:filmKat){ %>
							<li><%=z.getNaziv() %>
						<%} %>
						</ul>
						<%}else{ %>
						Nema kategorije
						<%} %>
					
					</div>
				</div>
				<div class="col-md-8">
					<video width="800px" controls preload="metadata">
						<source src="<%=fv.getUrlVidea()%>" type="video/mp4">
						<track src="<%=fv.getUrlPrevoda()%>" kind="subtitles"
							srclang="sr" label="Serbian" default>
					</video>
				</div>
				<div class="col-md-4">
					
				</div>
				
			</div>	
			
			<div class="row content"  style="text-align: left;">
				
				<div class="col-md-6">
				<br><br><br>
					<form action="Komentar" method="post">
						<input type="hidden" name="videoId" value="<%= fv.getId_filma()%>">
						<button type="submit" name="akcija" value="komentar" class="btn btn-primary">Dodaj komentar</button>
						
						<div class="form-group">
							<label for="comment"></label>
							<textarea name="kom" class="form-control" rows="7" id="comment"></textarea>
						</div>

					</form>
					<h4 style="color: red;">${msglog}</h2>
					<h4 style="color: blue;">${linkZaLog }</h4>
					
				</div>
				<div class="col-md-6">
				
				
				</div>
			</div>
			<div class="row content"  style="text-align: left;">
				<h5 style="color: gold;">KOMENTARI</h5>
				<%
					if (lk != null && lk.size() > 0) {
						for (KorisnikVideoKomentar k : lk) {
				%>
			
				<div class="col-md-12" style="color: white;" >
					<h3><%=k.getUsername()%></h3>
					<p><%=k.getSadrzaj()%></p><br>
					<h5 style="color: gold;">Datum objave</h5>
					<p><%=k.getDatumObjave() %>
				</div>
				

				<%
					}
					} else {
				%>
				<div class="col-md-6">
				<h3 style="color: gold;">${msgkomentari}</h3>
				
				</div>
				
				<%
					}
				%>
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