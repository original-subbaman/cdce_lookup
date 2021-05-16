<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<style type="text/css"><%@include file="css/styles.css"%></style>
</head>
<body class="bg-dark">
	<div class="container bg-white pr-2 pl-2">
		<div style="margin-left: -15px; margin-right: -15px">
			<nav class='navbar navbar-expand-lg navbar-light shadow-sm p-2 mb-1 bg-white rounded'>
				<a class='navbar-brand text-dark' href='#' id="site-title"><strong>GMC Electoral Role Look Up</strong></a>
				<button class="navbar-toggler" data-toggle="collapse" data-target="#navbar-menu">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
				        	<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
				     	</li>
						<li class="nav-item">
							<a class="nav-link" href="about.jsp">About</a>
						</li>
					</ul>	
				</div>
			</nav>
		</div>
		
		<div>
			<div class="row mt-4 justify-content-center">
				<div class="col-8">
					<img src="img/cdce.jpg" class="img-fluid" alt="Responsive image">
				</div>
			</div>
			<div class="row mt-4 justify-content-center">
				<div class="col">
					<p class="text-center">
						This is a project of the Council of Democratic Civic Engagement (CDCE). If you find this site useful please follow us on 
						<a href="https://m.facebook.com/profile.php?id=100482738768494&ref=content_filter">Facebook</a> 
						and <a href="https://www.instagram.com/cdcesikkim/">Instagram.</a> <br>
						<br>
						All data is extracted from the public information published by the Sikkim Election Commission 
						<a href="http://secsikkim.com/?action=voterList2021" target="_blank">here 
						</a>and has been updated with the recent notification regarding Upper and Lower Sichey. <br>
						<br>
						Please contact us at <strong>cdcesikkim@gmail.com</strong> in case there are questions about the site or if you need assistance. All feedback are welcome.			
					</p>
				</div>
			</div>
		</div>
	</div>
	
		
	
</body>
</html>