<%@ page language="java" contentType="text/html; charset=charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/styles.css">
<script src="jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>

<title>ProxiBanque SI</title>

</head>

<body class="bg_img">
	<div class="container-fluid">

		<div id="frontHead" class="page-header">
			<h1 class="text-center">ProxiBanqueSI</h1>
			<p class="text-center">Bienvenue sur ProxiBanque SI.</p>
		</div>

		<%
				if (request.getAttribute("message") == null) {
					request.setAttribute("message", new String(""));
				}

			%>

		<div class=row>
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form role="form" class="form-horizontal" action="CreateUser">
					<div class="form-group">
						<label for="login">Login:</label> <input class="form-control"
							type="text" name="login" required>
					</div>
					<div class="form-group">
						<label for="password">Password:</label> <input
							class="form-control" type="password" name="password" required>
					</div>
					<div class="form-group">
						<label for="nom">Nom:</label> <input class="form-control"
							type="text" name="nom">
					</div>
					<div class="form-group">
						<label for="prenom">Prenom:</label> <input class="form-control"
							type="text" name="prenom">
					</div>
					<div class="form-group">
<!-- 						<label for="selAgence">Agence:</label> -->
<!-- 						      <select class="form-control" id="selAgence"> -->
<!-- 						        <option>1</option> -->
<!-- 						        <option>2</option> -->
<!-- 						        <option>3</option> -->
<!-- 						        <option>4</option> -->
<!-- 						      </select> -->
						<div class="checkbox">
							<label class="checkbox-inline" for="gerant"><input type="checkbox" value="">Gerant</label> 
						</div>
					</div>
					<div class="form-group">
						<input type="submit" value="Valider">
					</div>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
		<div class="row">
			<p id="message" class="text-center"><%=request.getAttribute("message") %></p>
		</div>
		<div class="bottom">
			<a href="accueil.jsp"> <img width="40" src="accueil.png">
			</a>
		</div>
	</div>

</body>
</html>