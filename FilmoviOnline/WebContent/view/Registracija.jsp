<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1 ">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <link href="../stilovi/style.css" rel="stylesheet" type="text/css">


<title>Registracija</title>
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
					<li><a href="#">Najnoviji filmovi</a></li>
					<li><a href="#">Top 10</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="Registracija.jsp"><span class="glyphicon glyphicon-user"></span>
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



		<!-- LEVI MENI,CONTENT  -->
		<div class="container-fluid text-center">
			<div class="row content">
				<div class="col-sm-2 sidenav">
					<h2 class="h2">Kategorije</h2>
						<ul>
						<li ><a href="akcija.jsp">Akcija</a>
						<li><a href="#">Komedija</a>
						
						<li><a href="#">Kriminal</a>
					
						<li><a href="avantura.jsp">Avantura</a>
						
						<li><a href="#">Naucna fantastika</a>
						
						<li><a href="#">Drama</a>
						
						<li><a href="#">Dokumentarni</a>
						
						<li><a href="#">Horor</a>
						
						<li><a href="#">Triler</a>
					</ul>

				</div>
				


				<div class="col-sm-10 text-center ">
					<div class="col-sm-3">
					
					</div>
					<div class="col-sm-3" style="color: white; ">
						<h2 class="h2">Unesi podatke:</h2>
						<form action="/Registracija" method="post">
							<div class="form-group">
								<label for="ime" >Ime</label>
								<input type="text" name="ime" id="ime" class="form-control" value="${param.ime }" >
							</div>
							<div class="form-group">
								<label for="prezime" >Prezime</label>
								<input type="text" name="prezime" id="prezime" class="form-control" value="${param.prezime }" >
							</div>
							<div class="form-group">
								<label for="email">Email</label> 
								<input type="email" class="form-control" id="email" placeholder="name@example.com" >
							</div>
							<div class="form-group">
								<label for="user" >Username</label>
								<input type="text" name="user" id="user" class="form-control" value="${param.user }" >
							</div>
							<div class="form-group">
								<label for="password" >Password</label>
								<input type="password" name="pass" id="password" class="form-control" >
							</div>
							<div class="form-group">
								<label for="passP" >Potvrdi password</label>
								<input type="password" name="passP" id="passP" class="form-control" >
							</div>
							<div class="form-group">
							
								<input type="submit" name="akcija" id="submit" class="btn btn-default" value="Registruj se">
							</div>
						
					
						</form>	
						<h2 style="color: red;">${errmsgr}</h2>
					</div>
					
					
						
				</div>
			</div>
		</div>

		<footer class="container-fluid text-center">
			<p>
			<h2>Autori:</h2>
			Stefan Simonovic<br>Branislav Kundovic
			</p>
		</footer>

	</div>

</body>
</html>