<%@page import="rs.model.Zanr"%>
<%@page import="java.util.ArrayList"%>
<%@page import="rs.model.Korisnik"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
/* HttpSession sesija = request.getSession();
Korisnik admin=(Korisnik)sesija.getAttribute("admin");

if(admin!=null){
	ArrayList<Zanr> zanrovi=(ArrayList)sesija.getAttribute("zanrovi"); */
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


<title>template</title>
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
						<li class="active"><a href="UnosFilmova.jsp">Unos filmova</a></li>
						<li ><a href="SviFilmovi.jsp">Svi filmovi</a></li>
						<li ><a href="UnosKategorija.jsp">Unos Kategorija</a></li>
						<li ><a href="SveKategorije.jsp">Sve kategorije </a></li>
					</ul>
				</div>
				<div class="col-md-3">
					<div class="col-md-6" >
						<p style="text-align: right;color: white">ADMIN</p>
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
				
				<div class="col-md-12">
					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" class="form-center">
						</div>
						<button type="submit" class="btn btn-primary">search</button>
					</form>
				</div>
			</div>
		</nav>


				



		<!-- LEVI MENI,CONTENT  -->
		<div class="container-fluid text-center">
			<div class="row " style="background: grey;color: black">
				<div class="col-md-5">
				
				</div>
				<div class="col-md-2">
					<h2>Unos filma:</h2>
					<form action="Film" method="post">
						<div class="form-group">
							<label>Naslov </label>
							<input type="text" name="naslov" class="form-control"> 
								
						</div>
						<div class="form-group">
							<label >Režiser</label> 
							<input type="text" name="reziser" class="form-control" >
						</div>
						<div class="form-group">
							<label >Godina</label>
							 <input type="text" name="godina" class="form-control" >
						</div>
						<div class="form-group">
							<label for="comment">Opis</label>
							<textarea class="form-control" rows="5" 
								name="opis"></textarea>
						</div>
						<div class="form-group">
							<label >Izaberi sliku <span class="textdanger">*</span></label>
							 <input type="file" name="slika"  required>
						</div>
						<div class="form-group">
							<label >Izaberi film<span class="textdanger">*</span></label>
							 <input type="file" name="film"  required>
						</div>
						<label> kategorija</label> 
						<div class="checkbox" style="text-align: left;">
							<label ><input type="checkbox" name="kategorija" value="">akcija</label><br>
							<label ><input type="checkbox" name="kategorija" value="">drama</label><br>
							<label ><input type="checkbox" name="kategorija" value="">komedija</label><br>
							<label ><input type="checkbox" name="kategorija" value="">triler</label><br>
						
						
						
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-default" value="Unesi film"
								name="unesi" />
						</div>
						<h2 style="color: red">${errmsg}</h2>
						<h2 style="color: red;">${succmsg}</h2>
					</form>
				</div>

					
				<div class= "col-md-5" >
				
				</div>

			</div>
		</div>

		<footer class="container-fluid text-center">
			<p>
			<h2>Autori:</h2>
			Stefan Simonovic<br>Branislav Kundovic<br>Viktor bisevac
			</p>
		</footer>
	</div>
</body>
<%/* }else{
response.sendRedirect("index");
} */
%>
</html>