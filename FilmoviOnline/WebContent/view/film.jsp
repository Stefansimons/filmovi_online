<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//NA OVOJ STRANI SE PRIHVATA FILM I GLEDA SE(SVI FILMOVI!!!)


%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1 ">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <link href="../stilovi/style.css" rel="stylesheet" type="text/css">

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
		<!-- NAV BAR -->

		<nav class="navbar navbar-inverse navbar-default">
			<div class="container-fluid">

				<ul class="nav navbar-nav">
					<li ><a href="../index.jsp">Pocetna</a></li>
					<li><a href="#">Najnoviji filmovi</a></li>
					<li><a href="#">Top 10</a></li>
				</ul>

			
				
					
				
			</div>
		</nav>
		<!-- KRAJ NAV BAR-A -->



		
		<nav class="navbar navbar-inverse navbar-default">
			<div class="container-fluid">
				<div class="col-md-3">
					<div class="col-md-6" >
						<label style="text-align: right;color: white">KORISNICKO IME ULOGOVANOG</label>
					</div>
					<div class="col-md-6" >
						<a href="Login" style="color: green;">LOGOUT</a>
					</div>
				</div>
				<div class="col-md-9">
					<form class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" class="form-center">
						</div>
						<button type="submit" class="btn btn-primary">search</button>
					</form>
				</div>
			</div>
		</nav>




				



		<!-- CONTENT FILM  -->
		<div class="container-fluid">
			<div class="row content">
		

				<div class="col-sm-12  filmContent">
					<div class="col-sm-12 text-center">
						<h1 class="h2">Naziv filma</h1>

					</div>
					<div class="col-sm-12 text-center " style="border: 2px;border-color: red;">
						<h1 id="opisFilma">OPIS FILMA</h1>
					</div>
					<div class="col-sm-12 text-center " style="border: 2px;border-color: green;">
						<h1 id="video">VIDEO</h1>
						<video width="320" height="240" controls>
						 	<source src="../videi/Nueve Reinas (2000) - Trailer.avi" type="video/mp4"> 
							<!--  <track src="subtitles_en.vtt" kind="subtitles" srclang="en" label="English">  -->
						 </video>
					</div>
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
</html>