<%@page import="rs.model.FilmVideoKategorija"%>
<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.Film"%>
<%@page import="rs.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%

HttpSession sesija = request.getSession();
Korisnik admin=(Korisnik)sesija.getAttribute("admin");

if(admin!=null){
	
	FilmVideoKategorija fv=(FilmVideoKategorija)sesija.getAttribute("film");
 	ArrayList<Zanr> lz=(ArrayList)sesija.getAttribute("zanrovi");//ZBOG PRIKAZA  SVIH KATEGORIJA
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


<title>izmena filmova</title>
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
		<div class="container-fluid text-center">
			<div class="row " style="background: grey;color: black">
				<div class="col-md-5">
					
				</div>
				
				<div class="col-md-2">
				<br>
					<form action="Admin" method="post">
						<div class="form-group">
							<label for="naziv">Naslov filma </label>
							<input type="text" name="naziv" class="form-control" value="<%=fv.getNazivFilma()%>"> 
								
						</div>
						<div class="form-group">
							<label for="reziser">Režiser</label> 
							<input type="text" name="reziser" class="form-control" value="<%=fv.getReziser()%>">
						</div>
						<div class="form-group">
							<label for="godina_premijere">Godina premijere</label>
							 <input type="text" name="godina_premijere" class="form-control" value="<%=fv.getGodinaPremijere()%>">
						</div>
						<div class="form-group">
							<label for="opis">Opis</label>
							<textarea class="form-control" rows="5" name="opis"  ><% out.println(fv.getOpis()); %></textarea>
						</div>
					<%-- 	
						<label for="kategorija"> kategorija</label> 
						<div class="checkbox" style="text-align: left;">
							<%for(Zanr z:lz) {%>
							<label for="kategorija"><input type="checkbox" name="kategorija" value="<%=z.getId() %>" ><%=z.getNaziv()%></label><br>
							<%} %>
						
						
						</div> --%>
						
						<div class="form-group">
							<label for="drzava">Drzava</label>
							 <input type="text" name="drzava" class="form-control" value="<%=fv.getDrzava()%>">
						</div>
					
						<div class="form-group">
							<label for="glumci">Glumci</label>
							 <textarea  name="glumci" class="form-control" rows="5" ><% out.println(fv.getGlumci());%></textarea>
						</div>
					
						
						<div class="form-group">
							<label for="jezik">Jezik</label>
							<input type="text" class="form-control" name="jezik" value=<%=fv.getJezik() %>>
						</div>
						<div class="form-group">
							<label for="url_videa">Url videa</label>
							<input type="text" class="form-control"  name="url_videa" value=<%=fv.getUrlVidea()%>>
						</div>
						<div class="form-group">
							<label for="url_prevoda">Url prevoda</label>
							<input type="text" class="form-control"  name="url_prevoda" value=<%=fv.getUrlPrevoda() %>>
						</div>
						<div class="form-group">
							<label for="url_slike">Url slike</label>
							<input type="text" class="form-control"  name="url_slike" value=<%=fv.getUrlSlike() %>>
						</div>
						<div class="form-group">
							<label for="vreme_trajanja">Vreme trajanja</label>
							<input type="text" class="form-control"  name="vreme_trajanja" value=<%=fv.getVremeTrajanja() %> placeholder="h:m:s">
						</div>
						<div class="form-group">
							
							<input type="hidden" name="id" value=<%=fv.getId_filma() %>>
						</div>
						<div class="form-group">
							<!-- <label for="id_videa">Id videa</label> -->
							<input type="hidden" class="form-control"  name="id_videa" value=<%=fv.getId_videa() %>>
						</div>
						<div class="form-group">
							<input type="submit" name="akcija" class="btn btn-default" value="izmeni film" />
						</div>
						
					</form>
					<h2 style="color: red">${errmsg}</h2>
					
					
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