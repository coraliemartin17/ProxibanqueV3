<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div class=row>
			<div class="col-sm-5"></div>
			<div class="col-sm-2">
				<div id="loginBox">
					<form role="form" class="form-horizontal" action="LoginServlet">
						<div class="form-group">
							<label for="login">Login:</label> <input class="form-control"
								type="text" name="login" required>
						</div>
						<div class="form-group">
							<label for="password">Password:</label> <input
								class="form-control" type="text" name="password" required>
						</div>
						<div class="form-group">
							<input type="submit" value="Valider">
						</div>
					</form>
					<div>
						<p class="text-center">
							<a href="user-form.jsp">Créer un compte utilisateur</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-sm-5"></div>
		</div>


	</div>


</body>
</html>