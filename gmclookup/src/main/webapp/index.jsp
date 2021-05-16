<%@ page language="java" contentType="text/html"%>
<%@ page import="com.cdce_gmc.db.*,
				com.cdce_gmc.model.*,
				java.util.*" %>
<%! Boolean searchSuccess; %>
<%! HttpSession session; %>
<%! List<Voter> searchResults; %>
<%! Boolean isEmptyInput;  %>
<% 
	session = request.getSession();
	isEmptyInput = (Boolean) session.getAttribute("empty_input"); 
%>
<% searchSuccess = (Boolean) session.getAttribute("search_success"); %>
<% searchResults =  (List<Voter>) session.getAttribute("result"); %>
<!DOCTYPE html>
<html>
<head>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-PR1JJSBB1G"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-PR1JJSBB1G');
</script>
<title>GMC Electoral Roll Look Up</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">

<style type="text/css"><%@include file="css/styles.css"%></style>
</head>
<body class="bg-dark">
	
<div class='container bg-white pr-2 pl-2 overflow-auto'>
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
	
	<div id="intro" class="mt-4 mb-4">
		<p class="text-center">
			Use this site to confirm your name and the name of family and friends on the GMC, Electoral Roll 2021.<br>
			<br>
			Please try using ONLY your voter ID first. If this does not work try putting ONLY your name and then scrolling through the results. If you still 
			need help please contact us. 
		</p>	
	</div>
	
	<% if( isEmptyInput != null && isEmptyInput == true){ %>
			<div class="alert alert-danger alert-dismissible mb-2 ">
			    <button type="button" class="close" data-dismiss="alert">×</button>
			    <strong>Please input name OR name of a relation OR EPIC number before clicking search</strong>
			 </div>
	<% } %>
		
	<form class="m-4" accept-charset="utf-8" action="SearchVoterServlet" method="get">
		<div class="form-row">
			<div class="form-group mr-2">
				<div class="input-group mb-2">
					<input type="text" class="form-control" placeholder="Name" name="name" aria-label="Name" aria-describedby="basic-addon2">
				</div>	
			</div>
			
			<div class="form-group mr-2">
				<div class="input-group mb-2">
					<input type="text" class="form-control" placeholder="EPIC Number" name="epic" aria-label="EPIC Number" aria-describedby="basic-addon2">
				</div>	
			</div>
			
			<div class="form-group mr-2">
				<div class="input-group mb-2">
					<input type="text" class="form-control" placeholder="Name of Relation" name="relation" aria-label="Name of Relation" aria-describedby="basic-addon2">
				</div>	
			</div>
			<div class="form-group mr-2">
				<select id="inputWard" class="form-control" name="ward">
        			<option selected>All wards</option>
        			<%
        				for(Ward ward : WardDao.wardList){ 
    						out.println("<option>" + ward.getWardName() + "</option>"); 
        				}
        			%>
      			</select>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
	
	<div class="mt-4">
		<table class="table table-striped mt-4" id="voter_table">
			<thead>
				<tr>
					
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Name of Relation</th>
					<th scope="col">Ward</th>
					<th scope="col">Polling Station</th>
					<th scope="col">EPIC No</th>
				</tr>
			</thead>
			<tbody>
			<%
				if(searchResults != null && searchResults.size() > 0){
					for(Voter voter : searchResults){
			%>
						<tr>

							<td><%= voter.getName() %></td>
							<td><%= voter.getAge() %></td>
							<td><%= voter.getNameOfRelation() %></td>
							<td><%= voter.getWard() %>
							<td><%= voter.getPoll() %></td>
							<td><%= voter.getEpic() %></td>
						</tr>
			<% 
					}	
				}
			%>
			</tbody>
		</table>
	</div>

	<script>
		$(document).ready( function () {
			$('#voter_table').DataTable({
				"pageLength": 25,
				"ordering": false,
				"scrollY": 400,
				"language": {
					"search": "Filter records:"
				}
			}); 
		}); 
	</script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
	
	
	 
</div>
</body>
</html>