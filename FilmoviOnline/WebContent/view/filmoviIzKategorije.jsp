<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1 ">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <link href="../stilovi/style.css" rel="stylesheet" type="text/css">


<title>Prikaz  filmova po odabranoj kategoriji</title>
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
					<li class="active"><a href="index.jsp">Pocetna</a></li>
					<li><a href="#">Najnoviji filmovi</a></li>
					<li><a href="#">Top 10</a></li>
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



				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" class="form-center">
					</div>
					<button type="submit" class="btn btn-primary">search</button>
				</form>
			</div>
		</nav>

						<%-- <ul>
							<li ><a href="Kategorija?id=<%=k.getId()%>"><%=k.getNaziv() %></a>
							<li ><a href="Kategorija?id=<%=k.getId()%>">Komedija</a>
						
							<li ><a href="Kategorija?id=<%=k.getId()%>">Kriminal</a>
					
							<li ><a href="Kategorija?id=<%=k.getId()%>">Avantura</a>
						
							<li ><a href="Kategorija?id=<%=k.getId()%>">Naucna fantastika</a>
						
							<li ><a href="Kategorija?id=<%=k.getId()%>">Drama</a>
						
							<li ><a href="Kategorija?id=<%=k.getId()%>">Dokumentarni</a>
						
							<li ><a href="Kategorija?id=<%=k.getId()%>">Horor</a>
							
							<li ><a href="Kategorija?id=<%=k.getId()%>">Triler</a>
						</ul>
 --%>
		<!-- LEVI MENI,CONTENT  -->
		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-2 sidenav">
					<h2 class="h2">Kategorije</h2>
						<ul>
						<li ><a href="Film">Akcija</a>
						<li><a href="komedija.jsp">Komedija</a>
						
						<li><a href="kriminal.jsp">Kriminal</a>
					
						<li><a href="avantura.jsp">Avantura</a>
						
						<li><a href="fantastika.jsp">Naucna fantastika</a>
						
						<li><a href="drama">Drama</a>
						
						<li><a href="dokumentarni">Dokumentarni</a>
						
						<li><a href="horor">Horor</a>
						
						<li><a href="triler">Triler</a>
					</ul>

				</div>


				<div class="col-sm-10 text-center filmovi">
					<div class="col-sm-12 text-center">
						<h1 class="h2">Najgledaniji filmovi</h1>

					</div>
					<div class="col-sm-12 text-center">
						<div class="col-sm-3">
							<a href="Film?akcija=gledaj&id_filma=<% %>"><img alt="dead race 4"
								src="../slike/dead race 4.jpg" class=" img-thumbnail slika"></a>

						</div>
						<div class="col-sm-3">
							<a href="#"><img alt="primal rage"
								src="../slike/primal rage.jpg" class=" img-thumbnail slika"></a>


						</div>
						<div class="col-sm-3">
							<a href="#"><img alt="the commuter"
								src="../slike/the commuter.jpg" class=" img-thumbnail slika"></a>


						</div>
						<div class="col-sm-3">
							<a href="#"><img alt="The Strangers Prey at Night"
								src="../slike/The Strangers Prey at Night.jpg"
								class=" img-thumbnail slika"></a>


						</div>
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